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
    private String locatie;
    private String type;
    private String windInput;
    private String datumTijd;
    
     public WindSensor(String locatie,String type, String windInput, String datumTijd){
        
        this.locatie = locatie;
        this.type = type;
        this.windInput = windInput;
        this.datumTijd = datumTijd;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWindInput() {
        return windInput;
    }

    public void setWindInput(String windInput) {
        this.windInput = windInput;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }
     
}

