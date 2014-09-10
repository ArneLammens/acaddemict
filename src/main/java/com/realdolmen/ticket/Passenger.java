package com.realdolmen.ticket;

import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.persistence.metamodel.CollectionAttribute;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    private static Logger logger= LoggerFactory.getLogger(Passenger.class);
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
    @Embedded
    private Address adress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets =new ArrayList<>();

/*    @ManyToMany
    @JoinTable(
                name="ticket_passenger",
                joinColumns = @JoinColumn(name=" passenger_id"),
                inverseJoinColumns = @JoinColumn(name="ticket_id")
    )*/



    @PrePersist
    @PreUpdate
    private void updateDate()
    {
        logger.info("gegenereed datum for "+this.getFirstName());
        this.dateLastUpdated=new Date();
    }
    protected Passenger() {

    }

    public Passenger(String ssn, String firstName, String lastname, int frequentFlyerMiles, byte[] picture, Date dateOfBirth,  PassengerType passengerType, Date lastFlights) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastname = lastname;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.picture = picture;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }


}
