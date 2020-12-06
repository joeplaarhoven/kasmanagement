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
public class LichtSensor {
    
    private String locatie;
    private String type;
    private String lichtInput;
    private String datumTijd;
    
    public LichtSensor(String locatie,String type, String lichtInput, String datumTijd){
        
        this.locatie = locatie;
        this.type = type;
        this.lichtInput = lichtInput;
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

    public String getLichtInput() {
        return lichtInput;
    }

    public void setLichtInput(String lichtInput) {
        this.lichtInput = lichtInput;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }
    
    
}
