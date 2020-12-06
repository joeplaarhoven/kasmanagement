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
public class BodemVochtigheidSensor {
    
    private String locatie;
    private String type;
    private String bodemVochtInput;
    private String datumTijd;
    
    public BodemVochtigheidSensor(String locatie,String type, String bodemVochtInput, String datumTijd){
        
        this.locatie = locatie;
        this.type = type;
        this.bodemVochtInput = bodemVochtInput;
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

    public String getBodemVochtInput() {
        return bodemVochtInput;
    }

    public void setBodemVochtInput(String bodemVochtInput) {
        this.bodemVochtInput = bodemVochtInput;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }
    
    
}
