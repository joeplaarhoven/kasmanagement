/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.DBCPDataSource;
import com.bp6.kasmanagement.model.Gebruiker;
import com.bp6.kasmanagement.model.KasInformatie;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Joep
 */
public class KasInformatieScherm extends BorderPane {
    Label lblUser;
    private GridPane main_gridpane;
    private HBox hbox_labels, hbox_textfields;
    Label lbl_kasName, lbl_product;
    TextField txt_kasName;
    ComboBox cb_product;
    Button btn_addKas;
    TableView<KasInformatie> table;

    
    public KasInformatieScherm() {
        lblUser = new Label();
    }
    
    public void start(){
        
        table = new TableView();
        ObservableList<KasInformatie> items = FXCollections.observableArrayList();
        ObservableList<String> itemsProduct = FXCollections.observableArrayList();
        
        Connection con1 = null;
            try {

                con1 = DBCPDataSource.getConnection();
                Statement stat = con1.createStatement();
                
                ResultSet result1 = stat.executeQuery("SELECT *\n" +
                        "FROM kas\n" +
                        "LEFT JOIN gebruikerKas\n" +
                        "ON kas.kasNummer = gebruikerKas.kasNummer\n" +
                        "WHERE gebruikersNaam = '" + lblUser.getText() + "'");
                
                 
                while(result1.next()){
                    String strKasNaam= result1.getString("kasNaam");
                    Integer strKasNummer = result1.getInt("kasNummer");
                    String strDatum = result1.getString("datum");
                    String strproduct = result1.getString("product");

                    KasInformatie kas1 = new KasInformatie(strKasNummer, strKasNaam, strproduct, strDatum);
                    items.add(kas1);
                }
                
                ResultSet resultProduct = stat.executeQuery("SELECT * FROM idealegroei");
                  while(resultProduct.next()){
                    String strProductNaam= resultProduct.getString("product");

                   
                    itemsProduct.add(strProductNaam);
                }
                 



            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con1.close();
                } catch (Exception e) {

                }
            }
            
           
            
