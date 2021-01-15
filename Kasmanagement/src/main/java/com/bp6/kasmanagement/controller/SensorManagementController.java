/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.model.BodemVochtigheidSensor;
import com.bp6.kasmanagement.model.LichtSensor;
import com.bp6.kasmanagement.model.LuchtVochtigheidSensor;
import com.bp6.kasmanagement.model.TempratuurSensor;
import com.bp6.kasmanagement.model.WindSensor;
import com.bp6.kasmanagement.view.SensorManagementScherm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dahir
 */
public class SensorManagementController {
    
    private SensorManagementScherm sensorManagementScherm;
    private ObservableList<TempratuurSensor> BinnenTempArray;
    private ObservableList<TempratuurSensor> BuitenTempArray;
    private ObservableList<LuchtVochtigheidSensor> BinnenLuchtArray;
    private ObservableList<LuchtVochtigheidSensor> BuitenLuchtArray;
    private ObservableList<WindSensor> WindArray;
    private ObservableList<LichtSensor> LichtArray;
    private ObservableList<BodemVochtigheidSensor> BodemArray;
    
    // Constructor
    public SensorManagementController(SensorManagementScherm sensorManagementScherm){
        
        BinnenTempArray = FXCollections.observableArrayList();
        BuitenTempArray = FXCollections.observableArrayList();
        BinnenLuchtArray = FXCollections.observableArrayList();
        BuitenLuchtArray = FXCollections.observableArrayList();
        WindArray = FXCollections.observableArrayList();
        LichtArray = FXCollections.observableArrayList();
        BodemArray = FXCollections.observableArrayList();
        this.sensorManagementScherm= sensorManagementScherm;
    }
    
    public void getKasnummerEnLocatie(){
        Connection con1 = null;
        
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT distinct kasNummer FROM sensorlocatie");
                     while(result.next()){    
                        
                    Integer strKasNummer = result.getInt("kasNummer");
                    sensorManagementScherm.getKasToevoegen().getItems().add(strKasNummer);
                        }
                    
                    ResultSet result1 = stat.executeQuery("SELECT distinct locatie FROM sensorlocatie");
                    
                    while(result1.next()){
                    String strLocatie = result1.getString("locatie");
                    sensorManagementScherm.getLocatieToevoegen().getItems().add(strLocatie);
                    }
                    
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
    }
    
   public void SetNieuweSensor(){
       Connection con1 = null;
       
       try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    
                    
                    String strKasToevoegen = sensorManagementScherm.getKasToevoegen().getSelectionModel().getSelectedItem().toString();
                    String strLocatieToevoegen = sensorManagementScherm.getLocatieToevoegen().getSelectionModel().getSelectedItem().toString();
                    int IntKastoevoegen=Integer.parseInt(strKasToevoegen);
                    String strTypeToevoegen = sensorManagementScherm.getTf_toevoegen().getText();
                    
                    ResultSet resultSensorId = 
                    stat.executeQuery("SELECT MAX(sensorId) oldid FROM sensorlocatie");
                    Integer IntegerSensorId = 0;
                    
                    while(resultSensorId.next()){    
                        
                    Integer strSensorId = resultSensorId.getInt("oldid");
                    IntegerSensorId = strSensorId + 1;
                    
                        }
                    stat.executeUpdate("INSERT INTO sensorlocatie VALUES (" + IntegerSensorId + " ,'" + IntKastoevoegen + "','" + strLocatieToevoegen + "','" + strTypeToevoegen + "')");

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
                
            
   }
    
