package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.IdealeGroeiController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Colin
 */
public class IdealeGroeiScherm extends BorderPane {

    private IdealeGroeiController idealeGroeiController;
    
    private GridPane main_gridpane;
    private HBox hbox_labelProducts, hbox_textfieldProducts, hbox_labelAllProducts, hbox_tableViews;
    private TableView productTable;
    
    Label lb_productName, lb_Temperature, lb_Humidity, lb_SoilMoisture, lb_Light, lb_MaxWind, lb_Growth, lb_productListLabel;
    TextField tf_productName, tf_Temperature, tf_Humidity, tf_SoilMoisture, tf_Light, tf_MaxWind, tf_Growth;
    Button btn_addProduct;
    TableColumn tc_productName, tc_Temperature, tc_Humidity, tc_SoilMoisture, tc_Light, tc_MaxWind, tc_Growth;
    
    public IdealeGroeiScherm() {
        // Creates idealeGroeiController connection
        idealeGroeiController = new IdealeGroeiController(this);
        
        // Creates Gridpane
        main_gridpane = new GridPane();

        // Creates Hbox    
        hbox_labelProducts = new HBox();
        hbox_textfieldProducts = new HBox();
        hbox_labelAllProducts = new HBox();
        hbox_tableViews = new HBox();

        // Creates tableview
        productTable = new TableView();
        
        // Creates tables
        tc_productName = new TableColumn("Naam product");
        tc_Temperature = new TableColumn("Temperatuur °C");
        tc_Humidity = new TableColumn("Luchtvochtigheid %");
        tc_SoilMoisture = new TableColumn("Grond vochtigheid %");
        tc_Light = new TableColumn("Belichting lux");
        tc_MaxWind = new TableColumn("Max windsnelheid km/h");
        tc_Growth = new TableColumn("Groei tijd dagen");
        
        // Sets model variable
        tc_productName.setCellValueFactory(new PropertyValueFactory<>("product"));
        tc_Temperature.setCellValueFactory(new PropertyValueFactory<>("tempIdeaal °C"));
        tc_Humidity.setCellValueFactory(new PropertyValueFactory<>("vochtIdeaal %"));
        tc_SoilMoisture.setCellValueFactory(new PropertyValueFactory<>("bodemVochtIdeaal %"));
        tc_Light.setCellValueFactory(new PropertyValueFactory<>("lichtIdeaal lux"));
        tc_MaxWind.setCellValueFactory(new PropertyValueFactory<>("windMax km/h"));
        tc_Growth.setCellValueFactory(new PropertyValueFactory<>("groeiTijd dagen"));  
                
        // Set Labels    
        lb_productName = new Label("Naam product");
        lb_Temperature = new Label("Temperatuur °C");
        lb_Humidity = new Label("Luchtvochtigheid %");
        lb_SoilMoisture = new Label("Grond vochtigheid %");
        lb_Light = new Label("Belichting lux");
        lb_Growth = new Label("Groei tijd dagen");
        lb_MaxWind = new Label("Max windsnelheid km/h");
        lb_productListLabel = new Label("Producten lijst");
        
        // Sets textfields
        tf_productName = new TextField();
        tf_Temperature = new TextField();
        tf_Humidity = new TextField();
        tf_SoilMoisture = new TextField();
        tf_Light = new TextField();
        tf_MaxWind = new TextField();
        tf_Growth = new TextField();

        // Sets button
        btn_addProduct = new Button("Product Toevoegen");
        btn_addProduct.setOnAction(e ->{
            idealeGroeiController.setIdealeGroeiObject();
            idealeGroeiController.refreshTableView();
        });       

        // Set Fonts
        lb_productName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Temperature.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Humidity.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_SoilMoisture.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Light.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_MaxWind.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Growth.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        // Set witdth labels
        lb_productName.setPrefWidth(150);
        lb_Temperature.setPrefWidth(150);
        lb_Humidity.setPrefWidth(200);
        lb_SoilMoisture.setPrefWidth(200);
        lb_Light.setPrefWidth(150);
        lb_MaxWind.setPrefWidth(200);
        lb_Growth.setPrefWidth(150);
       
        // Sets width textfields
        tf_productName.setPrefWidth(150);
        tf_Temperature.setPrefWidth(150);
        tf_Humidity.setPrefWidth(200);
        tf_SoilMoisture.setPrefWidth(200);
        tf_Light.setPrefWidth(150);
        tf_MaxWind.setPrefWidth(200);
        tf_Growth.setPrefWidth(150);
        
        // Sets width tableViews
        tc_productName.setPrefWidth(150);
        tc_Temperature.setPrefWidth(150);
        tc_Humidity.setPrefWidth(200);
        tc_SoilMoisture.setPrefWidth(200);
        tc_Light.setPrefWidth(150);
        tc_MaxWind.setPrefWidth(200);
        tc_Growth.setPrefWidth(150);
              
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
        productTable.getColumns().addAll(tc_productName, tc_Temperature, tc_Humidity, tc_SoilMoisture, tc_Light, tc_MaxWind, tc_Growth);
        
        // Places the labels in the Hbox
        hbox_labelProducts.getChildren().addAll(lb_productName, lb_Temperature, lb_Humidity, lb_SoilMoisture, lb_Light, lb_MaxWind, lb_Growth);
        hbox_textfieldProducts.getChildren().addAll(tf_productName, tf_Temperature, tf_Humidity, tf_SoilMoisture, tf_Light, tf_MaxWind, tf_Growth, btn_addProduct);
        hbox_labelAllProducts.getChildren().addAll(lb_productListLabel);
        hbox_tableViews.getChildren().addAll(productTable);

        // Position in gridpane
        main_gridpane.add(hbox_labelProducts, 0, 1);
        main_gridpane.add(hbox_textfieldProducts, 0, 2);
        main_gridpane.add(hbox_labelAllProducts, 0, 3);
        main_gridpane.add(hbox_tableViews, 0, 4);
        
        this.setLeft(main_gridpane);
        idealeGroeiController.refreshTableView();
    }

    public TableView getProductTable() {
        return productTable;
    }

    public TextField getTf_productName() {
        return tf_productName;
    }

    public TextField getTf_Temperature() {
        return tf_Temperature;
    }

    public TextField getTf_Humidity() {
        return tf_Humidity;
    }

    public TextField getTf_SoilMoisture() {
        return tf_SoilMoisture;
    }

    public TextField getTf_Light() {
        return tf_Light;
    }

    public TextField getTf_MaxWind() {
        return tf_MaxWind;
    }

    public TextField getTf_Growth() {
        return tf_Growth;
    }
    
}
