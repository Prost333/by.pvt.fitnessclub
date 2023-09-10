package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class OfficeRepositoryHibernate implements DaoOffice{
    private final SessionFactory sessionFactory;

    public OfficeRepositoryHibernate() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }
    public void changPrice(Long id, BigDecimal bigDecimal){
        Session session= sessionFactory.openSession();
        Office office1=findOfficeById(id);
        session.getTransaction().begin();
        office1.setCost(bigDecimal);
        session.update(office1);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void changeMAXUser(Long id, Long maxUser) {
        Session session= sessionFactory.openSession();
        Office office1=findOfficeById(id);
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
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(office);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Office> getAll() {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("Select s from office s");
        return (List<Office>)query.getResultList();
    }
}
