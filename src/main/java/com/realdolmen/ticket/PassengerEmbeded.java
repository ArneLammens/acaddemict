package com.realdolmen.ticket;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PassengerEmbeded
{
    @EmbeddedId
    private PassengerID pas;
    private String firstName;
    private int frequentFlyerMiles;
    private byte[] picture;

    public PassengerEmbeded(PassengerID pas, String firstName, int frequentFlyerMiles, byte[] picture) {
        this.pas = pas;
        this.firstName = firstName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.picture = picture;
    }

    public PassengerEmbeded() {
    }

    public PassengerID getPas() {
        return pas;
    }

    public void setPas(PassengerID pas) {
        this.pas = pas;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
