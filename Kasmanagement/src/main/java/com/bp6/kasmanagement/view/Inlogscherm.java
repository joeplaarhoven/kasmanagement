/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.DBCPDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author dahir
 */
public class Inlogscherm extends BorderPane {
    
    private VBox vbox_el_wwl = new VBox(),
            vbox__hbox__hbox = new VBox(),
            vbox_ilv_wwv_hbox_ilk = new VBox();

    private HBox hbox_ilk = new HBox(),
            hbox__vbox__vbox = new HBox(),
            hbox_rt = new HBox();

    private Label emaillabel = new Label("Email:"),
            wachtwoordlabel = new Label("Wachtwoord:");

    private TextField inlogvak = new TextField();

    private PasswordField wachtwoordvak = new PasswordField();

    private Button inlogknop = new Button("inloggen");

    private Text registratietext = new Text(),
            fouttext = new Text("Inloggegevens onjuist, probeer nogmaals!");
    
    private Registratiescherm registratiescherm;
    
    private Beheerderscherm beheerderscherm;
    
    private Hoofdscherm hoofdscherm;
    
    public Inlogscherm(){
        
        inlogvak.setMinSize(180, 30);

        wachtwoordvak.setMinSize(180, 30);
        wachtwoordvak.setFont(new Font(10));

        emaillabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        wachtwoordlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        registratietext.setFont(new Font(15));
        registratietext.setText("Klik hier om te registreren");
        
        fouttext.setVisible(false);
        fouttext.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        fouttext.setFill(Color.RED);
        
        hbox_ilk = new HBox();
        hbox_ilk.getChildren().add(inlogknop);
        hbox_ilk.setAlignment(Pos.CENTER_RIGHT);

        hbox__vbox__vbox.getChildren().addAll(vbox_el_wwl, vbox_ilv_wwv_hbox_ilk);
        hbox__vbox__vbox.setSpacing(20);
        hbox__vbox__vbox.setAlignment(Pos.CENTER);

        hbox_rt.getChildren().add(registratietext);
        hbox_rt.setAlignment(Pos.CENTER_RIGHT);
        hbox_rt.setSpacing(100);
        hbox_rt.setPadding(new Insets(0, 10, 0, 0));
        
        vbox_el_wwl.getChildren().addAll(emaillabel, wachtwoordlabel);
        vbox_el_wwl.setSpacing(22);
        
        vbox_ilv_wwv_hbox_ilk.getChildren().addAll(inlogvak, wachtwoordvak, fouttext, hbox_ilk);
        vbox_ilv_wwv_hbox_ilk.setAlignment(Pos.CENTER);
        vbox_ilv_wwv_hbox_ilk.setSpacing(10);

        vbox__hbox__hbox.getChildren().addAll(hbox_rt, hbox__vbox__vbox);
        vbox__hbox__hbox.setAlignment(Pos.TOP_CENTER);
        vbox__hbox__hbox.setSpacing(250);
        
        registratietext.setOnMousePressed(event -> {

            this.getChildren().clear();
            registratiescherm = new Registratiescherm();
            this.setCenter(registratiescherm);
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
        
        inlogknop.setOnAction(event -> {

            String textvakstring = inlogvak.getText();
            String wachtwoordvakstring = wachtwoordvak.getText();
//            Connection con = null;
//            try {
//                con = DBCPDataSource.getConnection();
//                Statement stat1 = con.createStatement();
//                ResultSet result = stat1.executeQuery("select * from gebruiker");
//
//                while (result.next()) {
//                    String strNaam = result.getString("gebruikersnaam");
//                    String strWachtwoord = result.getString("wachtwoord");
//                    if (textvakstring.equals(strNaam) && !textvakstring.equals("") && wachtwoordvakstring.equals(strWachtwoord) && !wachtwoordvakstring.equals("")) {
//
//                        this.getChildren().clear();
//                         hoofdscherm = new Hoofdscherm();
//                        this.setCenter(hoofdscherm);
//
//                        if (strNaam.equals("beheerder") && strWachtwoord.equals("beheerder")) {
//
//                            this.getChildren().clear();
//                            beheerderscherm = new Beheerderscherm();
//                            this.setCenter(beheerderscherm);
//                        }
//                    } else {
//
//                        inlogvak.clear();
//                        wachtwoordvak.clear();
//                        fouttext.setVisible(true);
//                    }
//
//                }
//
//            } catch (SQLException se) {
//
//                se.printStackTrace();
//            } finally {
//                try {
//                    con.close();
//                } catch (Exception e) {
//
//                }
//            }
            
             if (textvakstring.equals("beheerder") && wachtwoordvakstring.equals("beheerder")) {

                            this.getChildren().clear();
                            beheerderscherm = new Beheerderscherm();
                            this.setCenter(beheerderscherm);
                        }
                    else {

                        inlogvak.clear();
                        wachtwoordvak.clear();
                        fouttext.setVisible(true);
                    }

    
        });
        
        this.setCenter(vbox__hbox__hbox);
        this.setBackground(new Background(new BackgroundFill(Color.web("#FFFFE0"), null, null)));
        this.setPrefWidth(800);
    }
    
}