    public ObservableList<TempratuurSensor> getBinnenTempratuurData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultTempInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "tempratuursensor.tempInput,\n" +
                    "tempratuursensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN tempratuursensor ON tempratuursensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE tempInput IS NOT NULL\n"
                    + "ORDER BY tempratuursensor.datumTijd DESC LIMIT 12");
                    
                while(resultTempInput.next()){
                       
                        String strLocatie = resultTempInput.getString("locatie");
                        String strType= resultTempInput.getString("type");
                        String strInput= resultTempInput.getString("tempInput");
                        String strDatumTijd= resultTempInput.getString("datumTijd");
                        
                        if(strLocatie.equals("binnen")){
                            TempratuurSensor binnenTempratuurSensor = new TempratuurSensor(strLocatie,strType,strInput,strDatumTijd);
                            BinnenTempArray.add(binnenTempratuurSensor);
                            
                        }
                        
                        
                        
                        
                    }
          
                        
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
     
        
        return BinnenTempArray;
    }
    
    public ObservableList<TempratuurSensor> getBuitenTempratuurData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultTempInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "tempratuursensor.tempInput,\n" +
                    "tempratuursensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN tempratuursensor ON tempratuursensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE tempInput IS NOT NULL\n"
                    + "ORDER BY tempratuursensor.datumTijd DESC LIMIT 12");
                    
                while(resultTempInput.next()){
                       
                        String strLocatie = resultTempInput.getString("locatie");
                        String strType= resultTempInput.getString("type");
                        String strInput= resultTempInput.getString("tempInput");
                        String strDatumTijd= resultTempInput.getString("datumTijd");
                        
                       
                        if(strLocatie.equals("buiten")){
                            TempratuurSensor buitenTempratuurSensor = new TempratuurSensor(strLocatie,strType,strInput,strDatumTijd);
                            BuitenTempArray.add(buitenTempratuurSensor);
                            
                        }
                        
                    }
          
                        
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
        
        return BuitenTempArray;
    }
    
    public ObservableList<LuchtVochtigheidSensor> getBinnenLuchtVochtigheidData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultLuchtVochtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "luchtvochtsensor.luchtVochtInput,\n" +
                    "luchtvochtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN luchtvochtsensor ON luchtvochtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE luchtVochtInput IS NOT NULL\n"
                    + "ORDER BY luchtvochtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultLuchtVochtInput.next()){
                       
                        String strLocatie = resultLuchtVochtInput.getString("locatie");
                        String strType= resultLuchtVochtInput.getString("type");
                        String strInput= resultLuchtVochtInput.getString("luchtVochtInput");
                        String strDatumTijd= resultLuchtVochtInput.getString("datumTijd");
                        
                        if(strLocatie.equals("binnen")){
                            LuchtVochtigheidSensor binnenLuchtSensor = new LuchtVochtigheidSensor(strLocatie,strType,strInput,strDatumTijd);
                            BinnenLuchtArray.add(binnenLuchtSensor);
                            
                        }
                        
                      }
          
                        
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
        return BinnenLuchtArray;
    }
    
    public ObservableList<LuchtVochtigheidSensor> getBuitenLuchtVochtigheidData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultLuchtVochtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "luchtvochtsensor.luchtVochtInput,\n" +
                    "luchtvochtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN luchtvochtsensor ON luchtvochtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE luchtVochtInput IS NOT NULL\n"
                    + "ORDER BY luchtvochtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultLuchtVochtInput.next()){
                       
                        String strLocatie = resultLuchtVochtInput.getString("locatie");
                        String strType= resultLuchtVochtInput.getString("type");
                        String strInput= resultLuchtVochtInput.getString("luchtVochtInput");
                        String strDatumTijd= resultLuchtVochtInput.getString("datumTijd");
                        
                       
                        if(strLocatie.equals("buiten")){
                            LuchtVochtigheidSensor buitenLuchtSensor = new LuchtVochtigheidSensor(strLocatie,strType,strInput,strDatumTijd);
                            BuitenLuchtArray.add(buitenLuchtSensor);
                        }
                      }
          
                        
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
        return BuitenLuchtArray;
    }
    
    public ObservableList<WindSensor> getWindData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultWindInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "windsensor.windInput,\n" +
                    "windsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN windsensor ON windsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE windInput IS NOT NULL\n"
                    + "ORDER BY windsensor.datumTijd DESC LIMIT 12");
                    
                while(resultWindInput.next()){
                       
                        String strLocatie = resultWindInput.getString("locatie");
                        String strType= resultWindInput.getString("type");
                        String strInput= resultWindInput.getString("windInput");
                        String strDatumTijd= resultWindInput.getString("datumTijd");
                        
                        WindSensor windSensor = new WindSensor(strLocatie,strType,strInput,strDatumTijd);
                        WindArray.add(windSensor);
                        
                        
                      }
          
                        
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
        return WindArray;
    }
    
    public ObservableList<LichtSensor> getLichtData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultLichtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "lichtsensor.lichtInput,\n" +
                    "lichtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN lichtsensor ON lichtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE lichtInput IS NOT NULL\n"
                    + "ORDER BY lichtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultLichtInput.next()){
                       
                        String strLocatie = resultLichtInput.getString("locatie");
                        String strType= resultLichtInput.getString("type");
                        String strInput= resultLichtInput.getString("lichtInput");
                        String strDatumTijd= resultLichtInput.getString("datumTijd");
                        
                        LichtSensor lichtSensor = new LichtSensor(strLocatie,strType,strInput,strDatumTijd);
                        LichtArray.add(lichtSensor);
                        
                        
                      }
          
                        
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
        return LichtArray;
    }
    
    public ObservableList<BodemVochtigheidSensor> getBodemVochtigheidData(){
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultBodemVochtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "bodemvochtsensor.bodemvochtInput,\n" +
                    "bodemvochtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN bodemvochtsensor ON bodemvochtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE bodemvochtInput IS NOT NULL\n"
                    + "ORDER BY bodemvochtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultBodemVochtInput.next()){
                       
                        String strLocatie = resultBodemVochtInput.getString("locatie");
                        String strType= resultBodemVochtInput.getString("type");
                        String strInput= resultBodemVochtInput.getString("bodemvochtInput");
                        String strDatumTijd= resultBodemVochtInput.getString("datumTijd");
                        
                        BodemVochtigheidSensor bodemSensor = new BodemVochtigheidSensor(strLocatie,strType,strInput,strDatumTijd);
                        BodemArray.add(bodemSensor);
                        
                        
                        
                      }
          
                        
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
        return BodemArray;
    }
}
