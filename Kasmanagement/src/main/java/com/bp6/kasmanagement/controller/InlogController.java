package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.view.Rootpane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;

/**
 *
 * @author Colin
 */
public class InlogController {

    private Rootpane rootpane;

    public InlogController(Rootpane rootpane) {
        this.rootpane = rootpane;
    }

    public void login(TextField username, TextField password) {
        Connection con = null;
        try {
            con = DBCPDataSource.getConnection();
            Statement stat1 = con.createStatement();
            ResultSet result = stat1.executeQuery("select gebruikersnaam from gebruiker where gebruikersnaam =  '" + username.getText() + "' and wachtwoord = '" + password.getText() + "'");

            while (result.next()) {
                String strNaam = result.getString("gebruikersnaam");

                rootpane.switchpane(1);
                rootpane.setUser(strNaam);
                rootpane.getTopUserBar().getUser().setText(strNaam);

            }
            
            username.clear();
            password.clear();
            
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
