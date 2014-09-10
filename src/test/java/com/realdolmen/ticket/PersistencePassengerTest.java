package com.realdolmen.ticket;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


public class PersistencePassengerTest extends DatasetPersistenceTest
{

    @Test
    public void passengerPersist() throws Exception
    {
        Passenger pas= new Passenger("ssn","arne","lammens",125,null,new Date(),25,Passenger.PassengerType.occasional,new Date());
        entityManager().persist(pas);
        assertNotNull(pas.getId());

    }

    @Test
    public void ageCalculation()throws Exception
    {
        Passenger pas =entityManager().find(Passenger.class, 1l);
        System.out.println(pas.getAge());


    }

    @Test
    public void PersisteBeforPersite() throws Exception
    {
        Passenger pas= new Passenger("ssn","arne","lammens",125,null,new Date(),25,Passenger.PassengerType.occasional,new Date());
       assertNull(pas.getDateLastUpdated());
        entityManager().persist(pas);
        assertNotNull(pas.getDateLastUpdated());

    }
    @Test
    public void beforeUpdate() throws Exception
    {
        Passenger pas= new Passenger("ssn","arne","lammens",125,null,new Date(),25,Passenger.PassengerType.occasional,new Date());
        entityManager().persist(pas);
        assertNotNull(pas.getDateLastUpdated());

    }

}
