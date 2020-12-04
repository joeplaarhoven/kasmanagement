package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.InlogController;
import com.bp6.kasmanagement.controller.TopUserBarController;
import com.bp6.kasmanagement.model.Gebruiker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author Colin
 */
public class Rootpane extends BorderPane {

    private final InlogController inlogController;
    private final TopUserBarController topUserBarController;

    private final TopUserBar topUserBar;

    private final Pane header;
    private final BorderPane footer;
    private InlogScherm inlogscherm;
    private StartScherm startscherm;
    private final BorderPane productenScherm;
    String userString;

    private Gebruiker user;

    public Rootpane() {

        inlogController = new InlogController(this);
        topUserBarController = new TopUserBarController(this);

        topUserBar = new TopUserBar(topUserBarController);

        header = new Header();
        footer = new Footer();

        inlogscherm = new InlogScherm(inlogController);

        startscherm = new StartScherm(topUserBar);

        productenScherm = new IdealeGroeiScherm();
        topUserBarController.setStartscherm(startscherm);

        this.setTop(header);
        this.setBottom(footer);
        this.setCenter(inlogscherm);

        this.setBackground(new Background(new BackgroundFill(Color.web("#FFFFE0"), null, null)));

    }

    public void setUser(String username) {
        userString = username;
        if (user == null) {
            user = new Gebruiker(username);
        } else {
            user.setUsername(username);
        }

    }

    public void switchpane(int value) {

        switch (value) {
            case 0:

                this.setCenter(inlogscherm);
                break;

            case 1:

                this.setCenter(startscherm);
                break;
        }

    }

    public TopUserBar getTopUserBar() {
        return topUserBar;
    }

}
