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
public class TempratuurSensor {
    
    private String locatie;
    private String type;
    private String tempratuurInput;
    private String datumTijd;
    
     public TempratuurSensor(String locatie,String type, String tempratuurInput, String datumTijd){
        
        this.locatie = locatie;
        this.type = type;
        this.tempratuurInput = tempratuurInput;
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

    public String getTempratuurInput() {
        return tempratuurInput;
    }

    public void setTempratuurInput(String tempratuurInput) {
        this.tempratuurInput = tempratuurInput;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }
    
   
    
}
