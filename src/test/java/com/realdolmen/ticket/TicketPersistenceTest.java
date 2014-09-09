package com.realdolmen.ticket;


import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

public class TicketPersistenceTest extends PersistenceTest
{
    private Ticket ticket =new Ticket() ;
    @Test
    public void testcreate() throws Exception
    {
         ticket= new Ticket(new BigDecimal(12),new Date(),"London");
        entityManager().persist(ticket);
        assertNotNull(ticket.getId());


    }

    @Test
    public void testRetrieve() throws Exception {
        Ticket ticket = entityManager().find(Ticket.class,ticket);
        assertNotNull(ticket);

    }

    @Test
    public void testUpdate() throws Exception {
        Ticket ticket = entityManager().find(Ticket.class,1l);
        ticket.setDestination("parijs");
        Ticket ticket2 = entityManager().find(Ticket.class,1l);
        assertEquals("parijs", ticket2.getDestination());
    }

    @Test
    public void testUpdateMerge() throws Exception {
        et().begin();
        Ticket ticket = entityManager().find(Ticket.class,1l);
        et().commit();
        entityManager().clear();
        ticket.setDestination("Mexico");

        et().begin();
        entityManager().merge(ticket);
        et().commit();

        ticket =entityManager().find(Ticket.class,1l);
        assertEquals("Mexico",ticket.getDestination());
    }

    @Test
    public void testdelete() throws Exception {
        Ticket tick =entityManager().getReference(Ticket.class,1l);

        entityManager().remove(tick);
        entityManager().flush();
        assertNull(entityManager().find(Ticket.class,1L));

    }

}
