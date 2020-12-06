package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.DBCPDataSource;
import com.bp6.kasmanagement.model.BodemVochtigheidSensor;
import com.bp6.kasmanagement.model.KasInformatie;
import com.bp6.kasmanagement.model.LichtSensor;
import com.bp6.kasmanagement.model.LuchtVochtigheidSensor;
import com.bp6.kasmanagement.model.TempratuurSensor;
import com.bp6.kasmanagement.model.WindSensor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
   
    private ChoiceBox kasToevoegen,locatieToevoegen;
    private CheckBox handmatig_Aansturen,sensor_Toevoegen;
    private Label lb_RaamOpenSluit, lb_SproeierAanUit,lb_KachelAanUit,lb_LampAanUit,lb_HandmatigAansturen, lb_KasKeuze, lb_kasToevoegen,lb_locatieToevoegen,lb_typeToevoegen,lb_sensorToevoegen;
    private TextField tf_TempratuurBinnen, tf_TempratuurBuiten,tf_WindsnelheidBuiten, tf_LuchtvochtigheidBinnen,tf_LuchtvochtigheidBuiten, tf_BodemvochtigheidBinnen,tf_LichtBinnen,tf_toevoegen;
    private Button btn_RaamOpen, btn_RaamSluiten, btn_SproeierAan,btn_SproeierUit,btn_KachelAan, btn_KachelUit,btn_LampAan,btn_LampUit,btn_DataVullen,btn_Toevoegen;
    private TableView binnenTempratuurTableView = new TableView();
    private TableView buitenTempratuurTableView = new TableView();
    private TableView binnenLuchtVochtTableView = new TableView();
    private TableView buitenLuchtVochtTableView = new TableView();
    private TableView windTableView = new TableView();
    private TableView lichtTableView = new TableView();
    private TableView bodemVochtTableView = new TableView();
    ObservableList<TempratuurSensor> BinnenTempArray = FXCollections.observableArrayList();
    ObservableList<TempratuurSensor> BuitenTempArray = FXCollections.observableArrayList();
    ObservableList<LuchtVochtigheidSensor> BinnenLuchtArray = FXCollections.observableArrayList();
    ObservableList<LuchtVochtigheidSensor> BuitenLuchtArray = FXCollections.observableArrayList();
    ObservableList<WindSensor> WindArray = FXCollections.observableArrayList();
    ObservableList<LichtSensor> LichtArray = FXCollections.observableArrayList();
    ObservableList<BodemVochtigheidSensor> BodemArray = FXCollections.observableArrayList();
