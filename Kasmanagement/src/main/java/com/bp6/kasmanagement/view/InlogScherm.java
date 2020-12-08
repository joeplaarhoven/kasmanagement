package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.InlogController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Colin
 */
public class InlogScherm extends BorderPane {

    private InlogController inlogController;
    private HBox hbox_username, hbox_password, hbox_inlogbutton;
    private TextField tf_username;
    private PasswordField tf_password;
    private Rootpane rootpane;
    private Text registratietext = new Text();
    private RegistratieScherm registratieScherm;
    private HBox hbox_rt;
    
    public InlogScherm(InlogController inlogController) {

        this.inlogController = inlogController;

        hbox_username = new HBox();
        hbox_password = new HBox();
        hbox_inlogbutton = new HBox();
        hbox_rt = new HBox();

        hbox_username.setAlignment(Pos.CENTER);
        hbox_password.setAlignment(Pos.CENTER);
        hbox_inlogbutton.setAlignment(Pos.CENTER);
        
        hbox_rt.getChildren().add(registratietext);
        hbox_rt.setAlignment(Pos.CENTER_RIGHT);
        hbox_rt.setSpacing(100);
        hbox_rt.setPadding(new Insets(0, 10, 0, 0));
        
        registratietext.setFont(new Font(15));
        registratietext.setText("Klik hier om te registreren");
        registratietext.setOnMousePressed(event -> {

            this.getChildren().clear();
            registratieScherm = new RegistratieScherm();
            this.setCenter(registratieScherm);
        });

        registratietext.setOnMouseEntered(event -> {
            registratietext.setFill(Color.BLUE);
            registratietext.setUnderline(true);
            this.setCursor(Cursor.HAND);
        });

        registratietext.setOnMouseExited(event -> {
            registratietext.setFill(Color.BLACK);
            registratietext.setUnderline(false);
            this.setCursor(Cursor.DEFAULT);
        });

        initializeLabels();
        initializeTextfields();
        initializeButtons();
        initializePasswordFields();

        VBox vbox_content = new VBox(hbox_username, hbox_password, hbox_inlogbutton,hbox_rt);
        vbox_content.setSpacing(10);
        vbox_content.setMaxWidth(300);
        vbox_content.alignmentProperty().set(Pos.CENTER);
        
        this.setCenter(vbox_content);
    }

    private void initializeLabels() {
        Label lb_username = new Label("Gebruikersnaam");
        Label lb_password = new Label("Wachtwoord");

        lb_username.setPadding(new Insets(3, 0, 0, 0));
        lb_password.setPadding(new Insets(3, 0, 0, 0));

        lb_username.setPrefWidth(150);
        lb_password.setPrefWidth(150);

        hbox_username.getChildren().add(lb_username);
        hbox_password.getChildren().add(lb_password);
    }

    private void initializeTextfields() {
        tf_username = new TextField();

        tf_username.setPrefWidth(200);

        hbox_username.getChildren().add(tf_username);
    }

    private void initializePasswordFields() {
        tf_password = new PasswordField();

        tf_password.setPrefWidth(200);

        hbox_password.getChildren().add(tf_password);

    }

    private void initializeButtons() {
        Button btn_login = new Button("Inloggen");
        btn_login.setPrefWidth(350);

        btn_login.setOnAction(e -> {
            inlogController.login(tf_username, tf_password);
        });

        hbox_inlogbutton.getChildren().add(btn_login);

    }

}
