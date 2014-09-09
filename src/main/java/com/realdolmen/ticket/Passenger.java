package com.realdolmen.ticket;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by almau78 on 8/09/2014.
 */
@Entity
public class Passenger
{
    public static enum PassengerType
    {
        regular,occasional
    }
    @Id
    @GeneratedValue
    private Long id;
    @Column(updatable = false,nullable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastname;
    private int frequentFlyerMiles;
    private byte[] picture;
    @Column(nullable = false,updatable=false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Transient
    private Integer age;
    @Enumerated(EnumType.ORDINAL)
    private PassengerType passengerType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlights;

    protected Passenger() {

    }

    public Passenger(String ssn, String firstName, String lastname, int frequentFlyerMiles, byte[] picture, Date dateOfBirth, Integer age, PassengerType passengerType, Date lastFlights) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastname = lastname;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.picture = picture;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.passengerType = passengerType;
        this.lastFlights = lastFlights;
    }

    public Long getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getAge()
    {
        SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");

        return Integer.parseInt(simpleDateformat.format(new Date()))- Integer.parseInt(simpleDateformat.format(this.dateOfBirth));


    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public Date getLastFlights() {
        return lastFlights;
    }
}
