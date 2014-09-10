package com.realdolmen.ticket;


import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

public class TicketPersistenceTest extends PersistenceTest
{
    private Ticket ticket ;
    private Long id;

    @Test
    public void testcreate() throws Exception
    {
        ticket= new Ticket(new BigDecimal(12),new Date(),"London");
        entityManager().persist(ticket);
        assertNotNull(ticket.getId());
        id=ticket.getId();

    }

    @Test
    public void testRetrieve() throws Exception {
        System.out.println(id);
        ticket = entityManager().find(Ticket.class,3l);
        assertNotNull(ticket);

    }

    @Test
    public void testUpdate() throws Exception {
        ticket = entityManager().find(Ticket.class,3l);
        ticket.setDestination("parijs");
        Ticket ticket2 = entityManager().find(Ticket.class,3l);
        assertEquals("parijs", ticket2.getDestination());
    }

    @Test
    public void testUpdateMerge() throws Exception {

        ticket = entityManager().find(Ticket.class,3l);
        entityManager().clear();
        ticket.setDestination("Mexico");
        entityManager().merge(ticket);


        ticket =entityManager().find(Ticket.class,3l);
        assertEquals("Mexico",ticket.getDestination());
    }

   /* @Test
    public void testdelete() throws Exception {
        ticket =entityManager().getReference(Ticket.class,2l);

        entityManager().remove(ticket);
        entityManager().flush();
        assertNull(entityManager().find(Ticket.class,2l));

    }*/

}
