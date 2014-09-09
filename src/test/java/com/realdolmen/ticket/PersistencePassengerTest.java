package com.realdolmen.ticket;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ALMAU78 on 9/09/2014.
 */
public class PersistencePassengerTest extends PersistenceTest
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
        System.out.println();

    }
}
