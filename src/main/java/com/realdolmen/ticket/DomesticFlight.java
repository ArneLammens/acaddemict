package com.realdolmen.ticket;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class DomesticFlight extends Flight
{
    private String airlinaCompany;
    @ElementCollection
    @Column(name="flight_reference")
    private List<String> references;

    public DomesticFlight() {
    }

    public DomesticFlight(String airlinaCompany, List<String> references) {
        this.airlinaCompany = airlinaCompany;
        this.references = references;
    }

    public String getAirlinaCompany() {
        return airlinaCompany;
    }

    public void setAirlinaCompany(String airlinaCompany) {
        this.airlinaCompany = airlinaCompany;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }
}
