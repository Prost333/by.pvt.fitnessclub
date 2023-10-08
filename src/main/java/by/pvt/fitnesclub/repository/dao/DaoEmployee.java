package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Employee;


import java.time.LocalDate;
import java.util.List;

public interface DaoEmployee {
    void add(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);

    List<Employee> getAllEmployee();

    List<Employee> getByMaxSalary();
    List<Employee> getByMinSalary ();
    List<Employee> findAll();
    Long spendSalary(LocalDate start, LocalDate end);
}
