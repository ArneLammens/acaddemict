package com.realdolmen.course;

import com.realdolmen.course.domain.Passenger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by BPTAT47 on 8/09/2014.
 */
public class PassengerPersistenceTest extends PersistenceTest {

    @Before
    public void initialize() {

    }
    @Test
    public void passengerIsPersisted() throws Exception {
        Passenger passenger = new Passenger("test","Benjamin","Pieteraerents",200,new Date(),25, Passenger.PassengerType.OCCASIONAL,new Date());
        entityManager().persist(passenger);
        Assert.assertNotNull(passenger);
    }

    @Test
    public void testAgeCalculation() throws Exception {
        Passenger passenger = new Passenger("test","Benjamin","Pieteraerents",200,new Date(),25, Passenger.PassengerType.OCCASIONAL,new Date());
        org.junit.Assert.assertTrue("Error - age not right",passenger.getAge() == 0);
    }
}
