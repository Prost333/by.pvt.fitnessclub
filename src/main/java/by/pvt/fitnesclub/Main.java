package by.pvt.fitnesclub;

import by.pvt.fitnesclub.entity.*;
import by.pvt.fitnesclub.repository.EmployeeRepositoryHib;
import by.pvt.fitnesclub.repository.OfficeRepositoryHibernate;
import by.pvt.fitnesclub.repository.UserRepositoryHibernate;
import by.pvt.fitnesclub.repository.VisitorRepositoryHib;
import by.pvt.fitnesclub.service.EmployeeService;
import by.pvt.fitnesclub.service.OfficeService;
import by.pvt.fitnesclub.service.UserService;
import by.pvt.fitnesclub.service.VisitorService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        BigDecimal bigDecimal = BigDecimal.valueOf(1000);
        UserService userService=new UserService(new UserRepositoryHibernate());
        OfficeService officeService =new OfficeService(new OfficeRepositoryHibernate());
        VisitorService visitorService = new VisitorService(new VisitorRepositoryHib());
        EmployeeService employeeService=new EmployeeService(new EmployeeRepositoryHib());
        Address address=new  Address("jopin", "tu", "12","1241");
        Visitor visitor=new Visitor();
        String date="2023-09-18";
//
        visitor.setDate(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        visitor.setMoney(new BigDecimal(15));
        visitor.setStatus(Status.ACTIVITY);
        visitor.setPhoneNumber("15245");
        visitor.setAge(19L);
        visitor.setName("Yra");
        visitor.setSurname("Kot");
        visitor.setAddress(address);
        visitorService.add(visitor);
        Employee employee = new Employee();
        employee.setCompany("gum");
        employee.setHiring(LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        employee.setQuite(null);
        employee.setAddress(address);
        employee.setSalary(950L);
        employee.setAge(19L);
        employee.setName("Yra");
        employee.setSurname("Kot");
        employeeService.add(employee);
//        VisitUserService visitUserService=new VisitUserService(new VisitUserRepHibernate());
//        VisitUser visitUser=new VisitUser();
//        visitUser.setActivityId(1L);
//        visitUser.setMoneySpent(new BigDecimal(12));
//        visitUser.setClientId(1L);
//        visitUser.setDateOfVisit(LocalDate.of(2023,2,14));
//        visitUserService.addVisit(visitUser);
//        User user1=new User();
//        user1.setName("lox");
//        user1.setSurname("lox");
//        Employee employee=new Employee();
//        employee.setCompany("bmw");
//        Address address=new  Address("jopin", "tu", "12","1241");
//        User user = new User("Andrei","Andrei",47L,"3123",localDate,BigDecimal.valueOf(1200),Status.VIP,new Address());
//        userService.add(user);
//        System.out.println(userService.getAllUser());
//        Office office =new Office("basketball zone",125L,"AKTIV",20L,new BigDecimal(45));
//        officeService.add(office);
//        System.out.println(officeService.getSmallOffice());
//        Office office=officeService.findUserById(1L);
//        officeService.changPrice(1L,new BigDecimal(75));
//        officeService.changeMAXUser(1L,100L);
//        System.out.println(officeService.priceForUser(2L));


    }
}