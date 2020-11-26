/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view.oud;

import com.bp6.kasmanagement.controller.DBCPDataSource;
import com.bp6.kasmanagement.model.KasInformatie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author laarh
 */
public class KasBeheren extends BorderPane{

    private Button kasCreateBtn = new Button("Maak nieuwe kas aan");
    private Label kasNaamLbl = new Label("Naam van kas:");
    private TextField kasNaam = new TextField("");
    private KasInformatie kas;
     private VBox vbox_el_wwl = new VBox(),
            vbox__hbox__hbox = new VBox(),
            vbox_ilv_wwv_hbox_ilk = new VBox();

    private HBox hbox_ilk = new HBox(),
            hbox__vbox__vbox = new HBox(),
            hbox_rt = new HBox();


    private TableView table = new TableView();


    public KasBeheren(){


        hbox_ilk = new HBox();

        hbox__vbox__vbox.getChildren().addAll(kasNaamLbl, kasNaam, kasCreateBtn);

        ObservableList<KasInformatie> items = FXCollections.observableArrayList();

         kasCreateBtn.setOnAction(event -> {
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf =
                 new java.text.SimpleDateFormat("yyyy-MM-dd");

            String currentTime = sdf.format(dt);
            this.getChildren().clear();
            Connection con1 = null;
            try {

                con1 = DBCPDataSource.getConnection();
                Statement stat = con1.createStatement();
                boolean result = stat.execute("INSERT INTO kas (kasNaam, datum) VALUES('" + kasNaam.getText()+ "', '"+currentTime+"')");

                ResultSet result1 = stat.executeQuery("select * from kas");



            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con1.close();
                } catch (Exception e) {

                }
            }
         });
            Connection con1 = null;

            try {
                con1 = DBCPDataSource.getConnection();
                Statement stat = con1.createStatement();

                ResultSet result1 = stat.executeQuery("select * from kas");
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
                    con1.close();
                } catch (Exception e) {

                }
            }



            table.setEditable(true);

        TableColumn kasNaamCol = new TableColumn("Kas naam");
        kasNaamCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("kasNaam")
        );
        TableColumn productCol = new TableColumn("Product");
        productCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("product")
        );
        TableColumn datumCol = new TableColumn("Datum");



        datumCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("datumTijd")
        );

        table.setItems(items);
        table.getColumns().addAll(kasNaamCol, productCol, datumCol);

        this.setCenter(table);


          this.setCenter(hbox__vbox__vbox);
          hbox__vbox__vbox.getChildren().addAll(table);
    }
           
}
 

