package com.bp6.kasmanagement.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Colin
 */
public class ProductenScherm extends BorderPane {

    private GridPane main_gridpane;
    private HBox hbox_labelProducts, hbox_textfieldProducts, hbox_labelAllProducts, hbox_listviews, hbox_tableViews;
//    private ListView lv_Name, lv_Temperature, lv_Humidity, lv_SoilMoisture, lv_Light, lv_Growth;
    private TableView productTable;
    
    Label lb_productName, lb_Temperature, lb_Humidity, lb_SoilMoisture, lb_Light, lb_Growth, lb_productListLabel;
    TextField tf_productName, tf_Temperature, tf_Humidity, tf_SoilMoisture, tf_Light, tf_Growth;
    Button btn_addProduct;
    TableColumn tv_productName, tv_Temperature, tv_Humidity, tv_SoilMoisture, tv_Light, tv_Growth;
    
    public ProductenScherm() {
        // Creates Gridpane
        main_gridpane = new GridPane();

        // Creates Hbox    
        hbox_labelProducts = new HBox();
        hbox_textfieldProducts = new HBox();
        hbox_labelAllProducts = new HBox();
//        hbox_listviews = new HBox();
        hbox_tableViews = new HBox();

        // Creates tableview
        productTable = new TableView();
        
        // Creates tables
        tv_productName = new TableColumn("Naam product");
        tv_Temperature = new TableColumn("Temperatuur");
        tv_Humidity = new TableColumn("Luchtvochtigheid");
        tv_SoilMoisture = new TableColumn("Grond vochtigheid");
        tv_Light = new TableColumn("Belichting (lux)");
        tv_Growth = new TableColumn("Groei tijd");
               
//        // Creates Listviews
//        lv_Name = new ListView();
//        lv_Temperature = new ListView();
//        lv_Humidity = new ListView();
//        lv_SoilMoisture = new ListView();
//        lv_Light = new ListView();
//        lv_Growth = new ListView();
                        
        // Set Labels    
        lb_productName = new Label("Naam product");
        lb_Temperature = new Label("Temperatuur");
        lb_Humidity = new Label("Luchtvochtigheid");
        lb_SoilMoisture = new Label("Grond vochtigheid");
        lb_Light = new Label("Belichting (lux)");
        lb_Growth = new Label("Groei tijd");
        lb_productListLabel = new Label("Producten lijst");
        
        // Sets textfields
        tf_productName = new TextField();
        tf_Temperature = new TextField();
        tf_Humidity = new TextField();
        tf_SoilMoisture = new TextField();
        tf_Light = new TextField();
        tf_Growth = new TextField();
        
        // Sets button
        btn_addProduct = new Button("Product Toevoegen");

        // Set Fonts
        lb_productName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Temperature.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Humidity.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_SoilMoisture.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Light.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Growth.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        // Set witdth labels
        lb_productName.setPrefWidth(150);
        lb_Temperature.setPrefWidth(150);
        lb_Humidity.setPrefWidth(200);
        lb_SoilMoisture.setPrefWidth(200);
        lb_Light.setPrefWidth(150);
        lb_Growth.setPrefWidth(150);

        // Sets width textfields
        tf_productName.setPrefWidth(150);
        tf_Temperature.setPrefWidth(150);
        tf_Humidity.setPrefWidth(200);
        tf_SoilMoisture.setPrefWidth(200);
        tf_Light.setPrefWidth(150);
        tf_Growth.setPrefWidth(150);
        
        // Sets width tableViews
        tv_productName.setPrefWidth(150);
        tv_Temperature.setPrefWidth(150);
        tv_Humidity.setPrefWidth(200);
        tv_SoilMoisture.setPrefWidth(200);
        tv_Light.setPrefWidth(150);
        tv_Growth.setPrefWidth(150);
        
        // Sets width button
        btn_addProduct.setPrefWidth(150);
        
        // Sets padding hbox
        hbox_labelProducts.setPadding(new Insets(5, 5, 5, 5));
        hbox_textfieldProducts.setPadding(new Insets(5, 5, 5, 5));
        hbox_labelAllProducts.setPadding(new Insets(5, 5, 5, 5));
        hbox_tableViews.setPadding(new Insets(5, 5, 5, 5));
        
        // Sets spacing hbox
        hbox_labelProducts.setSpacing(10);
        hbox_textfieldProducts.setSpacing(10);
                
        // Fills tableview
        productTable.getColumns().addAll(tv_productName, tv_Temperature, tv_Humidity, tv_SoilMoisture, tv_Light, tv_Growth);
        
        // Places the labels in the Hbox
        hbox_labelProducts.getChildren().addAll(lb_productName, lb_Temperature, lb_Humidity, lb_SoilMoisture, lb_Light, lb_Growth);
        hbox_textfieldProducts.getChildren().addAll(tf_productName, tf_Temperature, tf_Humidity, tf_SoilMoisture, tf_Light, tf_Growth, btn_addProduct);
        hbox_labelAllProducts.getChildren().addAll(lb_productListLabel);
//        hbox_listviews.getChildren().addAll(lv_Name, lv_Temperature, lv_Humidity, lv_SoilMoisture, lv_Light, lv_Growth);
        hbox_tableViews.getChildren().addAll(productTable);

        // Position in gridpane
        main_gridpane.add(hbox_labelProducts, 0, 1);
        main_gridpane.add(hbox_textfieldProducts, 0, 2);
        main_gridpane.add(hbox_labelAllProducts, 0, 3);
//        main_gridpane.add(hbox_listviews, 0, 4);
        main_gridpane.add(hbox_tableViews, 0, 4);
        
        this.setLeft(main_gridpane);
    }
}
