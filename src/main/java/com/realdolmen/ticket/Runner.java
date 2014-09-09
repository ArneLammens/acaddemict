package com.realdolmen.ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by almau78 on 8/09/2014.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        try {
             emf = Persistence.createEntityManagerFactory("TicketPU");
             em = emf.createEntityManager();
            EntityTransaction et = em.getTransaction();

            et.begin();
            em.persist(new Book("19", "George orwell"));
            et.commit();

        }finally {
            if(em!=null)
            {
                em.close();
            }
           if(emf !=null)
            emf.close();
        }

    }



}
