package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.VisitUser;
import by.pvt.fitnesclub.repository.dao.VisitDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VisitUserRepHibernate implements VisitDao {
    private final SessionFactory sessionFactory;

    public VisitUserRepHibernate() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }
    @Override
    public void addVisit(VisitUser visitUser) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(visitUser);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        VisitUser visitUser = session.get(VisitUser.class, id);
        session.getTransaction().begin();
        session.remove(visitUser);
        session.getTransaction().commit();
    }

    @Override
    public VisitUser findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(VisitUser.class, id);
    }

    @Override
    public List<VisitUser> getAllVisit() {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("Select s from Visit_User s");
        return (List<VisitUser>)query.getResultList();
    }

    public List<VisitUser> findByData(LocalDate start, LocalDate end) {
        Session session=sessionFactory.openSession();
        Query query=session.createQuery("Select s from VisitUser s where  s.dateOfVisit>=:start " +
                "and s.dateOfVisit<=:end");
        query.setParameter("start", start);
        query.setParameter("end", end);
        List <VisitUser> visitUserList= (List <VisitUser>)query.getResultList();
        session.close();
        return  visitUserList;

    }

    public BigDecimal sumByDay(List<VisitUser> visitUserList){
        BigDecimal sum= BigDecimal.valueOf(0);
        for (VisitUser v:visitUserList) {
            sum=v.getMoneySpent();
        }
        return sum;
    }

}
