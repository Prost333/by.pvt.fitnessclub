package by.pvt.fitnesclub.conector;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HibernateConfiguration {
    public  static EntityManager getEntityManager(){
        EntityManager entityManager= Persistence.createEntityManagerFactory("UserJpa").createEntityManager();
        return  entityManager;
    }
}
