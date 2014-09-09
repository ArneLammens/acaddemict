package com.realdolmen.course.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by BPTAT47 on 8/09/2014.
 */
@Entity
public class Passenger {

    public static  enum PassengerType{
        OCCASIONAL,REGULAR
    }
    @Id @GeneratedValue
    private int id;
    @Column(updatable = false,nullable = false)
    private  String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    private Integer frequentFlyerMiles;
    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;


    public Passenger() {
    }

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, Integer age, PassengerType passengerType, Date lastFlight) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.passengerType = passengerType;
        this.lastFlight = lastFlight;
    }

    public int getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge() {
        long ageInMillis = new Date().getTime() - getDateOfBirth().getTime();

        Date age = new Date(ageInMillis);

        return age.getYear();
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Date getLastFlight() {
        return lastFlight;
    }
}
