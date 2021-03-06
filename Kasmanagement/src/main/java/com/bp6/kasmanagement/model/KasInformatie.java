/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.model;

/**
 *
 * @author laarh
 */
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class KasInformatie {
    private Integer kasId;
    private String kasNaam;
    private String product;
    private String datumTijd;
    private String groei;


    

    public String getGroei() {
        return groei;
    }

    public void setGroei(String groei) {
        this.groei = groei;
    }

    public Integer getKasId() {
        return kasId;
    }

    public void setKasId(Integer kasId) {
        this.kasId = kasId;
    }

    public String getKasNaam() {
        return kasNaam;
    }

    public void setKasNaam(String kasNaam) {
        this.kasNaam = kasNaam;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDatumTijd() {
        return datumTijd;
    }

    public void setDatumTijd(String datumTijd) {
        this.datumTijd = datumTijd;
    }

    public KasInformatie(Integer kasId, String kasNaam, String datumTijd) {
        this.kasId = kasId;
        this.kasNaam = kasNaam;
        this.datumTijd = datumTijd;
    }

    public KasInformatie(Integer kasId, String kasNaam, String product, String datumTijd) {
        this.kasId = kasId;
        this.kasNaam = kasNaam;
        this.product = product;
        this.datumTijd = datumTijd;
    }
    
    public KasInformatie(Integer kasId, String kasNaam, String product, String datumTijd, String groei) {
        this.kasId = kasId;
        this.kasNaam = kasNaam;
        this.product = product;
        this.datumTijd = datumTijd;
        this.groei = groei;
    }

    @Override
    public String toString() {
        return kasNaam;
    }
       
}
