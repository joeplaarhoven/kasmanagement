package com.bp6.kasmanagement.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Dahir
 */
public class SensorManagementScherm extends BorderPane {
    
    private GridPane Gridpane_Hoofdscherm;
    private VBox Labels_BinnenWaarden,Labels_BuitenWaarden,Textfields_BinnenWaarden,Textfields_BuitenWaarden,Labels_Knoppen, Buttons_knoppenAan,Buttons_knoppenUit ;
    private HBox hbox_Main,hbox_BinnenWaarden, hbox_BuitenWaarden,hbox_Actuatoren,hbox_KasKeuze;
    
    private ChoiceBox kas_Nummer;
    private CheckBox handmatig_Aansturen;
    private Label lb_TempratuurBinnen,lb_TempratuurBuiten, lb_WindsnelheidBuiten, lb_LuchtvochtigheidBinnen,lb_LuchtvochtigheidBuiten, lb_BodemvochtigheidBinnen,lb_LichtBinnen,
                  lb_RaamOpenSluit, lb_SproeierAanUit,lb_KachelAanUit,lb_LampAanUit,lb_HandmatigAansturen;
    private TextField tf_TempratuurBinnen, tf_TempratuurBuiten,tf_WindsnelheidBuiten, tf_LuchtvochtigheidBinnen,tf_LuchtvochtigheidBuiten, tf_BodemvochtigheidBinnen,tf_LichtBinnen;
    private Button btn_RaamOpen, btn_RaamSluiten, btn_SproeierAan,btn_SproeierUit,btn_KachelAan, btn_KachelUit,btn_LampAan,btn_LampUit;
    
    
    public SensorManagementScherm(){
        
        
        // Creates Choicebox, sets prefSize and adds items 
        kas_Nummer = new ChoiceBox();
        kas_Nummer.setPrefSize(120, 30);
        kas_Nummer.getItems().setAll("hoi");
        
        // Creates Checkbox and sets prefSize
        handmatig_Aansturen = new CheckBox();
        handmatig_Aansturen.setPrefSize(30, 30);
        
        
        // Creates HBox 
        hbox_Main = new HBox();
        hbox_BinnenWaarden = new HBox();
        hbox_BuitenWaarden = new HBox();
        hbox_Actuatoren = new HBox();
        hbox_KasKeuze = new HBox();
        
        // Creates VBox    
        Labels_BinnenWaarden = new VBox();
        Labels_BuitenWaarden = new VBox();
        Textfields_BinnenWaarden = new VBox();
        Textfields_BuitenWaarden = new VBox();
        Labels_Knoppen = new VBox();
        Buttons_knoppenAan = new VBox();
        Buttons_knoppenUit = new VBox();

        // Creates Gridpane
        Gridpane_Hoofdscherm = new GridPane();
        
        // Set Labels    
        lb_TempratuurBinnen = new Label("Tempratuur (Binnen):");
        lb_TempratuurBuiten = new Label("Tempratuur (Buiten):");
        lb_WindsnelheidBuiten = new Label("Windsnelheid (Binnen):");
        lb_LuchtvochtigheidBinnen = new Label("Luchtvochtigheid (Binnen):");
        lb_LuchtvochtigheidBuiten = new Label("Luchtvochtigheid (Buiten):");
        lb_BodemvochtigheidBinnen = new Label("Bodemvochtigheid (Binnen):");
        lb_LichtBinnen = new Label("Licht (Binnen):");
        lb_RaamOpenSluit = new Label("Raam:");
        lb_SproeierAanUit = new Label("Sproeier:");
        lb_KachelAanUit = new Label("Kachel:");
        lb_LampAanUit = new Label("Lamp:");
        lb_HandmatigAansturen = new Label("Handmatig aansturen->");
        
        // Set Fonts labels
        lb_TempratuurBinnen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_TempratuurBuiten.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_WindsnelheidBuiten.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_LuchtvochtigheidBinnen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_LuchtvochtigheidBuiten.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_BodemvochtigheidBinnen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_LichtBinnen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_RaamOpenSluit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_SproeierAanUit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_KachelAanUit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_LampAanUit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_HandmatigAansturen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
         // Set witdth labels
        lb_TempratuurBinnen.setPrefHeight(30);
        lb_TempratuurBuiten.setPrefHeight(30);
        lb_WindsnelheidBuiten.setPrefHeight(30);
        lb_LuchtvochtigheidBinnen.setPrefHeight(30);
        lb_LuchtvochtigheidBuiten.setPrefHeight(30);
        lb_BodemvochtigheidBinnen.setPrefHeight(30);
        lb_LichtBinnen.setPrefHeight(30);
        lb_RaamOpenSluit.setPrefHeight(30);
        lb_SproeierAanUit.setPrefHeight(30);
        lb_KachelAanUit.setPrefHeight(30);
        lb_LampAanUit.setPrefHeight(30);
        lb_HandmatigAansturen.setPrefHeight(30);
        
        // Sets textfields
        tf_TempratuurBinnen = new TextField();
        tf_TempratuurBuiten = new TextField();
        tf_WindsnelheidBuiten = new TextField();
        tf_LuchtvochtigheidBinnen = new TextField();
        tf_LuchtvochtigheidBuiten = new TextField();
        tf_BodemvochtigheidBinnen = new TextField();
        tf_LichtBinnen = new TextField();
        
        // Sets width textfields
        tf_TempratuurBinnen.setPrefSize(50, 30);
        tf_TempratuurBuiten.setPrefSize(50, 30);
        tf_WindsnelheidBuiten.setPrefSize(50, 30);
        tf_LuchtvochtigheidBinnen.setPrefSize(50, 30);
        tf_LuchtvochtigheidBuiten.setPrefSize(50, 30);
        tf_BodemvochtigheidBinnen.setPrefSize(50, 30);
        tf_LichtBinnen.setPrefSize(50, 30);
        
        // Sets editable textfields
        tf_TempratuurBinnen.setEditable(false);
        tf_TempratuurBuiten.setEditable(false);
        tf_WindsnelheidBuiten.setEditable(false);
        tf_LuchtvochtigheidBinnen.setEditable(false);
        tf_LuchtvochtigheidBuiten.setEditable(false);
        tf_BodemvochtigheidBinnen.setEditable(false);
        tf_LichtBinnen.setEditable(false);
        
        // Sets button
        btn_RaamOpen = new Button("Openen");
        btn_RaamSluiten = new Button("Sluiten");
        btn_SproeierAan = new Button("Aan");
        btn_SproeierUit = new Button("Uit");
        btn_KachelAan = new Button("Aan");
        btn_KachelUit = new Button("Uit");
        btn_LampAan = new Button("Aan");
        btn_LampUit = new Button("Uit");
        
        // Sets width button
        btn_KachelAan.setPrefSize(70,30);
        btn_KachelUit.setPrefSize(70,30);
        btn_RaamOpen.setPrefSize(70,30);
        btn_RaamSluiten.setPrefSize(70,30);
        btn_SproeierAan.setPrefSize(70,30);
        btn_SproeierUit.setPrefSize(70,30);
        btn_LampAan.setPrefSize(70,30);
        btn_LampUit.setPrefSize(70,30);
        
        // Sets padding hbox
        Labels_BinnenWaarden.setPadding(new Insets(5, 5, 5, 5));
        Labels_BuitenWaarden.setPadding(new Insets(5, 5, 5, 5));
        Textfields_BinnenWaarden.setPadding(new Insets(5, 5, 5, 5));
        Textfields_BuitenWaarden.setPadding(new Insets(5, 5, 5, 5));
       
        // Sets spacing Vbox
        Labels_BinnenWaarden.setSpacing(10);
        Labels_BuitenWaarden.setSpacing(10);
        Textfields_BinnenWaarden.setSpacing(10);
        Textfields_BuitenWaarden.setSpacing(10);
        Labels_Knoppen.setSpacing(10);
        Buttons_knoppenAan.setSpacing(10);
        Buttons_knoppenUit.setSpacing(10);
        
         // Sets spacing Hbox
        hbox_BinnenWaarden.setSpacing(10);
        hbox_BuitenWaarden.setSpacing(10);
        hbox_Actuatoren.setSpacing(15);
        hbox_KasKeuze.setSpacing(15);
        hbox_Main.setSpacing(80);
        
        // set Padding Hbox
        hbox_KasKeuze.setPadding(new Insets(50, 5, 5, 370));
        hbox_Main.setPadding(new Insets(130, 5, 5, 30));
        
        // set visibility Hbox
        hbox_Actuatoren.setVisible(false);
        
        // Places the labels in the Vbox
        Labels_BinnenWaarden.getChildren().addAll(lb_TempratuurBinnen,lb_LuchtvochtigheidBinnen,lb_BodemvochtigheidBinnen,lb_LichtBinnen);
        Labels_BuitenWaarden.getChildren().addAll(lb_TempratuurBuiten,lb_WindsnelheidBuiten,lb_LuchtvochtigheidBuiten);
        Textfields_BinnenWaarden.getChildren().addAll(tf_TempratuurBinnen,tf_LuchtvochtigheidBinnen,tf_BodemvochtigheidBinnen,tf_LichtBinnen);
        Textfields_BuitenWaarden.getChildren().addAll(tf_TempratuurBuiten,tf_WindsnelheidBuiten,tf_LuchtvochtigheidBuiten);
        Labels_Knoppen.getChildren().addAll(lb_RaamOpenSluit,lb_KachelAanUit,lb_LampAanUit,lb_SproeierAanUit);
        Buttons_knoppenAan.getChildren().addAll(btn_RaamOpen,btn_KachelAan,btn_LampAan,btn_SproeierAan);
        Buttons_knoppenUit.getChildren().addAll(btn_RaamSluiten,btn_KachelUit,btn_LampUit,btn_SproeierUit);
        
        // Places the Vbox in the Hbox
        hbox_BinnenWaarden.getChildren().addAll(Labels_BinnenWaarden,Textfields_BinnenWaarden);
        hbox_BuitenWaarden.getChildren().addAll(Labels_BuitenWaarden,Textfields_BuitenWaarden);
        hbox_Actuatoren.getChildren().addAll(Labels_Knoppen,Buttons_knoppenAan,Buttons_knoppenUit);
        hbox_KasKeuze.getChildren().addAll(kas_Nummer,lb_HandmatigAansturen,handmatig_Aansturen);
        hbox_Main.getChildren().addAll(hbox_BinnenWaarden,hbox_BuitenWaarden,hbox_Actuatoren);
        
        // Places the mainHbox in the GridPane
        Gridpane_Hoofdscherm.add(hbox_KasKeuze, 0, 0);
        Gridpane_Hoofdscherm.add(hbox_Main, 0, 1);
        
        // Events
        handmatig_Aansturen.setOnAction(event->{
        
            ShowActuatorenHbox();
            
        });
        
        
        // set Center of the BorderPane
        this.setCenter(Gridpane_Hoofdscherm);
        
    }
    
    // Eventhandlers
    public void ShowActuatorenHbox(){
        
        hbox_Actuatoren.setVisible(true);
    }
    
    
}
