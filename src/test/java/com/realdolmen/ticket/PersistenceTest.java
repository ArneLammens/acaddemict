package com.realdolmen.ticket;


import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceTest
{
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;


    /*een keer voor alle testen*/
    @BeforeClass
    public static void initializeEntityManagerFactory()
    {
        emf=Persistence.createEntityManagerFactory( "TicketPU");
    }
    /*altijd voor elke test uitvoeren*/
    @Before
    public void initialize()
    {
        em=emf.createEntityManager();
        et=em.getTransaction();
        et.begin();

    }

    /*gebeurd elke keer voor elke test*/
    @After
    public void destroy()
    {
        if(et != null&& !et.getRollbackOnly())
        et.commit();
        if(em != null)
        {
            em.close();
        }
    }
    /*gebeurd na alle testen zijn afgelopen*/
    @AfterClass
    public static void destroyemf()
    {
        if(emf != null)
        {
            emf.close();
        }
    }

    protected EntityManager entityManager()
    {
        return this.em;
    }


}
