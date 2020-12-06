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
public class LuchtVochtigheidSensor {
 
    private String locatie;
    private String type;
    private String luchtVochtigheidInput;
    private String datumTijd;
    
    public LuchtVochtigheidSensor(String locatie,String type, String luchtVochtigheidInput, String datumTijd){
        this.locatie = locatie;
        this.type = type;
        this.luchtVochtigheidInput = luchtVochtigheidInput;
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

    public String getLuchtVochtigheidInput() {
        return luchtVochtigheidInput;
    }

    public void setLuchtVochtigheidInput(String luchtVochtigheidInput) {
        this.luchtVochtigheidInput = luchtVochtigheidInput;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }
    
    
}
