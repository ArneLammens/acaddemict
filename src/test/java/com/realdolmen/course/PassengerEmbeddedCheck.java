package com.realdolmen.course;

import com.realdolmen.course.domain.PassengerEmb;
import com.realdolmen.course.domain.PassengerId;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by BPTAT47 on 9/09/2014.
 */
public class PassengerEmbeddedCheck extends PersistenceTest {

    @Test
    public void testPassengerIsProperlyAdded() throws Exception {
        PassengerId passengerId = new PassengerId("Benjamin","Pieteraerents");
        PassengerEmb passengerEmb = new PassengerEmb(passengerId,15,null);
        entityManager().persist(passengerEmb);
        Assert.assertNotNull(passengerEmb.getId());


    }
}
