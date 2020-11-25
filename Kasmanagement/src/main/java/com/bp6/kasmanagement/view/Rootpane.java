package com.bp6.kasmanagement.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Colin
 */
public class Rootpane extends BorderPane {

    private final Pane header = new Header();
    private final BorderPane footer = new Footer();
    private final InlogScherm inlogscherm = new InlogScherm();
    private final BorderPane gebruikersscherm = new GebruikerScherm();

    public Rootpane() {

        this.setTop(header);
        this.setBottom(footer);
        this.setCenter(inlogscherm);

    }

    public void switchpane(int value) {

        switch (value) {
            case 0:
                this.setCenter(inlogscherm);
                break;

            case 1:
                this.setCenter(gebruikersscherm);
                break;
        }

    }

}
