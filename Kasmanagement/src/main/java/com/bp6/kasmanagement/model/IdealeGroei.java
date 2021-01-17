package com.bp6.kasmanagement.model;

/**
 *
 * @author Colin
 */
public class IdealeGroei {
    private String product;
    private int tempIdeaal, vochtIdeaal, windMax, lichtIdeaal, bodemVochtIdeaal, groeiTijd;

    public IdealeGroei(String product, int tempIdeaal, int vochtIdeaal, int windMax, int lichtIdeaal, int bodemVochtIdeaal, int groeiTijd) {
        this.product = product;
        this.tempIdeaal = tempIdeaal;
        this.vochtIdeaal = vochtIdeaal;
        this.windMax = windMax;
        this.lichtIdeaal = lichtIdeaal;
        this.bodemVochtIdeaal = bodemVochtIdeaal;
        this.groeiTijd = groeiTijd;
    }

    public IdealeGroei(int tempIdeaal, int vochtIdeaal, int lichtIdeaal, int bodemVochtIdeaal) {
        this.tempIdeaal = tempIdeaal;
        this.vochtIdeaal = vochtIdeaal;
        this.lichtIdeaal = lichtIdeaal;
        this.bodemVochtIdeaal = bodemVochtIdeaal;
    }
    
    

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getTempIdeaal() {
        return tempIdeaal;
    }

    public void setTempIdeaal(int tempIdeaal) {
        this.tempIdeaal = tempIdeaal;
    }

    public int getVochtIdeaal() {
        return vochtIdeaal;
    }

    public void setVochtIdeaal(int vochtIdeaal) {
        this.vochtIdeaal = vochtIdeaal;
    }

    public int getWindMax() {
        return windMax;
    }

    public void setWindMax(int windMax) {
        this.windMax = windMax;
    }

    public int getLichtIdeaal() {
        return lichtIdeaal;
    }

    public void setLichtIdeaal(int lichtIdeaal) {
        this.lichtIdeaal = lichtIdeaal;
    }

    public int getBodemVochtIdeaal() {
        return bodemVochtIdeaal;
    }

    public void setBodemVochtIdeaal(int bodemVochtIdeaal) {
        this.bodemVochtIdeaal = bodemVochtIdeaal;
    }

    public int getGroeiTijd() {
        return groeiTijd;
    }

    public void setGroeiTijd(int groeiTijd) {
        this.groeiTijd = groeiTijd;
    }
        
}
