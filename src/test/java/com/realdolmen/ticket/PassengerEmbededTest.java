package com.realdolmen.ticket;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PassengerEmbededTest extends PersistenceTest
{
    @Test
    public void passengerPersistenceTest() throws Exception {
        PassengerID passengerID = new PassengerID("ssn", "lammens");
        PassengerEmbeded arne = new PassengerEmbeded(passengerID, "arne", 125, null);
        entityManager().persist(arne);
        assertNotNull(arne.getPas());
    }

}
