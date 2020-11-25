package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.view.Rootpane;

/**
 *
 * @author Colin
 */
public class TopUserBarController {

    private Rootpane rootpane;

    public TopUserBarController(Rootpane rootpane) {
        this.rootpane = rootpane;
    }

    public void products() {

    }

    public void users() {
        
    }

    public void logout() {
        rootpane.switchpane(0);
    }

    public void user() {

    }
}
