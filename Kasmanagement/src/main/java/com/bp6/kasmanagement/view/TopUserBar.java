package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.TopUserBarController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author Colin
 */
public class TopUserBar extends HBox {

    Button products, users, logout;
    Label user;

    public TopUserBar(TopUserBarController topUserBarController) {
        products = new Button("Producten");
        users = new Button("Gebruikers");
        logout = new Button("Uitloggen");
        logout.setOnAction(e -> {
            topUserBarController.logout();
        });

        user = new Label();
        this.getChildren().addAll(user, products, users, logout);
    }

}
