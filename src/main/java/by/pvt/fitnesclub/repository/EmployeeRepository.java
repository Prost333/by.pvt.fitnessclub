package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfig;
import by.pvt.fitnesclub.entity.Employee;
import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.VisitUser;
import by.pvt.fitnesclub.repository.dao.DaoEmployee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Repository
public class EmployeeRepository implements DaoEmployee {
    private final SessionFactory sessionFactory;

    public EmployeeRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void add(Employee employee) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Session session = sessionFactory.openSession();
        Employee user = session.get(Employee.class, id);
        session.getTransaction().begin();
        session.remove(user);
        session.getTransaction().commit();
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from Employee s");
        return (List<Employee>) query.getResultList();
    }

    public List<Employee> getByMaxSalary() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from Employee s where s.salary=(select max(s1.salary) from Employee s1) ");
        List<Employee> employeeList = (List<Employee>) query.getResultList();
        session.close();
        return employeeList;

    }

    public List<Employee> getByMinSalary() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from Employee s where s.salary=(select min(s1.salary) from Employee s1) ");
        List<Employee> employeeList = (List<Employee>) query.getResultList();
        session.close();
        return employeeList;
    }

    public List<Employee> findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("find_by_nam");
        query.setParameter("name", name);
        List<Employee> employees = (List<Employee>) query.getResultList();
        session.close();
        return employees;
    }

    public List<Employee> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    public List<Employee> findAllByIds(List<Long> ids) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root).where(root.get("id").in(ids));
        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    public List<Employee> findNameHQL(String name) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    public List<Employee> findAllBySalary(Long minSalary, Long maxSalary) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employee).where(criteriaBuilder.between(employee.get("salary"), minSalary, maxSalary)).
                orderBy(criteriaBuilder.asc(employee.get("salary")));
        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    public List<Employee> findAllWhereSalaryGreaterThenName(Long salary, String name) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employee).where(criteriaBuilder.and(criteriaBuilder.gt(employee.get("salary"), salary),
                criteriaBuilder.notEqual(employee.get("name"), name))).orderBy(criteriaBuilder.asc(employee.get("salary")));
        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

    public List<Employee> findAllWithPagination(int size, int page) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employee = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employee).orderBy(criteriaBuilder.asc(employee.get("id")));

        TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setMaxResults(size);
//        номер элл с ктр мы выводим рзлт
        typedQuery.setFirstResult(page);

        List<Employee> employeeList = typedQuery.getResultList();
        return employeeList;
    }

    public List<Long> count() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);

        List<Long> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
        return employeeList;
    }

//    public List<Employee> findbyOffice(String name) {
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
//        Root<Employee> employee = criteriaQuery.from(Employee.class);
//        Join<Employee, Office> office = employee.join("office");
//        criteriaQuery.where(criteriaBuilder.equal(office.get("name"), name));
//
//        List<Employee> employeeList = entityManager.createQuery(criteriaQuery).getResultList();
//        return employeeList;
//    }
//
//
//    public List<Employee> detachCriteria(String name) {
//        DetachedCriteria employees = DetachedCriteria.forClass(Employee.class);
//        employees.add(Restrictions.eq("name", name));
//        EntityManager entityManager = sessionFactory.createEntityManager();
//        Session session = entityManager.unwrap(Session.class);
//        Criteria criteria = employees.getExecutableCriteria(session);
//        return (List<Employee>) criteria.list();
//    }


    public Long employeeForHiring(LocalDate start, LocalDate end) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select sum(s.salary) from Employee s where  s.hiring<=:start " +
                "and s.quite<=:end or s.quite is null");
        query.setParameter("start", start);
        query.setParameter("end", end);
        Long employeeList = (Long) query.getSingleResult();
//        Long sum=0L;
//        for (Long i: employeeList){
//            sum+=i;
//        }
        session.close();
        return employeeList;
    }

    public Long spendSalary(LocalDate start, LocalDate end){
      Long days=(end.toEpochDay()-start.toEpochDay());

      return (employeeForHiring(start,end)/30)*days;
    }


}
