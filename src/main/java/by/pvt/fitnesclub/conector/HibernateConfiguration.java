package by.pvt.fitnesclub.conector;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateConfiguration {
    public  static EntityManager getEntityManager(){
        EntityManager entityManager= Persistence.createEntityManagerFactory("UserJpa").createEntityManager();
        return  entityManager;
    }
}
