package com.bp6.kasmanagement.view;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author dahir
 */
public class Header extends Pane {

    private MenuBar mainMenuBar = new MenuBar();
    private Menu choiceBox = new Menu("Menu");

    private MenuItem Exit = new MenuItem("Exit");

    public Header() {
    this.setBackground(new Background(new BackgroundFill(Color.web("#8B0000"), null, null)));
    
        Exit.setOnAction(event -> {
            Platform.exit();
        });
        
        choiceBox.getItems().addAll(Exit);
        mainMenuBar.getMenus().add(choiceBox);
        getChildren().add(new VBox(mainMenuBar));

        mainMenuBar.setPrefWidth(3000);
        this.setPrefHeight(100);
    }
}
