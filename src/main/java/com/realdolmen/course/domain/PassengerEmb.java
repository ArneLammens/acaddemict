package com.realdolmen.course.domain;

import javax.persistence.*;

/**
 * Created by BPTAT47 on 9/09/2014.
 */
@Entity
public class PassengerEmb {


    @EmbeddedId
    private PassengerId id;
    private Integer frequentFlyerMiles;
    private byte[] picture;

    public PassengerEmb() {
    }

    public PassengerEmb(PassengerId id, Integer frequentFlyerMiles, byte[] picture) {
        this.id = id;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.picture = picture;
    }

    public PassengerId getId() {

        return id;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }
}


