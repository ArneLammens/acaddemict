package com.realdolmen.ticket;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by almau78 on 8/09/2014.
 */
public class BookPersistenceTest extends PersistenceTest
{
    @Test
    public void bookCanBePersisted() throws Exception {
        Book book = new Book("Animal farm", "George orwell");
        entityManager().persist(book);
        assertNotNull(book.getId());
    }
}
