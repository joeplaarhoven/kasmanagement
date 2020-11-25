package com.bp6.kasmanagement.model;

/**
 *
 * @author Colin
 */
public class Gebruiker {

    private String username ;

    public Gebruiker(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
