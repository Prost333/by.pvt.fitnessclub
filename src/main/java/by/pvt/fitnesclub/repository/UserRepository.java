package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfiguration;
import by.pvt.fitnesclub.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserRepository implements  Dao{
    EntityManager entityManager= HibernateConfiguration.getEntityManager();
    public void add(User user){

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public  List<User> getAllUser(){
        EntityManager entityManager= HibernateConfiguration.getEntityManager();
        List<User>userList=entityManager.createQuery("select s from User s").getResultList();
        entityManager.close();
        return userList;
    }



    public User findUserById(Long id){
        User user=entityManager.find(User.class,id);
        return user;
    }
    public void deleteUser(Long id){
        entityManager.getTransaction().begin();
        entityManager.remove(findUserById(id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
