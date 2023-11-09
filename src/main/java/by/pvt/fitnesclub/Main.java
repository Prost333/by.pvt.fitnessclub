package by.pvt.fitnesclub;

import by.pvt.fitnesclub.entity.*;

import by.pvt.fitnesclub.service.NoteService;
import by.pvt.fitnesclub.service.imp.NoteServiceImp;
import by.pvt.fitnesclub.service.imp.OfficeServiceImp;
import by.pvt.fitnesclub.service.imp.VisitorServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@ComponentScan("by.pvt.fitnesclub.config")
public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(UserConfig.class);
//        ActivitesService activitesService=applicationContext.getBean("activitesService",ActivitesService.class);
//        System.out.println(activitesService.getAllActivites());
//        String date = "2023-09-18 13:18";
//        LocalDateTime time = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
//        SaleServiceImp saleService = applicationContext.getBean(SaleServiceImp.class);
//        Sale sale = new Sale();
//        sale.setStausUser("new");
//        sale.setValue(new BigDecimal(35));
//        sale.setStart(LocalDate.of(2023,2,14));
//        sale.setStop(LocalDate.of(2023,2,15));
//        saleService.add(sale);
//        Sale sale1= saleService.findID(2L);
//        System.out.println(sale1);


//        LocalDate localDate = LocalDate.now();
//        BigDecimal bigDecimal = BigDecimal.valueOf(1000);
//        UserServiceImp userService = new UserServiceImp(new UserRepositoryHibernate());
//        OfficeServiceImp officeServiceImp = new OfficeServiceImp(new OfficeRepositoryHibernate());
//        VisitorServiceImp visitorServiceImp = new VisitorServiceImp(new VisitorRepositoryHib());
//        EmployeeService employeeService = new EmployeeService(new EmployeeRepository());
//        ActivitesService activitesService = new ActivitesService(new ActivitesRepository());
//        VisitUserService visitUserService = new VisitUserService(new VisitUserRepHibernate());
//        NoteServiceImp noteService = new NoteServiceImp(new NoteRepository());
//        OfficeRepositoryHibernate officeRepositoryHibernate=new OfficeRepositoryHibernate();
//        officeRepositoryHibernate.getOfficeandActivitec(1L);
//        ActivitesRepository activitesRepository=new ActivitesRepository();
//        System.out.println(activitesRepository.getActivitesandOffice(1L));
//        Address address = new Address("jopin", "tu", "12", "1241");
////        VisitorServiceImp visitor = new VisitorServiceImp();

        String date1 = "2023-09-18";

//        Activites activites= new Activites();
//        activites.setCost(5L);
//        activites.setName("gum");
//        activitesService.add(activites);
//        OfficeServiceImp officeServiceImp =applicationContext.getBean(OfficeServiceImp.class);
//        Office office = new Office("relax zone", 123L, "AKTIV", 15L, new BigDecimal(45));
//        officeServiceImp.add(office);
//        System.out.println(officeServiceImp.findAllByUserAndPrice(10L, 50L));

//        System.out.println(officeServiceImp.getCountGuest());
//        System.out.println(activitesService.lowPriceActivites());
//        VisitorServiceImp visitorServiceImp =applicationContext.getBean(VisitorServiceImp.class);
//        Visitor visitor =new Visitor();
//        visitor.setSurname("Dimon");
//        visitor.setName("Dimon");
//        visitor.setStatus(Status.ACTIVITY);
//        visitor.setMoney(new BigDecimal(12));
//        visitorServiceImp.add(visitor);
//
//        NoteService noteService = (NoteService) applicationContext.getBean("noteServiceImp");
//        Note note = new Note();
//        note.setLocalDateTime(time);
//        note.setOffice(officeServiceImp.findID(2L));
//        note.setVisitor(visitorServiceImp.findID(11L));
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


//        System.out.println(officeServiceImp.getSmallOffice());
//        Office office=officeServiceImp.findUserById(1L);
//        officeServiceImp.changPrice(1L,new BigDecimal(75));
//        officeServiceImp.changeMAXUser(1L,100L);
//        System.out.println(officeServiceImp.priceForUser(2L));


    }
}