        TableColumn kasNaamCol = new TableColumn("Kas naam");
        kasNaamCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("kasNaam"));
        TableColumn productCol = new TableColumn("product");
        productCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("product"));
        TableColumn datumCol = new TableColumn("Datum");
        datumCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("datumTijd"));
        
        table.setItems(items);
        table.getColumns().addAll(kasNaamCol, productCol, datumCol);
        
        // Creates Hbox    
        hbox_labels = new HBox();
        hbox_textfields = new HBox();

        // Creates Gridpane
        main_gridpane = new GridPane();

        // Set Labels    
        lbl_kasName = new Label("Naam kas: ");
        lbl_product = new Label("Product: ");

        // Sets textfields
        txt_kasName = new TextField();
        
        //sets combobox
        cb_product = new ComboBox(itemsProduct);
        cb_product.setPromptText("Select Product");
        
        // Sets button
        btn_addKas = new Button("Kas Toevoegen");

        // Set Fonts
        lbl_kasName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lbl_product.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        // Set witdth labels
        lbl_kasName.setPrefWidth(150);
        lbl_product.setPrefWidth(150);

        // Sets width textfields
        txt_kasName.setPrefWidth(150);
        cb_product.setPrefWidth(150);
        
        // Sets width button
        btn_addKas.setPrefWidth(150);

        
        // Sets padding hbox
        hbox_labels.setPadding(new Insets(5, 5, 5, 5));
        hbox_textfields.setPadding(new Insets(5, 5, 5, 5));
        
        // Sets spacing hbox
        hbox_labels.setSpacing(10);
        hbox_textfields.setSpacing(10);
        
        
        // Places the labels in the Hbox
        hbox_labels.getChildren().addAll(lbl_kasName, lbl_product);
        hbox_textfields.getChildren().addAll(txt_kasName, cb_product, btn_addKas);

        // Position in gridpane
        main_gridpane.add(hbox_labels, 0, 1);
        main_gridpane.add(hbox_textfields, 0, 2);
        main_gridpane.add(table, 0, 3);
        this.setLeft(main_gridpane);
        
        table.setOnMouseClicked((MouseEvent event) -> {
            
            if(event.getButton().equals(MouseButton.PRIMARY)){
                String selectedItem = table.getSelectionModel().getSelectedItem().toString();
                items.stream().filter((kas) -> (selectedItem.equals(kas.getKasNaam()))).forEachOrdered((kas) -> {
                    cb_product.setValue(kas.getProduct());
                }); 
                

                txt_kasName.setText(table.getSelectionModel().getSelectedItem().toString());
                btn_addKas.setOnAction(e -> {
            
                    table.getItems().clear();
                    java.util.Date dt = new java.util.Date();

                    java.text.SimpleDateFormat sdf =
                         new java.text.SimpleDateFormat("yyyy-MM-dd");

                    String currentTime = sdf.format(dt);
                    Connection con2 = null;
                    try {

                        con2 = DBCPDataSource.getConnection();
                        Statement stat = con2.createStatement();
                        if(cb_product.getValue() == null){
                            boolean result = stat.execute("UPDATE kas\n" +
                                "SET kasNaam = '" + txt_kasName.getText() + "'\n" +
                                "WHERE kasNaam = '" + txt_kasName.getText() + "'");
                            

                        }
                        else {
                            boolean result = stat.execute("UPDATE kas\n" +
                                "SET product = '"+cb_product.getValue()+"', datum = '"+currentTime+"', kasNaam = '" + txt_kasName.getText() + "'\n" +
                                "WHERE kasNaam = '" + txt_kasName.getText() + "'");
                            

                        }


                        ResultSet result1 = stat.executeQuery("SELECT *\n" +
                                "FROM kas\n" +
                                "LEFT JOIN gebruikerKas\n" +
                                "ON kas.kasNummer = gebruikerKas.kasNummer\n" +
                                "WHERE gebruikersNaam = '" + lblUser.getText() + "'");
                        while(result1.next()){
                            String strKasNaam= result1.getString("kasNaam");
                            Integer strKasNummer = result1.getInt("kasNummer");
                            String strDatum = result1.getString("datum");
                            String strproduct = result1.getString("product");

                            KasInformatie kas1 = new KasInformatie(strKasNummer, strKasNaam, strproduct, strDatum);

                            items.add(kas1);
                        }
                        table.refresh();



                    } catch (SQLException se) {
                        se.printStackTrace();
                    } finally {
                        try {
                            con2.close();
                        } catch (SQLException SQLe) {

                        }
                    }
                });
            }
        });

        btn_addKas.setOnAction(e -> {
            
            table.getItems().clear();
            java.util.Date dt = new java.util.Date();

            java.text.SimpleDateFormat sdf =
                 new java.text.SimpleDateFormat("yyyy-MM-dd");

            String currentTime = sdf.format(dt);
            Connection con2 = null;
            try {

                con2 = DBCPDataSource.getConnection();
                Statement stat = con2.createStatement();
                if(cb_product.getValue().equals(null)){
                    boolean result = stat.execute("INSERT INTO kas (kasNaam, datum) VALUES('" + txt_kasName.getText()+ "', '"+currentTime+"')");
                    ResultSet resultKasNummer = stat.executeQuery("SELECT kasNummer FROM kas WHERE kasNaam = '"+ txt_kasName.getText() +"'");
                    Integer kasNummer;
                    if(resultKasNummer.next())
                    {
                        kasNummer= resultKasNummer.getInt("kasNummer");
                        
                        boolean result1 = stat.execute("INSERT INTO gebruikerkas VALUES(" + kasNummer + ", '"+ lblUser.getText() +"')");
                    }
                    
                }
                else {
                    boolean result = stat.execute("INSERT INTO kas (kasNaam, product, datum) VALUES('" + txt_kasName.getText()+ "', '"+ cb_product.getValue()+ "', '"+currentTime+"')");
                    ResultSet resultKasNummer = stat.executeQuery("SELECT kasNummer FROM kas WHERE kasNaam = '"+ txt_kasName.getText() +"'");
                    Integer kasNummer;
                    if(resultKasNummer.next())
                    {
                        kasNummer= resultKasNummer.getInt("kasNummer");
                        
                        boolean result1 = stat.execute("INSERT INTO gebruikerkas VALUES(" + kasNummer + ", '"+ lblUser.getText() +"')");
                    }
                    
                }
                

                ResultSet result1 = stat.executeQuery("SELECT *\n" +
                        "FROM kas\n" +
                        "LEFT JOIN gebruikerKas\n" +
                        "ON kas.kasNummer = gebruikerKas.kasNummer\n" +
                        "WHERE gebruikersNaam = '" + lblUser.getText() + "'");
                while(result1.next()){
                    String strKasNaam= result1.getString("kasNaam");
                    Integer strKasNummer = result1.getInt("kasNummer");
                    String strDatum = result1.getString("datum");
                    String strproduct = result1.getString("product");

                    KasInformatie kas1 = new KasInformatie(strKasNummer, strKasNaam, strproduct, strDatum);
                    
                    items.add(kas1);
                }
                table.refresh();



            } catch (SQLException se) {
                se.printStackTrace();
            } finally {
                try {
                    con2.close();
                } catch (SQLException SQLe) {

                }
            }
        });
    }
    
}
