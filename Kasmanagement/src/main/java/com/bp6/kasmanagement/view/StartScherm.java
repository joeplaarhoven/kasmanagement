package com.bp6.kasmanagement.view;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author Colin
 */
public class StartScherm extends BorderPane {

    private KasInformatieScherm kasInformatieScherm;
    private ProductenScherm productenScherm;
    private SensorManagementScherm sensorManagementScherm;
    

    public StartScherm(TopUserBar topUserBar) {

        kasInformatieScherm = new KasInformatieScherm();
        productenScherm = new ProductenScherm();
        sensorManagementScherm = new SensorManagementScherm();

        setTop(topUserBar);
    }

    public void switchpane(int value, String user) {

        switch (value) {
            case 0:
                
                kasInformatieScherm.lblUser.setText(user);
                kasInformatieScherm.start();
                this.setCenter(kasInformatieScherm);
                
                break;

            case 1:
                this.setCenter(productenScherm);
                break;

            case 2:
                this.setCenter(sensorManagementScherm);
                break;
        }
    }

}
