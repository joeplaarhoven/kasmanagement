package com.bp6.kasmanagement.controller;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;


/**
 *
 * @author dahir
 */
public class DBCPDataSource {
    
     private static BasicDataSource ds = new BasicDataSource();
     
     static{
         
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://serverbp5.mysql.database.azure.com:3306/kasmanagement?useSSL=true&enabledTLSProtocols=TLSv1.2");
        ds.setUsername("mgmt_admin");
        ds.setPassword("AaL6HS3LRca4mbO34Ow9");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
    public static void getCloseConnection() throws SQLException{
         ds.close();
    } 
    
    private DBCPDataSource(){
        
    }
    
    
}
