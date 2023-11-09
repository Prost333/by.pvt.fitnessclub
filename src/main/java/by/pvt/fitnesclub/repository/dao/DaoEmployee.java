package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Employee;
import by.pvt.fitnesclub.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

public interface DaoEmployee extends JpaRepository<Employee,Long> {

//    List<Employee> getByMaxSalary();
//    List<Employee> getByMinSalary ();
//    List<Employee> findAll();
//    Long spendSalary(LocalDate start, LocalDate end);
}
