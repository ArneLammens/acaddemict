package com.realdolmen.course;

import com.realdolmen.course.domain.Book;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by BPTAT47 on 8/09/2014.
 */
public class BookPersistenceTest extends PersistenceTest {

    @Test
    public void bookCanBePersisted() throws Exception {
        Book book = new Book("Animal Farm", "George Orwell");
        entityManager().persist(book);
        Assert.assertNotNull(book.getId());

    }
}
