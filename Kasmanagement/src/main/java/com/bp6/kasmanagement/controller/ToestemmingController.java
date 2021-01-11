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

/**
 *
 * @author dahir
 */
public class ToestemmingController {
    
    public ToestemmingController(){
        
    }
    
    public void setWindToestemming(){
        Connection con1 = null;
        
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT windInput,windManagement,datumTijd FROM windsensor order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                    
                    Integer intTrue = 1;
                    Integer intFalse = 0;
                    Integer intWindInput = result.getInt("windInput");
                    String strWindInMangement = result.getString("windManagement");
                    
                    if(intWindInput < 30){
                        
                            stat.executeUpdate("update windsensor set windManagement = '"+intFalse+"' where windInput = '"+ intWindInput+"'");
                        
                    }
                    
                    if(intWindInput > 30){
                        try{
                            stat.executeUpdate("update windsensor set windManagement = '"+intTrue+"' where windInput = '"+ intWindInput+"'");
                        }catch(Exception e){
                            
                        }  
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
    }
    
    public void setLichtToestemming(){
        Connection con1 = null;
        
        try {
                    
                    con1 = DBCPDataSource.getConnection();
                    Statement stat = con1.createStatement();
                    
                    ResultSet result = stat.executeQuery("SELECT lichtInput,lichtManagement,datumTijd FROM lichtsensor order by datumTijd DESC LIMIT 1");
                     while(result.next()){    
                    
                    Integer intTrue = 1;
                    Integer intFalse = 0;
                    Integer intlichtInput = result.getInt("lichtInput");
                    String strlichtInMangement = result.getString("lichtManagement");
                    
                    if(intlichtInput < 30){
                        
                            stat.executeUpdate("update lichtsensor set lichtManagement = '"+intFalse+"' where lichtInput = '"+ intlichtInput+"'");
                        
                    }
                    
                    if(intlichtInput > 30){
                        try{
                            stat.executeUpdate("update lichtsensor set lichtManagement = '"+intTrue+"' where lichtInput = '"+ intlichtInput+"'");
                        }catch(Exception e){
                            
                        }  
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
    }
    
    public void setBodemVochtToestemming(){
        
    }
    
    public void setBinnenTempratuurToestemming(){
        
    }
    
    public void setBuitenTempratuurToestemming(){
        
    }
    
    public void setBinnenLuchtVochtigheidToestemming(){
        
    }
    public void setBuitenLuchtVochtigheidToestemming(){
        
    }
}
