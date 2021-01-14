/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.text.Text;

/**
 *
 * @author dahir
 */
public class ToestemmingController {
    
    private Text testText = new Text("test");

    
    
    public ToestemmingController(){
        
    }
    
    
    
    public String setWindToestemming(){
        Connection con1 = null;
        String resultWindString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT windInput,datumTijd FROM windsensor order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                    
                    Integer intWindInput = result.getInt("windInput");
                    
                    
                    if(intWindInput < 11){                     
                        resultWindString= "te laag";
                    }
                    
                    if(intWindInput > 10 && intWindInput < 20){
                        resultWindString= "goed";
                    }
                    
                    if(intWindInput > 20){
                        resultWindString= "te hoog";
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
     return resultWindString;   
    }

    
    
    public String setLichtToestemming(){
        Connection con1 = null;
        String resultLichtString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT lichtInput,datumTijd FROM lichtsensor order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                    
                    Integer intlichtInput = result.getInt("lichtInput");
                    

                    if(intlichtInput < 11){                     
                        resultLichtString= "te laag";
                    }
                    
                    if(intlichtInput > 10 && intlichtInput < 20){
                        resultLichtString= "goed";
                    }
                    
                    if(intlichtInput > 20){
                        resultLichtString= "te hoog";
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
        return resultLichtString;
    }
    
    public String setBodemVochtToestemming(){
        Connection con1 = null;
        String resultBodemVochtString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT bodemVochtInput,datumTijd FROM bodemvochtsensor order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                   
                    Integer intbodemVochtInput = result.getInt("bodemVochtInput");
                    
                    
                    if(intbodemVochtInput < 11){                     
                        resultBodemVochtString= "te laag";
                    }
                    
                    if(intbodemVochtInput > 10 && intbodemVochtInput < 20){
                        resultBodemVochtString= "goed";
                    }
                    
                    if(intbodemVochtInput > 20){
                        resultBodemVochtString= "te hoog";
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
        return resultBodemVochtString;
    }

    
    public String setBinnenTempratuurToestemming(){
        Connection con1 = null;
        String resultBinnenTempString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT tempInput,datumTijd FROM tempratuursensor where sensorId = 1 order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                   
                    Integer intbinnenTempInput = result.getInt("tempInput");
                    
                    
                    if(intbinnenTempInput < 11){                     
                        resultBinnenTempString= "te laag";
                    }
                    
                    if(intbinnenTempInput > 10 && intbinnenTempInput < 20){
                        resultBinnenTempString= "goed";
                    }
                    
                    if(intbinnenTempInput > 20){
                        resultBinnenTempString= "te hoog";
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
        return resultBinnenTempString;
    }
    
    public String setBuitenTempratuurToestemming(){
        Connection con1 = null;
        String resultBuitenTempString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT tempInput,datumTijd FROM tempratuursensor where sensorId = 2 order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                   
                    Integer intbuitenTempInput = result.getInt("tempInput");
                    
                    
                    if(intbuitenTempInput < 11){                     
                        resultBuitenTempString= "te laag";
                    }
                    
                    if(intbuitenTempInput > 10 && intbuitenTempInput < 20){
                        resultBuitenTempString= "goed";
                    }
                    
                    if(intbuitenTempInput > 20){
                        resultBuitenTempString= "te hoog";
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
        return resultBuitenTempString;
        
    }
    
    public String setBinnenLuchtVochtigheidToestemming(){
     Connection con1 = null;
        String resultBinnenLuchtString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT luchtVochtInput,datumTijd FROM luchtvochtsensor where sensorId = 3 order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                   
                    Integer intbinnenLuchtInput = result.getInt("luchtVochtInput");
                    
                    
                    if(intbinnenLuchtInput < 11){                     
                        resultBinnenLuchtString= "te laag";
                    }
                    
                    if(intbinnenLuchtInput > 10 && intbinnenLuchtInput < 20){
                        resultBinnenLuchtString= "goed";
                    }
                    
                    if(intbinnenLuchtInput > 20){
                        resultBinnenLuchtString= "te hoog";
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
        return resultBinnenLuchtString;   
    }
    public String setBuitenLuchtVochtigheidToestemming(){
        Connection con1 = null;
        String resultBuitenLuchtString = "";
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT luchtVochtInput,datumTijd FROM luchtvochtsensor where sensorId = 4 order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                   
                    Integer intbuitenLuchtInput = result.getInt("luchtVochtInput");
                    
                    
                    if(intbuitenLuchtInput < 11){                     
                        resultBuitenLuchtString= "te laag";
                    }
                    
                    if(intbuitenLuchtInput > 10 && intbuitenLuchtInput < 20){
                        resultBuitenLuchtString= "goed";
                    }
                    
                    if(intbuitenLuchtInput > 20){
                        resultBuitenLuchtString= "te hoog";
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
        return resultBuitenLuchtString;   
    }
}
