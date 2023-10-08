package by.pvt.fitnesclub;

import by.pvt.fitnesclub.entity.*;
import by.pvt.fitnesclub.repository.*;
import by.pvt.fitnesclub.repository.entityMan.EmployeeRepositoryHib;
import by.pvt.fitnesclub.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        BigDecimal bigDecimal = BigDecimal.valueOf(1000);
        UserService userService = new UserService(new UserRepositoryHibernate());
        OfficeService officeService = new OfficeService(new OfficeRepositoryHibernate());
        VisitorService visitorService = new VisitorService(new VisitorRepositoryHib());
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository());
        ActivitesService activitesService = new ActivitesService(new ActivitesRepository());
        VisitUserService visitUserService = new VisitUserService(new VisitUserRepHibernate());
        NoteService noteService = new NoteService(new NoteRepository());
//        OfficeRepositoryHibernate officeRepositoryHibernate=new OfficeRepositoryHibernate();
//        officeRepositoryHibernate.getOfficeandActivitec(1L);
        ActivitesRepository activitesRepository=new ActivitesRepository();
        System.out.println(activitesRepository.getActivitesandOffice(1L));
        Address address = new Address("jopin", "tu", "12", "1241");
//        Visitor visitor = new Visitor();
        String date = "2023-09-18 13:18";
        String date1 = "2023-09-18";

//        Activites activites= new Activites();
//        activites.setCost(5L);
//        activites.setName("gum");
//        activitesService.add(activites);
//        Office office = new Office("relax zone", 123L, "AKTIV", 15L, new BigDecimal(45));
//        officeService.add(office);
//        System.out.println(officeService.findAllByUserAndPrice(10L, 50L));

//        System.out.println(officeService.getCountGuest());
//        System.out.println(activitesService.lowPriceActivites());

//        Visitor visitor = new Visitor();
//        visitor.setDate(LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        visitor.setMoney(new BigDecimal(15));
//        visitor.setStatus(Status.ACTIVITY);
//        visitor.setPhoneNumber("15245");
//        visitor.setAge(65L);
//        visitor.setName("Yra");
//        visitor.setSurname("Kot");
//        visitor.setAddress(address);
//        visitorService.add(visitor);
//
//        LocalDateTime time = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//        Note note = new Note();
//        note.setLocalDateTime(time);
//        note.setOffice(office);
//        note.setVisitor(visitor);
//        noteService.add(note);


//        Employee employee = new Employee();
//        employee.setCompany("fitnes");
//        employee.setHiring(LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        employee.setQuite(null);
//        employee.setAddress(address);
//        employee.setSalary(1151L);
//        employee.setAge(34L);
//        employee.setName("nikita");
//        employee.setSurname("gaydash");
//        employeeService.add(employee);
//       List<Employee> employeeList=employeeService.getByMaxSalary();
//        System.out.println(employeeList);
//        System.out.println(employeeService.findAll());
//        System.out.println(userService.findAllBySalary(13L,70L));

//        VisitUser visitUser=new VisitUser();
//        visitUser.setActivityId(2L);
//        visitUser.setMoneySpent(new BigDecimal(12));
//        visitUser.setClientId(3L);
//        visitUser.setDateOfVisit(LocalDate.of(2023,2,14));
//        visitUserService.addVisit(visitUser);

//        LocalDate start = LocalDate.of(2023,9,18);
//        LocalDate end = LocalDate.of(2023,9,30);
//        System.out.println(employeeService.spendSalary(start,end));
//        System.out.println(visitUserService.sumByDay(visitUserService.findByData(start,end)));

//        User user1=new User();
//        user1.setName("Dima");
//        user1.setSurname("lox");
//        user1.setAge(55L);
//        employee.setCompany("bmw");
//        Address address=new  Address("jopin", "tu", "12","1241");
//        User user = new User("Andrei","Andrei",47L,"3123",localDate,BigDecimal.valueOf(1200),Status.VIP,address);
//        userService.add(user1);
//        System.out.println(userService.findUserByName("lox"));
//        System.out.println(userService.getAllUser());
//


//        System.out.println(officeService.getSmallOffice());
//        Office office=officeService.findUserById(1L);
//        officeService.changPrice(1L,new BigDecimal(75));
//        officeService.changeMAXUser(1L,100L);
//        System.out.println(officeService.priceForUser(2L));


    }
}