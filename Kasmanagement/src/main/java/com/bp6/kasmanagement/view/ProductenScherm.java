package com.bp6.kasmanagement.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private HBox hbox_labels, hbox_textfields;

    Label lb_productName, lb_idealTemperature, lb_idealHumidity, lb_idealLight, lb_idealGrowth;
    TextField tf_productName, tf_idealTemperature, tf_idealHumidity, tf_idealLight, tf_idealGrowth;
    Button btn_addProduct;
    
    public ProductenScherm() {
        // Creates Hbox    
        hbox_labels = new HBox();
        hbox_textfields = new HBox();

        // Creates Gridpane
        main_gridpane = new GridPane();

        // Set Labels    
        lb_productName = new Label("Naam product");
        lb_idealTemperature = new Label("Tempratuur");
        lb_idealHumidity = new Label("Luchtvochtigheid");
        lb_idealLight = new Label("Belichting (lux)");
        lb_idealGrowth = new Label("Groei tijd");

        // Sets textfields
        tf_productName = new TextField();
        tf_idealTemperature = new TextField();
        tf_idealHumidity = new TextField();
        tf_idealLight = new TextField();
        tf_idealGrowth = new TextField();
        
        // Sets button
        btn_addProduct = new Button("Product Toevoegen");

        // Set Fonts
        lb_productName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_idealTemperature.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_idealHumidity.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_idealLight.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_idealGrowth.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        // Set witdth labels
        lb_productName.setPrefWidth(150);
        lb_idealTemperature.setPrefWidth(150);
        lb_idealHumidity.setPrefWidth(200);
        lb_idealLight.setPrefWidth(150);
        lb_idealGrowth.setPrefWidth(150);

        // Sets width textfields
        tf_productName.setPrefWidth(150);
        tf_idealTemperature.setPrefWidth(150);
        tf_idealHumidity.setPrefWidth(200);
        tf_idealLight.setPrefWidth(150);
        tf_idealGrowth.setPrefWidth(150);
        
        // Sets width button
        btn_addProduct.setPrefWidth(150);

//        // set Padding labels
//        lb_productName.setPadding(new Insets(5, 5, 5, 5));
//        lb_idealTemperature.setPadding(new Insets(5, 5, 5, 5));
//        lb_idealHumidity.setPadding(new Insets(5, 5, 5, 5));
//        lb_idealLight.setPadding(new Insets(5, 5, 5, 5));
//        lb_idealGrowth.setPadding(new Insets(5, 5, 5, 5));

//        // sets Padding textfields
//        tf_productName.setPadding(new Insets(5, 5, 5, 5));
//        tf_idealTemperature.setPadding(new Insets(5, 5, 5, 5));
//        tf_idealHumidity.setPadding(new Insets(5, 5, 5, 5));
//        tf_idealLight.setPadding(new Insets(5, 5, 5, 5));
//        tf_idealGrowth.setPadding(new Insets(5, 5, 5, 5));
        
        // Sets padding hbox
        hbox_labels.setPadding(new Insets(5, 5, 5, 5));
        hbox_textfields.setPadding(new Insets(5, 5, 5, 5));
        
        // Sets spacing hbox
        hbox_labels.setSpacing(10);
        hbox_textfields.setSpacing(10);
        
        // Places the labels in the Hbox
        hbox_labels.getChildren().addAll(lb_productName, lb_idealTemperature, lb_idealHumidity, lb_idealLight, lb_idealGrowth);
        hbox_textfields.getChildren().addAll(tf_productName, tf_idealTemperature, tf_idealHumidity, tf_idealLight, tf_idealGrowth, btn_addProduct);

        // Position in gridpane
        main_gridpane.add(hbox_labels, 0, 1);
        main_gridpane.add(hbox_textfields, 0, 2);
        this.setLeft(main_gridpane);
    }
}
