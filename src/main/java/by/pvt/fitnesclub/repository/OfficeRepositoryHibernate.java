package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.entity.Employee;
import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.OfficeWithSubSelect;
import by.pvt.fitnesclub.repository.dao.DaoOffice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class OfficeRepositoryHibernate implements DaoOffice {
    private final SessionFactory sessionFactory;

    public OfficeRepositoryHibernate() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    public void changPrice(Long id, BigDecimal bigDecimal) {
        Session session = sessionFactory.openSession();
        Office office1 = findOfficeById(id);
        session.getTransaction().begin();
        office1.setCost(bigDecimal);
        session.update(office1);
        session.getTransaction().commit();
        session.close();

    }

    public Office getOfficeandActivitec(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from Office s");
        List<Office> officeList = (List<Office>) query.getResultList();

        session.close();

        Session session1 = sessionFactory.openSession();
        Office office = session1.get(Office.class, id);
        Query query1 = session1.createQuery("Select s from Activites s");
        List<Activites> activitesList = (List<Activites>) query1.getResultList();
        session1.close();
        return office;
    }

    @Override
    public void changeMAXUser(Long id, Long maxUser) {
        Session session = sessionFactory.openSession();
        Office office1 = findOfficeById(id);
        session.getTransaction().begin();
        office1.setMaxUser(maxUser);
        session.update(office1);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Office office) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    public void add1(Office office, Long iventarNumer) {
        Session session = sessionFactory.openSession();
        session.detach(office);
        office.setId(null);
        session.getTransaction().begin();
        office.setInventarNumer(iventarNumer);
        session.persist(office);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Office findOfficeById(Long id) {
        Session session = sessionFactory.openSession();
        Office office = session.get(Office.class, id);
        return office;
    }

    @Override
    public void deleteOffice(Office office) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(office);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Office> getAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from office s");
        return (List<Office>) query.getResultList();
    }


    public List<OfficeWithSubSelect> getSmallOffice() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from OfficeWithSubSelect s");
        return (List<OfficeWithSubSelect>) query.getResultList();
    }

    public Long getCountGuest() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        criteriaQuery.select(criteriaBuilder.sum(criteriaQuery.from(Office.class).get("maxUser")));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<Office> findAllByUserAndPrice(Long minUser, Long maxUser) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = criteriaBuilder.createQuery(Office.class);
        Root<Office> offices = criteriaQuery.from(Office.class);

        criteriaQuery.select(offices).where(criteriaBuilder.between(offices.get("maxUser"), minUser, maxUser)).
                orderBy(criteriaBuilder.asc(offices.get("cost")));
        List<Office> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }


}
