package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.SensorManagementController;
import com.bp6.kasmanagement.model.BodemVochtigheidSensor;
import com.bp6.kasmanagement.model.LichtSensor;
import com.bp6.kasmanagement.model.LuchtVochtigheidSensor;
import com.bp6.kasmanagement.model.TempratuurSensor;
import com.bp6.kasmanagement.model.WindSensor;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private VBox Labels_Knoppen, Buttons_knoppenAan,Buttons_knoppenUit,vbox_kasToevoegen,vbox_locatieToevoegen,vbox_typeToevoegen;
    private HBox hbox_Main,hbox_BinnenWaarden, hbox_tableView,hbox_Actuatoren,hbox_KasKeuze,hbox_Toevoegen;
   
    private ChoiceBox kasToevoegen,kasWeerGeven,locatieToevoegen;
    private CheckBox sensor_Toevoegen;
    private Label lb_KasKeuze, lb_kasToevoegen,lb_locatieToevoegen,lb_typeToevoegen,lb_sensorToevoegen,lb_binnen,lb_buiten,lb_KasSelect,lb_Refresh;
    private TextField tf_toevoegen;
    private Button btn_Toevoegen,refresh,filter;
    
    private TableView binnenTempratuurTableView = new TableView();
    private TableView buitenTempratuurTableView = new TableView();
    private TableView binnenLuchtVochtTableView = new TableView();
    private TableView buitenLuchtVochtTableView = new TableView();
    private TableView windTableView = new TableView();
    private TableView lichtTableView = new TableView();
    private TableView bodemVochtTableView = new TableView();
    
    private File file_reloadknop = new File("Res/reloadbuttonn.jpg");
    private Image image_reloadknop= new Image(file_reloadknop.toURI().toString(), 20, 20, true, true);;
    private ImageView imageview = new ImageView(image_reloadknop);

    private SensorManagementController sensorManagementController;

  
    
    public SensorManagementScherm(){
        
        sensorManagementController= new SensorManagementController(this);
        
        // Creates Choicebox and sets prefSize
        kasToevoegen = new ChoiceBox();
        locatieToevoegen = new ChoiceBox();
        kasWeerGeven = new ChoiceBox();
        kasWeerGeven.setPrefSize(60, 30);
        kasToevoegen.setPrefSize(100, 30);
        locatieToevoegen.setPrefSize(100, 30);
        
        // Creates Checkbox and sets prefSize
        sensor_Toevoegen = new CheckBox();
        sensor_Toevoegen.setPrefSize(30, 30);
        
        // Creates HBox 
        hbox_Main = new HBox();
        hbox_tableView = new HBox();
        hbox_KasKeuze = new HBox();
        hbox_Toevoegen = new HBox();
        
        // Creates VBox    
        vbox_kasToevoegen = new VBox();
        vbox_locatieToevoegen = new VBox();
        vbox_typeToevoegen = new VBox();

        // Creates Gridpane
        Gridpane_Hoofdscherm = new GridPane();
        
        // Set Labels    
        lb_KasKeuze = new Label("Kas:");
        lb_kasToevoegen = new Label("Kas:");
        lb_locatieToevoegen = new Label("Locatie:");
        lb_typeToevoegen = new Label("Type:");
        lb_sensorToevoegen = new Label("Sensor toevoegen");
        lb_binnen=new Label("Binnen:   ");
        lb_buiten=new Label("       Buiten:   ");
        lb_KasSelect = new Label("Selecteer kas:");
        lb_Refresh= new Label("Refresh");
        
        // Set Fonts labels
        lb_KasKeuze.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_kasToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_locatieToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_typeToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_sensorToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_binnen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_buiten.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_KasSelect.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_Refresh.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
         // Set witdth labels
        lb_KasKeuze.setPrefHeight(30);
        lb_kasToevoegen.setPrefHeight(30);
        lb_locatieToevoegen.setPrefHeight(30);
        lb_typeToevoegen.setPrefHeight(30);
        lb_sensorToevoegen.setPrefHeight(30);
        lb_binnen.setPrefHeight(30);
        lb_buiten.setPrefHeight(30);
        lb_KasSelect.setPrefHeight(30);
        lb_Refresh.setPrefHeight(30);
        
        // Sets textfields
        tf_toevoegen = new TextField();
        
        
        // Sets width textfields
        tf_toevoegen.setPrefSize(100, 30);
        
        // Sets button
        btn_Toevoegen = new Button("Toevoegen");
        refresh = new Button();
        filter = new Button("Filter");
        
        // Sets size button
        btn_Toevoegen.setPrefSize(100,30);
        refresh.setPrefSize(10, 10);
        filter.setPrefSize(60, 30);
        
        /* buttonImage */
        imageview.setPreserveRatio(true);
        refresh.setGraphic(imageview);
        
        
        
        // Sets padding vbox
        vbox_kasToevoegen.setPadding(new Insets(5, 5, 5, 5));
        vbox_locatieToevoegen.setPadding(new Insets(5, 5, 5, 5));
        vbox_typeToevoegen.setPadding(new Insets(5, 5, 5, 5));
       
        // Sets spacing Vbox
        vbox_kasToevoegen.setSpacing(10);
        vbox_locatieToevoegen.setSpacing(10);
        vbox_typeToevoegen.setSpacing(10);
        
         // Sets spacing Hbox
        hbox_KasKeuze.setSpacing(30);
        hbox_Main.setSpacing(500);
        hbox_Toevoegen.setSpacing(10);
        
        // set Padding Hbox
        hbox_KasKeuze.setPadding(new Insets(30, 5, 5, 70));
        hbox_Main.setPadding(new Insets(30, 5, 5, 70));
        hbox_tableView.setPadding(new Insets(30, 5, 5, 70));
        
        // set visibility Hbox
        hbox_Toevoegen.setVisible(false);
        
        // Places the items in the Vbox
        vbox_kasToevoegen.getChildren().addAll(lb_kasToevoegen,kasToevoegen);
        vbox_locatieToevoegen.getChildren().addAll(lb_locatieToevoegen,locatieToevoegen);
        vbox_typeToevoegen.getChildren().addAll(lb_typeToevoegen,tf_toevoegen,btn_Toevoegen);
        
        
        // Places the Vbox in the Hbox
        hbox_tableView.getChildren().addAll(kasWeerGeven,lb_binnen,binnenTempratuurTableView,binnenLuchtVochtTableView,lichtTableView,bodemVochtTableView,lb_buiten,
                buitenTempratuurTableView,buitenLuchtVochtTableView ,windTableView);
        hbox_KasKeuze.getChildren().addAll(lb_KasSelect,kasWeerGeven,filter,lb_sensorToevoegen,sensor_Toevoegen,lb_Refresh,refresh);
        hbox_Toevoegen.getChildren().addAll(vbox_kasToevoegen,vbox_locatieToevoegen,vbox_typeToevoegen);
        hbox_Main.getChildren().addAll(hbox_Toevoegen);
       
        
        // Places the mainHbox in the GridPane
        Gridpane_Hoofdscherm.add(hbox_KasKeuze, 0, 0);
        Gridpane_Hoofdscherm.add(hbox_tableView, 0, 1);
        Gridpane_Hoofdscherm.add(hbox_Main, 0, 2);
        
        
        // Setting tablecolumns
        TableColumn BinnenTemp = new TableColumn("Tempratuur in °C");
        BinnenTemp.setCellValueFactory(new PropertyValueFactory<TempratuurSensor,String>("tempratuurInput"));

        TableColumn BuitenTemp = new TableColumn<>("Tempratuur in °C");
        BuitenTemp.setCellValueFactory(new PropertyValueFactory<TempratuurSensor,String>("tempratuurInput"));

        TableColumn<String, LuchtVochtigheidSensor> BinnenLuchtVocht = new TableColumn<>("Luchtvocht in %");
        BinnenLuchtVocht.setCellValueFactory(new PropertyValueFactory<>("luchtVochtigheidInput"));

        TableColumn<String, LuchtVochtigheidSensor> BuitenLuchtVocht = new TableColumn<>("Luchtvocht in %");
        BuitenLuchtVocht.setCellValueFactory(new PropertyValueFactory<>("luchtVochtigheidInput"));
        
        TableColumn<String, WindSensor> Wind = new TableColumn<>("Wind in km/u");
        Wind.setCellValueFactory(new PropertyValueFactory<>("windInput"));
        
        TableColumn<String, LichtSensor> Licht = new TableColumn<>("Licht in lux");
        Licht.setCellValueFactory(new PropertyValueFactory<>("lichtInput"));
        
        TableColumn<String, BodemVochtigheidSensor> BodemVocht = new TableColumn<>("Bodemvocht in %");
        BodemVocht.setCellValueFactory(new PropertyValueFactory<>("bodemVochtInput"));
        
        

        // Setting tableviews
        binnenTempratuurTableView.setMaxSize(120, 300);
        binnenTempratuurTableView.setItems(sensorManagementController.getBinnenTempratuurData());
        binnenTempratuurTableView.getColumns().addAll(BinnenTemp);
        binnenTempratuurTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        buitenTempratuurTableView.setMaxSize(120, 300);
        buitenTempratuurTableView.setItems(sensorManagementController.getBuitenTempratuurData());
        buitenTempratuurTableView.getColumns().addAll(BuitenTemp);
        buitenTempratuurTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        binnenLuchtVochtTableView.setMaxSize(120, 300);
        binnenLuchtVochtTableView.setItems(sensorManagementController.getBinnenLuchtVochtigheidData());
        binnenLuchtVochtTableView.getColumns().addAll(BinnenLuchtVocht);
        binnenLuchtVochtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        buitenLuchtVochtTableView.setMaxSize(120, 300);
        buitenLuchtVochtTableView.setItems(sensorManagementController.getBuitenLuchtVochtigheidData());
        buitenLuchtVochtTableView.getColumns().addAll(BuitenLuchtVocht);
        buitenLuchtVochtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        windTableView.setMaxSize(120, 300);
        windTableView.setItems(sensorManagementController.getWindData());
        windTableView.getColumns().addAll(Wind);
        windTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        lichtTableView.setMaxSize(120, 300);
        lichtTableView.setItems(sensorManagementController.getLichtData());
        lichtTableView.getColumns().addAll(Licht);
        lichtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        bodemVochtTableView.setMaxSize(120, 300);
        bodemVochtTableView.setItems(sensorManagementController.getBodemVochtigheidData());
        bodemVochtTableView.getColumns().addAll(BodemVocht);
        bodemVochtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
        
        
        // Events
        sensor_Toevoegen.setOnAction(event->{
            ShowToevoegenHbox();
//            
            if(sensor_Toevoegen.isSelected()){
                ShowToevoegenHbox();
            }
            else{
                notShowToevoegenHbox();
            }
        });
        
        
        btn_Toevoegen.setOnAction((ActionEvent event)->{
            
            if(kasToevoegen.getSelectionModel().isEmpty() == false && locatieToevoegen.getSelectionModel().isEmpty() == false && tf_toevoegen.getText().isEmpty() == false){
                
                sensorManagementController.SetNieuweSensor();
            }
        });
        
        filter.setOnAction(event->{
        
        binnenTempratuurTableView.getItems().clear();
        buitenTempratuurTableView.getItems().clear();
        binnenLuchtVochtTableView.getItems().clear();
        buitenLuchtVochtTableView.getItems().clear();
        windTableView.getItems().clear();
        lichtTableView.getItems().clear();
        bodemVochtTableView.getItems().clear();
        
        binnenTempratuurTableView.setItems(sensorManagementController.getFilterBinnenTempratuurData());
        buitenTempratuurTableView.setItems(sensorManagementController.getFilterBuitenTempratuurData());
        binnenLuchtVochtTableView.setItems(sensorManagementController.getFilterBinnenLuchtVochtigheidData());
        buitenLuchtVochtTableView.setItems(sensorManagementController.getFilterBuitenLuchtVochtigheidData());
        windTableView.setItems(sensorManagementController.getFilterWindData());
        lichtTableView.setItems(sensorManagementController.getFilterLichtData());
        bodemVochtTableView.setItems(sensorManagementController.getFilterBodemVochtigheidData());
        
        binnenTempratuurTableView.refresh();
        buitenTempratuurTableView.refresh();
        binnenLuchtVochtTableView.refresh();
        buitenLuchtVochtTableView.refresh();
        windTableView.refresh();
        lichtTableView.refresh();
        bodemVochtTableView.refresh();
            
            
        });
        
        refresh.setOnAction(event->{
        
        binnenTempratuurTableView.getItems().clear();
        buitenTempratuurTableView.getItems().clear();
        binnenLuchtVochtTableView.getItems().clear();
        buitenLuchtVochtTableView.getItems().clear();
        windTableView.getItems().clear();
        lichtTableView.getItems().clear();
        bodemVochtTableView.getItems().clear();
        
        binnenTempratuurTableView.setItems(sensorManagementController.getBinnenTempratuurData());
        buitenTempratuurTableView.setItems(sensorManagementController.getBuitenTempratuurData());
        binnenLuchtVochtTableView.setItems(sensorManagementController.getBinnenLuchtVochtigheidData());
        buitenLuchtVochtTableView.setItems(sensorManagementController.getBuitenLuchtVochtigheidData());
        windTableView.setItems(sensorManagementController.getWindData());
        lichtTableView.setItems(sensorManagementController.getLichtData());
        bodemVochtTableView.setItems(sensorManagementController.getBodemVochtigheidData());
        
        binnenTempratuurTableView.refresh();
        buitenTempratuurTableView.refresh();
        binnenLuchtVochtTableView.refresh();
        buitenLuchtVochtTableView.refresh();
        windTableView.refresh();
        lichtTableView.refresh();
        bodemVochtTableView.refresh();
            
        });
        
        
        // Setting choiceboxdata
        sensorManagementController.getKasnummerEnLocatie();

        
        // set Center of the BorderPane
        this.setCenter(Gridpane_Hoofdscherm); 

    }

    
    
    // Eventhandlers
    public void ShowToevoegenHbox(){
        
        hbox_Toevoegen.setVisible(true);
    }
    
    public void notShowToevoegenHbox(){
        
        hbox_Toevoegen.setVisible(false);
    }

    public ChoiceBox getKasWeerGeven() {
        return kasWeerGeven;
    }
    
    public ChoiceBox getKasToevoegen() {
        return kasToevoegen;
    }

    public ChoiceBox getLocatieToevoegen() {
        return locatieToevoegen;
    }

    public TextField getTf_toevoegen() {
        return tf_toevoegen;
    }

    public TableView getBinnenTempratuurTableView() {
        return binnenTempratuurTableView;
    }

    public TableView getBuitenTempratuurTableView() {
        return buitenTempratuurTableView;
    }

    public TableView getBinnenLuchtVochtTableView() {
        return binnenLuchtVochtTableView;
    }

    public TableView getBuitenLuchtVochtTableView() {
        return buitenLuchtVochtTableView;
    }

    public TableView getWindTableView() {
        return windTableView;
    }

    public TableView getLichtTableView() {
        return lichtTableView;
    }

    public TableView getBodemVochtTableView() {
        return bodemVochtTableView;
    }
   
    
    
}
