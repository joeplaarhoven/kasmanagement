package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.model.IdealeGroei;
import com.bp6.kasmanagement.view.IdealeGroeiScherm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author Colin
 */
public class IdealeGroeiController {

    private ArrayList<IdealeGroei> idealeGroeiArraylist;
    private IdealeGroeiScherm idealeGroeiScherm;

    // Constructor
    public IdealeGroeiController(IdealeGroeiScherm idealeGroeiScherm) {
        idealeGroeiArraylist = new ArrayList<>();
        this.idealeGroeiScherm = idealeGroeiScherm;
    }

    // Refreshes data in the tableView
    public void refreshTableView() {
        getIdealeGroeiObject();
        idealeGroeiScherm.getProductTable().getItems().clear();
        for (int i = 0; i < idealeGroeiArraylist.size(); i++) {
            idealeGroeiScherm.getProductTable().getItems().add(idealeGroeiArraylist.get(i));
        }
    }

    // Adds data to the database
    public void setIdealeGroeiObject() {
        Connection con = null;
        
        String strProductName = null;
        Integer strTemperature = null;
        Integer strHumidity = null;
        Integer strSoilMoisture = null;
        Integer strLight = null;
        Integer strMaxWind = null;   
        Integer strGrowth = null;
                
        try {
        strProductName = idealeGroeiScherm.getTf_productName().getText();
        strTemperature = Integer.valueOf(idealeGroeiScherm.getTf_Temperature().getText());
        strHumidity = Integer.valueOf(idealeGroeiScherm.getTf_Humidity().getText());
        strSoilMoisture = Integer.valueOf(idealeGroeiScherm.getTf_SoilMoisture().getText());
        strLight = Integer.valueOf(idealeGroeiScherm.getTf_Light().getText());
        strMaxWind = Integer.valueOf(idealeGroeiScherm.getTf_MaxWind().getText());
        strGrowth = Integer.valueOf(idealeGroeiScherm.getTf_Growth().getText());
        } catch (Exception se){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Er is geen juiste waarde in gevuld");
            alert.setContentText("Probeer het nog eens met een correcte waarde");
            alert.showAndWait();
            return;
        }
        
        try {
            con = DBCPDataSource.getConnection();
            PreparedStatement stat2 = con.prepareStatement("INSERT INTO `kasmanagement`.`idealegroei` (`product`, `tempIdeaal`, `vochtIdeaal`, `windMax`, `lichtIdeaal`, `bodemVochtIdeaal`, `groeiTijd`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stat2.setString(1, strProductName);
            stat2.setInt(2, strTemperature);
            stat2.setInt(3, strHumidity);
            stat2.setInt(4, strSoilMoisture);
            stat2.setInt(5, strLight);
            stat2.setInt(6, strMaxWind);
            stat2.setInt(7, strGrowth);
  
            stat2.executeUpdate();
            
        } catch (SQLException se) {

            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {

            }
        }
    }

    // Retrieves the tables from idealeGroei
    public void getIdealeGroeiObject() {
        Connection con = null;
        idealeGroeiArraylist.clear();

        try {
            con = DBCPDataSource.getConnection();
            Statement stat1 = con.createStatement();
            ResultSet result = stat1.executeQuery("select * from idealegroei");

            while (result.next()) {
                IdealeGroei object = new IdealeGroei(result.getString("product"), result.getInt("tempIdeaal"), result.getInt("vochtIdeaal"), result.getInt("windMax"), result.getInt("lichtIdeaal"), result.getInt("bodemVochtIdeaal"), result.getInt("groeiTijd"));
                idealeGroeiArraylist.add(object);
            }

        } catch (SQLException se) {

            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {

            }
        }
    }

}
