package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.view.Rootpane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
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

        String strUserName = null;
        String strPassword = null;

        try {
            strUserName = username.getText();
            strPassword = password.getText();

        } catch (Exception se) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Er is geen juiste gebruikersnaam of wachtwoord in gevuld.");
            alert.setContentText("Probeer het nog eens.");
            alert.showAndWait();
            return;
        }
        try {
            con = DBCPDataSource.getConnection();
            PreparedStatement stat1 = con.prepareStatement("SELECT * FROM gebruiker where gebruikersnaam = ? and wachtwoord = ? ");
            stat1.setString(1, strUserName);
            stat1.setString(2, strPassword);
            ResultSet result = stat1.executeQuery();

            while (result.next()) {
                String strLoggedInPassword = result.getString("wachtwoord");
                if (!strLoggedInPassword.equals(strPassword)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Er is geen juiste gebruikersnaam of wachtwoord in gevuld.");
                    alert.setContentText("Probeer het nog eens.");
                    alert.showAndWait();
                    return;
                }
                String strLoggedInUser = result.getString("gebruikersnaam");

                rootpane.switchpane(1);
                rootpane.setUser(strLoggedInUser);
                rootpane.getTopUserBar().getUser().setText(strLoggedInUser);

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
