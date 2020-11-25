package com.bp6.kasmanagement.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Colin
 */
public class InlogScherm extends BorderPane {

    private HBox hbox_username, hbox_password, hbox_inlogbutton;

    public InlogScherm() {

        hbox_username = new HBox();
        hbox_password = new HBox();
        hbox_inlogbutton = new HBox();

        initializeLabels();
        initializeTextfields();
        initializeButtons();
        
        VBox vbox_content = new VBox(hbox_username,hbox_password, hbox_inlogbutton);
        this.setCenter(vbox_content);
    }

    private void initializeLabels() {
        Label lb_username = new Label ("Gebruikersnaam");
        Label lb_password = new Label ("Wachtwoord");
        hbox_username.getChildren().add(lb_username);
        hbox_password.getChildren().add(lb_password);
    }

    private void initializeTextfields() {
        TextField tf_username = new TextField();
        TextField tf_password = new TextField();
        hbox_username.getChildren().add(tf_username);
        hbox_password.getChildren().add(tf_password);
    }
    
    private void initializeButtons() {
        Button btn_login = new Button("Inloggen");
        hbox_inlogbutton.getChildren().add(btn_login);
    }
    
}
