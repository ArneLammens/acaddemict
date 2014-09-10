package com.realdolmen.ticket;


import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionManager;

public class PersistenceTest
{
    private static final Logger logger = LoggerFactory.getLogger(PersistenceTest.class);

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
        logger.info("createing entitymanager en entitymanagerfactory");
        em=emf.createEntityManager();
        et=em.getTransaction();
        et.begin();

    }

    /*gebeurd elke keer voor elke test*/
    @After
    public void destroy()
    {
        logger.info("commiting with entityTransaction en close entitymanager");
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
        logger.info("destroying entitymanager factory");
        if(emf != null)
        {
            emf.close();
        }
    }

    protected EntityManager entityManager()
    {
        return this.em;
    }
    protected EntityTransaction et(){return this.et;}

}
