package com.realdolmen.ticket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Ticket
{
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal price;
    private Date DateOfDeparture;
    private String Destination;

    protected Ticket() {
    }

    public Ticket(BigDecimal price, Date dateOfDeparture, String destination) {
        this.price = price;
        DateOfDeparture = dateOfDeparture;
        Destination = destination;
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

    public Long getId() {
        return id;
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
}
