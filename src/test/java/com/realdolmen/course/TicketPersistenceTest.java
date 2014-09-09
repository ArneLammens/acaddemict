package com.realdolmen.course;

import com.realdolmen.course.domain.Ticket;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BPTAT47 on 9/09/2014.
 */
public class TicketPersistenceTest extends PersistenceTest {

    @Test
    public void testPersistATicket() throws Exception {
        Ticket ticket = new Ticket(new BigDecimal(12),new Date(),"Lima - Peru");
        entityManager().persist(ticket);
        Assert.assertNotNull(ticket.getId());
    }


    @Test
    public void testUpdateATicket() throws Exception {
        Ticket ticket = entityManager().find(Ticket.class,1L);
        Date updateDate = new Date(1234567891);
        ticket.setDateOfDeparture(updateDate);
        entityManager().flush();
         Ticket updatedTicket =  entityManager().find(Ticket.class,1L);
        Assert.assertNotEquals(ticket.getDateOfDeparture(), updatedTicket.getDateOfDeparture());
    }

    @Test
    public void testDeleteATicket() throws Exception {

        Ticket ticket = entityManager().find(Ticket.class,1L);
        entityManager().remove(ticket);
        Assert.assertNull(entityManager().find(Ticket.class, 1L));
    }



}
