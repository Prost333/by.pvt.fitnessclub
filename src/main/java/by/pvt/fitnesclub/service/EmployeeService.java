package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.Employee;
import by.pvt.fitnesclub.repository.dao.DaoEmployee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeService {
    private  final DaoEmployee dao;

    public EmployeeService(DaoEmployee dao) {
        this.dao = dao;
    }

    public void add(Employee employee){
        dao.add(employee);
    }
    public Employee findEmployeeById(Long id){
        return dao.findEmployeeById(id);
    }
    public void deleteEmployee(Long id){
        dao.deleteEmployee(id);
    }
    public List<Employee> getAllEmployee(){
        return  dao.getAllEmployee();
    }
    public List<Employee> getByMaxSalary (){
        return dao.getByMaxSalary();
    }
    public List<Employee> getByMinSalary (){
        return  dao.getByMinSalary();
    }
    public List<Employee> findAll(){
       return dao.findAll();
    }

    public Long spendSalary(LocalDate start, LocalDate end){
        return dao.spendSalary(start,end);
    }
}
