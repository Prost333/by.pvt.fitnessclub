package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.conector.HibernateConfiguration;
import by.pvt.fitnesclub.entity.Employee;
import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.repository.dao.DaoEmployee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeRepositoryHib implements DaoEmployee {
    EntityManager entityManager= HibernateConfiguration.getEntityManager();

    @Override
    public void add(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Employee user=entityManager.find(Employee.class,id);
        return user;
    }

    @Override
    public void deleteEmployee(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findEmployeeById(id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employee> getAllEmployee() {
        EntityManager entityManager= HibernateConfiguration.getEntityManager();
        List<Employee>userList=entityManager.createQuery("select s from Employee s").getResultList();
        entityManager.close();
        return userList;
    }
}
