package com.realdolmen.ticket;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PassengerID implements Serializable {
    private String ssn;
    private  String lastname;

    public PassengerID(String ssn, String lastname) {
        this.ssn = ssn;
        this.lastname = lastname;
    }

    public PassengerID() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerID)) return false;

        PassengerID that = (PassengerID) o;

        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn != null ? ssn.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
