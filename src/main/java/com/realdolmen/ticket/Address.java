package com.realdolmen.ticket;

import javax.persistence.Embeddable;

@Embeddable
public class Address
{
    private String streetname;
    private String zipcode;
    private String municipility;
    private String homenumber;

    public Address(String streetname, String zipcode, String municipility, String homenumber) {
        this.streetname = streetname;
        this.zipcode = zipcode;
        this.municipility = municipility;
        this.homenumber = homenumber;
    }

    public Address() {
    }

    public String getStreetname() {
        return streetname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getMunicipility() {
        return municipility;
    }

    public String getHomenumber() {
        return homenumber;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setMunicipility(String municipility) {
        this.municipility = municipility;
    }

    public void setHomenumber(String homenumber) {
        this.homenumber = homenumber;
    }
}
