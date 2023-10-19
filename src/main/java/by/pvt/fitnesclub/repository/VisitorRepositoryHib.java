package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfiguration;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.repository.dao.DaoVisitor;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;

import java.util.List;
@Repository
public class VisitorRepositoryHib implements DaoVisitor {
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    public void add(Visitor visitor){

        entityManager.getTransaction().begin();
        entityManager.persist(visitor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public List<Visitor> getAllVisitor(){
        EntityManager entityManager= HibernateConfiguration.getEntityManager();
        List<Visitor>userList=entityManager.createQuery("select s from Visitor s").getResultList();
        entityManager.close();
        return userList;
    }



    public Visitor findVisitorById(Long id){
       Visitor user=entityManager.find(Visitor.class,id);
        return user;
    }

    @Override
    public void deleteVisitor(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findVisitorById(id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
