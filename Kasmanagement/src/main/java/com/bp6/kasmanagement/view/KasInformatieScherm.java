/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.KasInformatieController;
import com.bp6.kasmanagement.model.KasInformatie;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
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
    private HBox hbox_labels, hbox_textfields, hbox_crud;
    Label lbl_kasName, lbl_product;
    TextField txt_kasName;
    ComboBox cb_product;
    Button btn_addKas, btn_deselect, btn_delete;
    TableView<KasInformatie> table;
    KasInformatieController kasInfCont;
    String selectedProduct;
    ObservableList<KasInformatie> items;

    
    public KasInformatieScherm() {
        lblUser = new Label();
    }
    
    public void start(){
        selectedProduct = new String();
        kasInfCont = new KasInformatieController();
    
        
        table = new TableView();
       
        
        items = kasInfCont.getKasInfo(lblUser.getText());
            
        TableColumn kasNaamCol = new TableColumn("Kas naam");
        kasNaamCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("kasNaam"));
        TableColumn productCol = new TableColumn("product");
        productCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("product"));
        TableColumn datumCol = new TableColumn("Datum");
        datumCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("datumTijd"));
        TableColumn groeiCol = new TableColumn("Verwachten groei");
        groeiCol.setCellValueFactory(new PropertyValueFactory<KasInformatie,String>("groei"));
        
        table.setItems(items);
        table.getColumns().addAll(kasNaamCol, productCol, datumCol, groeiCol);
        
        // Creates Hbox    
        hbox_labels = new HBox();
        hbox_textfields = new HBox();
        hbox_crud = new HBox();

        // Creates Gridpane
        main_gridpane = new GridPane();

        // Set Labels    
        lbl_kasName = new Label("Naam kas: ");
        lbl_product = new Label("Product: ");

        // Sets textfields
        txt_kasName = new TextField();
        
        //sets combobox
        cb_product = new ComboBox(kasInfCont.getProductName());
        cb_product.setPromptText("Select Product");
        
        // Sets button
        btn_addKas = new Button("Kas Toevoegen");
        btn_deselect = new Button("Deselecteer");
        btn_delete = new Button("Verwijder rij");

        // Sets padding button
        btn_addKas.setPadding(new Insets(5, 5, 5, 5));
        btn_deselect.setPadding(new Insets(5, 5, 5, 5));
        btn_delete.setPadding(new Insets(5, 5, 5, 5));
        
        
        // Set Fonts
        lbl_kasName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lbl_product.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        // Set witdth labels
        lbl_kasName.setPrefWidth(150);
        lbl_product.setPrefWidth(150);
        
        // Set witdth columns
        kasNaamCol.setPrefWidth(160);
        productCol.setPrefWidth(160);
        datumCol.setPrefWidth(160);
        groeiCol.setPrefWidth(160);

        // Sets width textfields
        txt_kasName.setPrefWidth(150);
        cb_product.setPrefWidth(150);
        
        // Sets width button
        btn_addKas.setPrefWidth(150);

        
        // Sets padding hbox
        hbox_labels.setPadding(new Insets(5, 5, 5, 5));
        hbox_textfields.setPadding(new Insets(5, 5, 5, 5));
        hbox_crud.setPadding(new Insets(5, 5, 5, 5));
        
        // Sets spacing hbox
        hbox_labels.setSpacing(10);
        hbox_textfields.setSpacing(10);
        hbox_crud.setSpacing(10);
        
        // Places the labels in the Hbox
        hbox_labels.getChildren().addAll(lbl_kasName, lbl_product);
        hbox_textfields.getChildren().addAll(txt_kasName, cb_product, btn_addKas);
        hbox_crud.getChildren().addAll(btn_deselect, btn_delete);
        
        // Position in gridpane
        main_gridpane.add(hbox_labels, 0, 1);
        main_gridpane.add(hbox_textfields, 0, 2);
        main_gridpane.add(hbox_crud, 0, 3);
        main_gridpane.add(table, 0, 4);
        
        this.setLeft(main_gridpane);
        
        
        
        
        table.setOnMouseClicked((MouseEvent event) -> {
            
            if(event.getButton().equals(MouseButton.PRIMARY)){
                btn_addKas.setText("Update kas");
                
                String selectedItem = table.getSelectionModel().getSelectedItem().toString();
                items.stream().filter((kas) -> (selectedItem.equals(kas.getKasNaam()))).forEachOrdered((kas) -> {
                    cb_product.setValue(kas.getProduct());
                }); 
                
                

                txt_kasName.setText(table.getSelectionModel().getSelectedItem().toString());
                btn_addKas.setOnAction(e -> {
            
                
                kasInfCont.updateKas(cb_product.getValue().toString(),  txt_kasName.getText(), table.getSelectionModel().getSelectedItem().toString());
                table.getItems().clear();
                table.getSelectionModel().clearSelection();  
                cb_product.setValue(null);
                txt_kasName.setText("");
                items = kasInfCont.getKasInfo(lblUser.getText());
                table.setItems(items);
                table.refresh();

                });
            }
        });
        
        btn_deselect.setOnAction(e -> {
            table.getSelectionModel().clearSelection();   
            btn_addKas.setText("Kas Toevoegen");
            cb_product.setValue(null);
            txt_kasName.setText("");
        });
        
        btn_delete.setOnAction(e -> {
            kasInfCont.deleteKas(txt_kasName.getText());
            table.getItems().clear();
            items = kasInfCont.getKasInfo(lblUser.getText());
            table.setItems(items);
            table.refresh();

                
        });

        btn_addKas.setOnAction(e -> {
            kasInfCont.createKas(cb_product.getValue().toString(), txt_kasName.getText(), lblUser.getText());
            table.getItems().clear();
            items = kasInfCont.getKasInfo(lblUser.getText());
            table.setItems(items);
            table.refresh(); 
        });
    }
    
}
