/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.ID3;

/**
 *
 * @author laarh
 */
import com.bp6.kasmanagement.controller.DBCPDataSource;
import com.bp6.kasmanagement.model.BodemVochtigheidSensor;
import com.bp6.kasmanagement.model.IdealeGroei;
import com.bp6.kasmanagement.model.TempratuurSensor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Iterator;

public class Driver {
    
//	static final String filepath = "C:/Users/admin/Dropbox/Oracle/AI/play.csv";
        IdealeGroei idealeGroei;
        HashMap<String, String> input;
        
        Node node;
	public Driver() {
            
	}
        
        public String runID3(int kasNummer){
            Connection con1 = null;
            try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            
            
            ResultSet idealeWaardes = stat.executeQuery("SELECT * FROM idealegroei\n" +
                "WHERE product = (SELECT product from kas where kasNummer = " + kasNummer + ");");
            
             while(idealeWaardes.next()){
                       
                        int tempIdeaal = idealeWaardes.getInt("tempIdeaal");
                        int vochtIdeaal= idealeWaardes.getInt("vochtIdeaal");
                        int lichtIdeaal= idealeWaardes.getInt("lichtIdeaal");
                        int bodemVochtIdeaal= idealeWaardes.getInt("bodemVochtIdeaal");
                        
                        idealeGroei = new IdealeGroei(tempIdeaal,vochtIdeaal,lichtIdeaal,bodemVochtIdeaal);
                        
                      }
            
            ResultSet resultLuchtVochtInput = stat.executeQuery("SELECT luchtVochtInput\n" +
                "FROM   luchtvochtsensor\n" +
                "WHERE sensorId in (select sensorId FROM sensorlocatie WHERE locatie = 'binnen' and kasNummer = "+kasNummer+" and type = 'luchtvochtigheid')\n"+
                "ORDER  BY datumTijd DESC\n" +
                "LIMIT  1;");
            
            int luchtVocht = 0;
            String luchtVochtCat = "";
            while(resultLuchtVochtInput.next()){   
                luchtVocht = resultLuchtVochtInput.getInt("luchtVochtInput");
            }
            
            if(luchtVocht < (idealeGroei.getVochtIdeaal() - 5)){
                luchtVochtCat = "laag";
            }
            else if(luchtVocht > (idealeGroei.getVochtIdeaal() + 5)){
                 luchtVochtCat = "hoog";
            }
            else{
                luchtVochtCat = "goed";
            }
            
            
            
            ResultSet resultLichtInput = stat.executeQuery("SELECT lichtInput\n" +
                "FROM   lichtsensor\n" +
                "WHERE sensorId in (select sensorId FROM sensorlocatie WHERE locatie = 'binnen' and kasNummer = "+kasNummer+" and type = 'licht1    1')\n"+
                "ORDER  BY datumTijd DESC\n" +
                "LIMIT  1;");
            
            int licht = 0;
            String lichtCat = "";
            while(resultLichtInput.next()){   
                licht = resultLichtInput.getInt("lichtInput");
            }
            
            
            if(licht < (idealeGroei.getLichtIdeaal() - 75)){
                lichtCat = "laag";
            }
            else if(licht > (idealeGroei.getLichtIdeaal() + 75)){
                 lichtCat = "hoog";
            }
            else{
                lichtCat = "goed";
            }
            
            ResultSet resultBodemVochtInput = stat.executeQuery("SELECT bodemVochtInput\n" +
                "FROM   bodemvochtsensor\n" +
                "WHERE sensorId in (select sensorId FROM sensorlocatie WHERE locatie = 'binnen' and kasNummer = "+kasNummer+" and type = 'bodemvochtigheid')\n"+
                "ORDER  BY datumTijd DESC\n" +
                "LIMIT  1;");
            
            int bodemVocht = 0;
            String bodemVochtCat;
            while(resultBodemVochtInput.next()){   
                bodemVocht = resultBodemVochtInput.getInt("bodemVochtInput");
            }
            
            
            if(bodemVocht < (idealeGroei.getBodemVochtIdeaal() - 10)){
                bodemVochtCat = "laag";
            }
            else if(bodemVocht > (idealeGroei.getBodemVochtIdeaal() + 10)){
                 bodemVochtCat = "hoog";
            }
            else{
                bodemVochtCat = "goed";
            }
            
            ResultSet resultTempInput = stat.executeQuery("SELECT tempInput\n" +
                "FROM   tempratuursensor\n" +
                "WHERE sensorId in (select sensorId FROM sensorlocatie WHERE locatie = 'binnen' and kasNummer = "+kasNummer+" and type = 'temperatuur')\n"+
                "ORDER  BY datumTijd DESC\n" +
                "LIMIT  1;");
            
            int temp = 0;
            String tempCat;
            while(resultTempInput.next()){   
                temp = resultTempInput.getInt("tempInput");
            }
            
            
            if(temp < (idealeGroei.getTempIdeaal() - 5)){
                tempCat = "laag";
            }
            else if(temp > (idealeGroei.getTempIdeaal() + 5)){
                 tempCat = "hoog";
            }
            else{
                tempCat = "goed";
            }
            
            input = new HashMap<String, String>();
                input.put("bodemVocht", bodemVochtCat);
                input.put("licht", lichtCat);
                input.put("luchtVocht", luchtVochtCat);
                input.put("temp", tempCat);
                        
                } catch (SQLException se) {
                se.printStackTrace();
                    } 
                  finally {
                        try {
                            con1.close();
                          } 
                        catch (Exception e) {
                          }
                 }
     

            ID3 id3 = new ID3();
            try {
                id3.rawdata = id3.loadCSV("sensorData.csv");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
		id3.printArrayList(id3.rawdata);
		
		id3.runID3(id3.rawdata,null);
                
		
		
		System.out.println("\nDisplaying Tree\n");
		Node rootnode = id3.tree.getRoot();
                
                
		rootnode.print("",true);
                String result = predict(input, rootnode);
                
                return result;
        }
        String results;
        public String predict(HashMap<String, String> data, Node node){
            if(results == null){
                String col = node.getData();
                List<Node> childeren;

                String top = data.get(node.getData());
                childeren = node.getChildren();


                for(Node child: childeren){
                    System.out.println(child.getData());

                    if(child.getData().equals(top)){
                        childeren = child.getChildren();

                        for(Node child1: childeren){


                            if(child1.getData().equals("goed") || child1.getData().equals("fout")){
                                System.out.println(child1.getData());
                                results = child1.getData();
                                
                            }
                            else{
                                 predict(data, child1);
                            }
                        }

                    }
                    
                }
                return results;
            }
            else{
                return "onbekend";
            }
            
        }
        
        
        

}

