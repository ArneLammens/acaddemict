package com.realdolmen.ticket;


import javax.persistence.Entity;

@Entity
public class InternationalFlight extends Flight
{
    private boolean blacklisted;
    private String regulations;

    public InternationalFlight() {
    }

    public InternationalFlight(boolean blacklisted, String regulations) {
        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }

    public boolean isBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
