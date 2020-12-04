/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.model.KasInformatie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Joep
 */
public class KasInformatieController {
    
    public void updateKas(String product, String kasnaam, String lastKasNaam){
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
             new java.text.SimpleDateFormat("yyyy-MM-dd");

        String currentTime = sdf.format(dt);
        Connection con2 = null;
        try {
            
            
            con2 = DBCPDataSource.getConnection();
            Statement stat = con2.createStatement();
            
            String query = "update kas set product = ?, datum = ?, kasNaam = ? where kasNummer = (SELECT kasNummer from (SELECT * FROM kas) AS fakeKas where kasNaam = ?)";
            PreparedStatement preparedStmt = con2.prepareStatement(query);
            preparedStmt.setString(1, product);
            preparedStmt.setString(2, currentTime);
            preparedStmt.setString(3, kasnaam);
            preparedStmt.setString(4, lastKasNaam);
            
            preparedStmt.executeUpdate();

            
            } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException SQLe) {

            }
        }
    }
    
    public void createKas(String product, String kasnaam, String user){
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
             new java.text.SimpleDateFormat("yyyy-MM-dd");

        String currentTime = sdf.format(dt);
        Connection con2 = null;
        try {
            
            
                con2 = DBCPDataSource.getConnection();
                Statement stat = con2.createStatement();
                if(product == null){
                    boolean result = stat.execute("INSERT INTO kas (kasNaam, datum) VALUES('" + kasnaam + "', '"+currentTime+"')");
                    ResultSet resultKasNummer = stat.executeQuery("SELECT kasNummer FROM kas WHERE kasNaam = '"+ kasnaam +"'");
                    Integer kasNummer;
                    if(resultKasNummer.next())
                    {
                        kasNummer= resultKasNummer.getInt("kasNummer");
                        
                        boolean result1 = stat.execute("INSERT INTO gebruikerkas VALUES(" + kasNummer + ", '"+ user +"')");
                    }
                    
                }
                else {
                    boolean result = stat.execute("INSERT INTO kas (kasNaam, product, datum) VALUES('" + kasnaam + "', '"+ product + "', '"+currentTime+"')");
                    ResultSet resultKasNummer = stat.executeQuery("SELECT kasNummer FROM kas WHERE kasNaam = '"+ kasnaam +"'");
                    Integer kasNummer;
                    if(resultKasNummer.next())
                    {
                        kasNummer= resultKasNummer.getInt("kasNummer");
                        
                        boolean result1 = stat.execute("INSERT INTO gebruikerkas VALUES(" + kasNummer + ", '"+ user +"')");
                    }
                    
                }

            
            
            } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException SQLe) {

            }
        }
                
    }
    
    public ObservableList<KasInformatie> getKasInfo(String user){
        ObservableList<KasInformatie> items = FXCollections.observableArrayList();
        
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
             new java.text.SimpleDateFormat("yyyy-MM-dd");

        String currentTime = sdf.format(dt);
        Connection con2 = null;
        try {

            con2 = DBCPDataSource.getConnection();
            Statement stat = con2.createStatement();
            ResultSet result1 = stat.executeQuery("SELECT *\n" +
                    "FROM kas\n" +
                    "LEFT JOIN gebruikerKas\n" +
                    "ON kas.kasNummer = gebruikerKas.kasNummer\n" +
                    "WHERE gebruikersNaam = '" + user + "'");
            while(result1.next()){
                String strKasNaam= result1.getString("kasNaam");
                Integer strKasNummer = result1.getInt("kasNummer");
                String strDatum = result1.getString("datum");
                String strproduct = result1.getString("product");

                KasInformatie kas1 = new KasInformatie(strKasNummer, strKasNaam, strproduct, strDatum);

                items.add(kas1);
            }
            } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException SQLe) {

            }
        }
        return items;
    }
    
    public ObservableList<String> getProductName(){
        ObservableList<String> itemsProduct = FXCollections.observableArrayList();
        Connection con2 = null;
        try {

            con2 = DBCPDataSource.getConnection();
            Statement stat = con2.createStatement();
            ResultSet resultProduct = stat.executeQuery("SELECT * FROM idealegroei");
            while(resultProduct.next()){
              String strProductNaam= resultProduct.getString("product");


              itemsProduct.add(strProductNaam);
          }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException SQLe) {

            }
            return itemsProduct;
        }
    }

    public void deleteKas(String kasNaam) {
        Connection con2 = null;
        try {

            con2 = DBCPDataSource.getConnection();
            Statement stat = con2.createStatement();
            
            String query1 = "delete from gebruikerkas where kasNummer = (SELECT kasNummer from kas where kasNaam = ?)";
            PreparedStatement preparedStmt1 = con2.prepareStatement(query1);
            preparedStmt1.setString(1, kasNaam);
            preparedStmt1.execute();
            
            String query = "delete from kas where kasNummer = (SELECT kasNummer from (SELECT * FROM kas) AS fakeKas where kasNaam = ?)";
            PreparedStatement preparedStmt = con2.prepareStatement(query);
            preparedStmt.setString(1, kasNaam);

            // execute the preparedstatement
            preparedStmt.execute();
        }catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con2.close();
            } catch (SQLException SQLe) {

            }
        }
    }
}
