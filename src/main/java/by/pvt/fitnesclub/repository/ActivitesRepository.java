package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.*;
import by.pvt.fitnesclub.repository.dao.ActivitesDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ActivitesRepository implements ActivitesDao {
    private final SessionFactory sessionFactory;

    public ActivitesRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void add(Activites activites) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(activites);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Activites findActivitesById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Activites.class, id);
    }

    @Override
    public void deleteActivites(Long id) {
        Session session = sessionFactory.openSession();
        Activites activites = session.get(Activites.class, id);
        session.getTransaction().begin();
        session.remove(activites);
        session.getTransaction().commit();
    }

    @Override
    public List<Activites> getAllActivites() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from Activites s");
//        query.setFirstResult(1);   убирает первый объект
        session.close();
        return (List<Activites>) query.getResultList();
    }

    public List<Activites> getAllActivitesByIds(List<Long> id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select a from Activites a where a.id in (:id)");
        query.setParameter("id", id);
        List<Activites> activites = (List<Activites>) query.getResultList();
        session.close();
        return activites;
    }

    public Long lowPriceActivites() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.min(criteriaQuery.from(Activites.class).get("cost")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public Activites getActivitesandOffice(Long id){
        Session session= sessionFactory.openSession();
        Query query=session.createQuery("Select s from Activites s");
        List<Activites> activitesList = (List<Activites>) query.getResultList();
        session.close();
        Session session1=sessionFactory.openSession();
        Query query1= session1.createQuery("Select s from Office s");
        List<Office> officeList=(List<Office>) query1.getResultList();
        Activites activites=session1.get(Activites.class,id);
        session1.close();
        return activites;
    }




}