//    private ArrayList<TempratuurSensor> BinnenTempArray = new ArrayList<>();
//    private ArrayList<TempratuurSensor> BuitenTempArray = new ArrayList<>();private ArrayList<LuchtVochtigheidSensor> BinnenLuchtArray = new ArrayList<>();
//    private ArrayList<LuchtVochtigheidSensor> BuitenLuchtArray = new ArrayList<>();
//    private ArrayList<WindSensor> WindArray = new ArrayList<>();
//    private ArrayList<LichtSensor> LichtArray = new ArrayList<>();
//    private ArrayList<BodemVochtigheidSensor> BodemArray = new ArrayList<>();
  
    
    public SensorManagementScherm(){
        
        
        // Creates Choicebox and sets prefSize
        
        kasToevoegen = new ChoiceBox();
        locatieToevoegen = new ChoiceBox();
        kasToevoegen.setPrefSize(100, 30);
        locatieToevoegen.setPrefSize(100, 30);
        
        // Creates Checkbox and sets prefSize
        handmatig_Aansturen = new CheckBox();
        sensor_Toevoegen = new CheckBox();
        handmatig_Aansturen.setPrefSize(30, 30);
        sensor_Toevoegen.setPrefSize(30, 30);
        
        // Creates HBox 
        hbox_Main = new HBox();
        hbox_tableView = new HBox();
        hbox_Actuatoren = new HBox();
        hbox_KasKeuze = new HBox();
        hbox_Toevoegen = new HBox();
        
        // Creates VBox    
     
        Labels_Knoppen = new VBox();
        Buttons_knoppenAan = new VBox();
        Buttons_knoppenUit = new VBox();
        vbox_kasToevoegen = new VBox();
        vbox_locatieToevoegen = new VBox();
        vbox_typeToevoegen = new VBox();

        // Creates Gridpane
        Gridpane_Hoofdscherm = new GridPane();
        
        // Set Labels    
       
        lb_RaamOpenSluit = new Label("Raam:");
        lb_SproeierAanUit = new Label("Sproeier:");
        lb_KachelAanUit = new Label("Kachel:");
        lb_LampAanUit = new Label("Lamp:");
        lb_HandmatigAansturen = new Label("Actuatoren aansturen->");
        lb_KasKeuze = new Label("Kas:");
        lb_kasToevoegen = new Label("Kas:");
        lb_locatieToevoegen = new Label("Locatie:");
        lb_typeToevoegen = new Label("Type:");
        lb_sensorToevoegen = new Label("Sensor toevoegen->");
        
        // Set Fonts labels
        
        lb_RaamOpenSluit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_SproeierAanUit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_KachelAanUit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_LampAanUit.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_HandmatigAansturen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_KasKeuze.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_kasToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_locatieToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_typeToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lb_sensorToevoegen.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
         // Set witdth labels
        
        lb_RaamOpenSluit.setPrefHeight(30);
        lb_SproeierAanUit.setPrefHeight(30);
        lb_KachelAanUit.setPrefHeight(30);
        lb_LampAanUit.setPrefHeight(30);
        lb_HandmatigAansturen.setPrefHeight(30);
        lb_KasKeuze.setPrefHeight(30);
        lb_kasToevoegen.setPrefHeight(30);
        lb_locatieToevoegen.setPrefHeight(30);
        lb_typeToevoegen.setPrefHeight(30);
        lb_sensorToevoegen.setPrefHeight(30);
        
        // Sets textfields
       
        tf_toevoegen = new TextField();
        
        // Sets width textfields
        
        tf_toevoegen.setPrefSize(100, 30);
        
        
        
        // Sets button
        btn_RaamOpen = new Button("Openen");
        btn_RaamSluiten = new Button("Sluiten");
        btn_SproeierAan = new Button("Aan");
        btn_SproeierUit = new Button("Uit");
        btn_KachelAan = new Button("Aan");
        btn_KachelUit = new Button("Uit");
        btn_LampAan = new Button("Aan");
        btn_LampUit = new Button("Uit");
        btn_Toevoegen = new Button("Toevoegen");
        
        // Sets size button
        btn_KachelAan.setPrefSize(70,30);
        btn_KachelUit.setPrefSize(70,30);
        btn_RaamOpen.setPrefSize(70,30);
        btn_RaamSluiten.setPrefSize(70,30);
        btn_SproeierAan.setPrefSize(70,30);
        btn_SproeierUit.setPrefSize(70,30);
        btn_LampAan.setPrefSize(70,30);
        btn_LampUit.setPrefSize(70,30);
        btn_Toevoegen.setPrefSize(100,30);
        
        // Sets padding vbox
        
        vbox_kasToevoegen.setPadding(new Insets(5, 5, 5, 5));
        vbox_locatieToevoegen.setPadding(new Insets(5, 5, 5, 5));
        vbox_typeToevoegen.setPadding(new Insets(5, 5, 5, 5));
       
        // Sets spacing Vbox
        
        Labels_Knoppen.setSpacing(10);
        Buttons_knoppenAan.setSpacing(10);
        Buttons_knoppenUit.setSpacing(10);
        vbox_kasToevoegen.setSpacing(10);
        vbox_locatieToevoegen.setSpacing(10);
        vbox_typeToevoegen.setSpacing(10);
        
        
         // Sets spacing Hbox
        
//        hbox_tableView.setSpacing(10);
        hbox_Actuatoren.setSpacing(15);
        hbox_KasKeuze.setSpacing(30);
        hbox_Main.setSpacing(500);
        hbox_Toevoegen.setSpacing(10);
        
        // set Padding Hbox
        hbox_KasKeuze.setPadding(new Insets(30, 5, 5, 300));
        hbox_Main.setPadding(new Insets(350, 5, 5, 10));
        hbox_tableView.setPadding(new Insets(30, 5, 5, 70));
        
        
        
        // set visibility Hbox
        hbox_Actuatoren.setVisible(false);
        hbox_Toevoegen.setVisible(false);
        
        // Places the items in the Vbox
        
        Labels_Knoppen.getChildren().addAll(lb_RaamOpenSluit,lb_KachelAanUit,lb_LampAanUit,lb_SproeierAanUit);
        Buttons_knoppenAan.getChildren().addAll(btn_RaamOpen,btn_KachelAan,btn_LampAan,btn_SproeierAan);
        Buttons_knoppenUit.getChildren().addAll(btn_RaamSluiten,btn_KachelUit,btn_LampUit,btn_SproeierUit);
        vbox_kasToevoegen.getChildren().addAll(lb_kasToevoegen,kasToevoegen);
        vbox_locatieToevoegen.getChildren().addAll(lb_locatieToevoegen,locatieToevoegen);
        vbox_typeToevoegen.getChildren().addAll(lb_typeToevoegen,tf_toevoegen,btn_Toevoegen);
        
        
        // Places the Vbox in the Hbox
        
        hbox_tableView.getChildren().addAll(binnenTempratuurTableView,buitenTempratuurTableView,binnenLuchtVochtTableView,buitenLuchtVochtTableView ,windTableView,lichtTableView, bodemVochtTableView);
        hbox_Actuatoren.getChildren().addAll(Labels_Knoppen,Buttons_knoppenAan,Buttons_knoppenUit);
        hbox_KasKeuze.getChildren().addAll(lb_HandmatigAansturen,handmatig_Aansturen,lb_sensorToevoegen,sensor_Toevoegen);
        hbox_Toevoegen.getChildren().addAll(vbox_kasToevoegen,vbox_locatieToevoegen,vbox_typeToevoegen);
        hbox_Main.getChildren().addAll(hbox_Toevoegen,hbox_Actuatoren);
       
        
        // Places the mainHbox in the GridPane
        Gridpane_Hoofdscherm.add(hbox_KasKeuze, 0, 0);
        Gridpane_Hoofdscherm.add(hbox_tableView, 0, 1);
        Gridpane_Hoofdscherm.add(hbox_Main, 0, 1);
        
        
        // Events
        handmatig_Aansturen.setOnAction(event->{
        
            ShowActuatorenHbox();
            
        });
        
        sensor_Toevoegen.setOnAction(event->{
        
            ShowToevoegenHbox();
            
        });
        
        btn_Toevoegen.setOnAction((ActionEvent event)->{
            
            if(kasToevoegen.getSelectionModel().isEmpty() == false && locatieToevoegen.getSelectionModel().isEmpty() == false && tf_toevoegen.getText().isEmpty() == false){
                
                Connection con = null;
            try {
                    
                    con = DBCPDataSource.getConnection();
                    Statement stat = con.createStatement();
                    
                    
                    
                    String strKasToevoegen = kasToevoegen.getSelectionModel().getSelectedItem().toString();
                    String strLocatieToevoegen = locatieToevoegen.getSelectionModel().getSelectedItem().toString();
                    int IntKastoevoegen=Integer.parseInt(strKasToevoegen);
                    String strTypeToevoegen = tf_toevoegen.getText();
                    
                    ResultSet resultSensorId = 
                    stat.executeQuery("SELECT MAX(sensorId) oldid FROM sensorlocatie");
                    Integer IntegerSensorId = 0;
                    
                    while(resultSensorId.next()){    
                        
                    Integer strSensorId = resultSensorId.getInt("oldid");
                    IntegerSensorId = strSensorId + 1;
                    
                        }
                    stat.executeUpdate("INSERT INTO sensorlocatie VALUES (" + IntegerSensorId + " ,'" + IntKastoevoegen + "','" + strLocatieToevoegen + "','" + strTypeToevoegen + "')");

                    } catch (SQLException se) {
                    se.printStackTrace();
                        } 
                      finally {
                            try {
                                con.close();
                              } 
                            catch (Exception e) {
                              }
                      }
                
            }
        });
        
        
      
        
        Connection con1 = null;
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultTempInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "tempratuursensor.tempInput,\n" +
                    "tempratuursensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN tempratuursensor ON tempratuursensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE tempInput IS NOT NULL\n"
                    + "ORDER BY tempratuursensor.datumTijd DESC LIMIT 12");
                    
                while(resultTempInput.next()){
                       
                        String strLocatie = resultTempInput.getString("locatie");
                        String strType= resultTempInput.getString("type");
                        String strInput= resultTempInput.getString("tempInput");
                        String strDatumTijd= resultTempInput.getString("datumTijd");
                        
                        if(strLocatie.equals("binnen")){
                            TempratuurSensor binnenTempratuurSensor = new TempratuurSensor(strLocatie,strType,strInput,strDatumTijd);
                            BinnenTempArray.add(binnenTempratuurSensor);
                        }
                        if(strLocatie.equals("buiten")){
                            TempratuurSensor buitenTempratuurSensor = new TempratuurSensor(strLocatie,strType,strInput,strDatumTijd);
                            BuitenTempArray.add(buitenTempratuurSensor);
                            
                        }
                        
                        
                        
                    }
          
                        
                    } catch (SQLException se) {
                    se.printStackTrace();
                        } 
                      finally {
                            try {
                                con1.close();
                              } 
                            catch (Exception e) {
                              }
                      }
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultLuchtVochtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "luchtvochtsensor.luchtVochtInput,\n" +
                    "luchtvochtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN luchtvochtsensor ON luchtvochtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE luchtVochtInput IS NOT NULL\n"
                    + "ORDER BY luchtvochtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultLuchtVochtInput.next()){
                       
                        String strLocatie = resultLuchtVochtInput.getString("locatie");
                        String strType= resultLuchtVochtInput.getString("type");
                        String strInput= resultLuchtVochtInput.getString("luchtVochtInput");
                        String strDatumTijd= resultLuchtVochtInput.getString("datumTijd");
                        
                        if(strLocatie.equals("binnen")){
                            LuchtVochtigheidSensor binnenLuchtSensor = new LuchtVochtigheidSensor(strLocatie,strType,strInput,strDatumTijd);
                            BinnenLuchtArray.add(binnenLuchtSensor);
                            
                        }
                        if(strLocatie.equals("buiten")){
                            LuchtVochtigheidSensor buitenLuchtSensor = new LuchtVochtigheidSensor(strLocatie,strType,strInput,strDatumTijd);
                            BuitenLuchtArray.add(buitenLuchtSensor);
                        }
                      }
          
                        
                    } catch (SQLException se) {
                    se.printStackTrace();
                        } 
                      finally {
                            try {
                                con1.close();
                              } 
                            catch (Exception e) {
                              }
                      }
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultWindInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "windsensor.windInput,\n" +
                    "windsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN windsensor ON windsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE windInput IS NOT NULL\n"
                    + "ORDER BY windsensor.datumTijd DESC LIMIT 12");
                    
                while(resultWindInput.next()){
                       
                        String strLocatie = resultWindInput.getString("locatie");
                        String strType= resultWindInput.getString("type");
                        String strInput= resultWindInput.getString("windInput");
                        String strDatumTijd= resultWindInput.getString("datumTijd");
                        
                        WindSensor windSensor = new WindSensor(strLocatie,strType,strInput,strDatumTijd);
                        WindArray.add(windSensor);
                        
                        
                      }
          
                        
                    } catch (SQLException se) {
                    se.printStackTrace();
                        } 
                      finally {
                            try {
                                con1.close();
                              } 
                            catch (Exception e) {
                              }
                      }
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultLichtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "lichtsensor.lichtInput,\n" +
                    "lichtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN lichtsensor ON lichtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE lichtInput IS NOT NULL\n"
                    + "ORDER BY lichtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultLichtInput.next()){
                       
                        String strLocatie = resultLichtInput.getString("locatie");
                        String strType= resultLichtInput.getString("type");
                        String strInput= resultLichtInput.getString("lichtInput");
                        String strDatumTijd= resultLichtInput.getString("datumTijd");
                        
                        LichtSensor lichtSensor = new LichtSensor(strLocatie,strType,strInput,strDatumTijd);
                        LichtArray.add(lichtSensor);
                        
                        
                      }
          
                        
                    } catch (SQLException se) {
                    se.printStackTrace();
                        } 
                      finally {
                            try {
                                con1.close();
                              } 
                            catch (Exception e) {
                              }
                      }
        
        try{
            
            con1 = DBCPDataSource.getConnection();
            Statement stat = con1.createStatement();
            
            ResultSet resultBodemVochtInput = stat.executeQuery("SELECT \n" +
                    "sensorlocatie.locatie,\n"+ 
                    "sensorlocatie.type,\n" +
                    "bodemvochtsensor.bodemvochtInput,\n" +
                    "bodemvochtsensor.datumTijd\n" +
                    "FROM kas\n" +
                    "INNER JOIN sensorlocatie ON sensorlocatie.kasNummer = kas.kasNummer\n" +
                    "LEFT JOIN bodemvochtsensor ON bodemvochtsensor.sensorId = sensorlocatie.sensorId\n" +
                    "WHERE bodemvochtInput IS NOT NULL\n"
                    + "ORDER BY bodemvochtsensor.datumTijd DESC LIMIT 12");
                    
                while(resultBodemVochtInput.next()){
                       
                        String strLocatie = resultBodemVochtInput.getString("locatie");
                        String strType= resultBodemVochtInput.getString("type");
                        String strInput= resultBodemVochtInput.getString("bodemvochtInput");
                        String strDatumTijd= resultBodemVochtInput.getString("datumTijd");
                        
                        BodemVochtigheidSensor bodemSensor = new BodemVochtigheidSensor(strLocatie,strType,strInput,strDatumTijd);
                        BodemArray.add(bodemSensor);
                        
                        
                        
                      }
          
                        
                    } catch (SQLException se) {
                    se.printStackTrace();
                        } 
                      finally {
                            try {
                                con1.close();
                              } 
                            catch (Exception e) {
                              }
                      }
        
        
        TableColumn BinnenTemp = new TableColumn("Temp:");
        BinnenTemp.setCellValueFactory(new PropertyValueFactory<TempratuurSensor,String>("tempratuurInput"));

        TableColumn BuitenTemp = new TableColumn<>("Temp:");
        BuitenTemp.setCellValueFactory(new PropertyValueFactory<TempratuurSensor,String>("tempratuurInput"));

        TableColumn<String, LuchtVochtigheidSensor> BinnenLuchtVocht = new TableColumn<>("Lucht:");
        BinnenLuchtVocht.setCellValueFactory(new PropertyValueFactory<>("luchtVochtigheidInput"));

        TableColumn<String, LuchtVochtigheidSensor> BuitenLuchtVocht = new TableColumn<>("Lucht:");
        BuitenLuchtVocht.setCellValueFactory(new PropertyValueFactory<>("luchtVochtigheidInput"));
        
        TableColumn<String, WindSensor> Wind = new TableColumn<>("Wind:");
        Wind.setCellValueFactory(new PropertyValueFactory<>("windInput"));
        
        TableColumn<String, LichtSensor> Licht = new TableColumn<>("Licht:");
        Licht.setCellValueFactory(new PropertyValueFactory<>("lichtInput"));
        
        TableColumn<String, BodemVochtigheidSensor> BodemVocht = new TableColumn<>("Bodem:");
        BodemVocht.setCellValueFactory(new PropertyValueFactory<>("bodemVochtInput"));

        
        binnenTempratuurTableView.setMaxSize(80, 300);
        binnenTempratuurTableView.setItems(BinnenTempArray);
        binnenTempratuurTableView.getColumns().addAll(BinnenTemp);
        binnenTempratuurTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        buitenTempratuurTableView.setMaxSize(80, 300);
        buitenTempratuurTableView.setItems(BuitenTempArray);
        buitenTempratuurTableView.getColumns().addAll(BuitenTemp);
        buitenTempratuurTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        binnenLuchtVochtTableView.setMaxSize(80, 300);
        binnenLuchtVochtTableView.setItems(BinnenLuchtArray);
        binnenLuchtVochtTableView.getColumns().addAll(BinnenLuchtVocht);
        binnenLuchtVochtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        buitenLuchtVochtTableView.setMaxSize(80, 300);
        buitenLuchtVochtTableView.setItems(BuitenLuchtArray);
        buitenLuchtVochtTableView.getColumns().addAll(BuitenLuchtVocht);
        buitenLuchtVochtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        windTableView.setMaxSize(80, 300);
        windTableView.setItems(WindArray);
        windTableView.getColumns().addAll(Wind);
        windTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        lichtTableView.setMaxSize(80, 300);
        lichtTableView.setItems(LichtArray);
        lichtTableView.getColumns().addAll(Licht);
        lichtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        bodemVochtTableView.setMaxSize(80, 300);
        bodemVochtTableView.setItems(BodemArray);
        bodemVochtTableView.getColumns().addAll(BodemVocht);
        bodemVochtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
           

          // set Center of the BorderPane
        this.setCenter(Gridpane_Hoofdscherm);    

    }
    
    // Eventhandlers
    public void ShowActuatorenHbox(){
        
        hbox_Actuatoren.setVisible(true);
    }
    
    public void ShowToevoegenHbox(){
        
        hbox_Toevoegen.setVisible(true);
    }
   
    
    
}
