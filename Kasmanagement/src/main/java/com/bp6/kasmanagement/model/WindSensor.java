/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.model;

/**
 *
 * @author dahir
 */
public class WindSensor {
    
    private Integer sensorId;
    private Integer windInput;
    private String windManagement;
    private String datumTijd;
    
    
    
    public WindSensor(Integer sensorId, Integer windInput, String datumTijd){
        
        
        this.windInput = windInput;
        this.datumTijd = datumTijd;
        this.sensorId = sensorId;
    }
    
    public WindSensor(Integer sensorId, Integer windInput, String datumTijd, String windManagement){
        
        this.windInput = windInput;
        this.datumTijd = datumTijd;
        this.sensorId = sensorId;
        this.windManagement = windManagement;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getWindInput() {
        return windInput;
    }

    public void setWindInput(Integer windInput) {
        this.windInput = windInput;
    }

    public String getWindManagement() {
        return windManagement;
    }

    public void setWindManagement(String windManagement) {
        this.windManagement = windManagement;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }
    
}
