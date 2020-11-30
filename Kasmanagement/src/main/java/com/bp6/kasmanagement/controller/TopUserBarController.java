package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.view.Rootpane;
import com.bp6.kasmanagement.view.StartScherm;

/**
 *
 * @author Colin
 */
public class TopUserBarController {

    private Rootpane rootpane;
    private StartScherm startscherm;

    public TopUserBarController(Rootpane rootpane) {
        this.rootpane = rootpane;
    }

    public void users(String user) {
        startscherm.switchpane(2, user);
    }

    public void products(String user) {
        startscherm.switchpane(1, user);
    }

    public void sensor_Management() {
        startscherm.switchpane(2);
    }

    public void logout() {
        rootpane.switchpane(0);
    }

    public void user() {

    }

    public void setStartscherm(StartScherm startscherm) {
        this.startscherm = startscherm;
    }

}
