package com.realdolmen.ticket;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class FlightPersistenceTest extends DatasetPersistenceTest
{
    @Test
    public void testfindFlight() throws Exception
    {
        Flight f=entityManager().find(Flight.class,1l);
        assertNotNull(f);

    }

    @Test
    public void testCreateFlight() throws Exception {
        Flight flight= new Flight("1254jkl98",new Date(),new Date());
        entityManager().persist(flight);
        assertNotNull(flight.getId());

    }

    @Test
    public void internationalFlightCanBePersistend() throws Exception {
        InternationalFlight f=new InternationalFlight(true,"shoot him");
        entityManager().persist(f);
        assertNotNull(f.getId());


    }

    @Test
    public void domesticFlightCanBePersited() throws Exception {
        DomesticFlight f = new DomesticFlight("jetair", Arrays.asList("ref1,ref2"));
        entityManager().persist(f);
        assertNotNull(f.getId());

    }

    @Test
    public void retrieveFlightTest() throws Exception {
        Flight flight = entityManager().find(DomesticFlight.class,2l);
        Flight flight2 =entityManager().find(InternationalFlight.class,1l);
        assertNotNull(flight2);
        assertNotNull(flight);
    }
}
