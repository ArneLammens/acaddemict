package com.realdolmen.course.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by BPTAT47 on 9/09/2014.
 */
@Embeddable
public class PassengerId implements Serializable {
    private String ssn;
    private String lastName;

    public PassengerId() {
    }

    public PassengerId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
