package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.repository.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class UserRepositoryHibernate implements Dao {
    private final SessionFactory sessionFactory;

    public UserRepositoryHibernate() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.openSession();
        User user= session.get(User.class, id);
        session.getTransaction().begin();
        session.remove(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from User s");
        return (List<User>) query.getResultList();
    }

    public List <User> findUserByName (String name){
        Session session= sessionFactory.openSession();
        Query query = session.createQuery("Select u from User u where u.name in (:name)");
        query.setParameter("name", name);
        List <User> users = (List<User>) query.getResultList();
        session.close();
        return  users;
    }
}
