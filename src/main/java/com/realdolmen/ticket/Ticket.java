package com.realdolmen.ticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ticket implements Serializable
{
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal price;
    private Date DateOfDeparture;
    private String Destination;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    protected Ticket() {
    }

    public Ticket(BigDecimal price, Date dateOfDeparture, String destination, Passenger passenger, Flight flight) {
        this.price = price;
        DateOfDeparture = dateOfDeparture;
        Destination = destination;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDateOfDeparture() {
        return DateOfDeparture;
    }

    public String getDestination() {
        return Destination;
    }

    public Passenger getPassenger() {
        return passenger;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        DateOfDeparture = dateOfDeparture;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
