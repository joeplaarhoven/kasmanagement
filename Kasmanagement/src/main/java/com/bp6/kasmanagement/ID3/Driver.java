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

	public Driver() {
            Connection con1 = null;
//            try{
//            
//            con1 = DBCPDataSource.getConnection();
//            Statement stat = con1.createStatement();
//            
//            ResultSet resultTempInput = stat.executeQuery("SELECT SensorLocatie.sensorId,\n" +
//                "SensorLocatie.kasNummer,\n" +
//                "bodemvochtsensor.bodemVochtigheidInput,\n" +
//                "LichtSensor.lichtInput,\n" +
//                "SensorLuchtVochtWaarde.luchtVochtInput,\n" +
//                "SensorTempWaarde.tempInput,\n" +
//                "WindSensor.windInput\n" +
//                "FROM SensorLocatie\n" +
//                "LEFT JOIN BodemVochtigheid ON SensorLocatie.sensorId = BodemVochtigheid.sensorId\n" +
//                "LEFT JOIN LichtSensor ON SensorLocatie.sensorId = LichtSensor.sensorId\n" +
//                "LEFT JOIN SensorLuchtVochtWaarde ON SensorLocatie.sensorId = SensorLuchtVochtWaarde.sensorId\n" +
//                "LEFT JOIN SensorTempWaarde ON SensorLocatie.sensorId = SensorTempWaarde.sensorId\n" +
//                "LEFT JOIN WindSensor ON SensorLocatie.sensorId = WindSensor.sensorId");
//                    
//                while(resultTempInput.next()){
//                       
//                        Integer strSensorId = resultTempInput.getInt("sensorId");
//                        String strKasNummer = resultTempInput.getString("kasNummer");
//                        String strBodemVochtigheidInput= resultTempInput.getString("bodemVochtigheidInput");
//                        String strLichtInput = resultTempInput.getString("lichtInput");
//                        String strLuchtVochtInput = resultTempInput.getString("luchtVochtInput");
//                        String strTempInput = resultTempInput.getString("tempInput");
//                        String strWindInput= resultTempInput.getString("windInput");
//                        
//                        // Our example data
//                        List<List<String>> rows = Arrays.asList(
//                            Arrays.asList(strBodemVochtigheidInput,strLichtInput,strLuchtVochtInput,strTempInput,strWindInput)
//                        );
//                        try{
//                            FileWriter csvWriter = new FileWriter("sensorData.csv");
//                            csvWriter.append("bodemVocht");
//                            csvWriter.append(",");
//                            csvWriter.append("licht");
//                            csvWriter.append(",");
//                            csvWriter.append("luchtVocht");
//                            csvWriter.append(",");
//                            csvWriter.append("temp");
//                            csvWriter.append(",");
//                            csvWriter.append("wind");
//                            csvWriter.append("\n");
//
//                            for (List<String> rowData : rows) {
//                                csvWriter.append(String.join(",", rowData));
//                                csvWriter.append("\n");
//                            }
//
//                            csvWriter.flush();
//                            csvWriter.close();
//                        }
//                        catch(IOException e){
//                            System.out.println(e);
//                        }
//                        
//                        
//                        
//                        
//                    }
//          
//                        
//                    } catch (SQLException se) {
//                    se.printStackTrace();
//                        } 
//                      finally {
//                            try {
//                                con1.close();
//                              } 
//                            catch (Exception e) {
//                              }
//                      }
		
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
                HashMap<String, String> input = new HashMap<String, String>();
                input.put("bodemVocht", "laag");
                input.put("licht", "hoog");
                input.put("luchtVocht", "goed");
                input.put("temp", "laag");
                input.put("wind", "laag");
                predict(input, rootnode);
                
                
		


	}
        
        public String predict(HashMap<String, String> data, Node node){
            String results = "";
            String col = node.getData();
            List<Node> childeren;
            
            String top = data.get(node.getData());
            childeren = node.getChildren();
            
            
            System.out.println(col);
            System.out.print("Value: ");
            System.out.println(top);
            for(Node child: childeren){
                if(child.getData().equals("true") || child.getData().equals("false"))
                System.out.println(child.getData());
                if(child.getData().equals(top)){
                    childeren = child.getChildren();
                    
                    for(Node child1: childeren){
                       
                        if(child1.getData().equals("true") || child1.getData().equals("false")){
                            
                            System.out.println(" .");
                            System.out.println(" .");
                            System.out.println(" .");
                            System.out.println(" .");
                            System.out.println(" .");
                            results = child1.getData();
                            System.out.print(results);
                        }
                        else{
                             predict(data, child1);
                        }
                    }
                    
                }
            }
            
            
            
            return results;
        }
        
        
        

}

