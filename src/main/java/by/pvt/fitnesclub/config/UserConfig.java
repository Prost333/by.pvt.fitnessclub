package by.pvt.fitnesclub.config;

import by.pvt.fitnesclub.repository.*;
import by.pvt.fitnesclub.repository.dao.*;
import by.pvt.fitnesclub.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.pvt.fitnesclub")
public class UserConfig {
    @Bean
   public ActivitesDao activitesRepositoryJPA(){
        return  new ActivitesRepository();
    }
    @Bean
    public  ActivitesService activitesService(){
        return  new ActivitesService(activitesRepositoryJPA());
    }
    @Bean
    public  DaoEmployee employeeRepository(){
        return  new EmployeeRepository();
    }
    @Bean
    public  EmployeeService employeeService(){
        return  new EmployeeService(employeeRepository());
    }
    @Bean
    public  DaoOffice officeRepository(){
        return  new OfficeRepositoryHibernate();
    }
    @Bean
    public  OfficeService officeService(){
        return  new OfficeService(officeRepository());
    }
    @Bean
    public  Dao userRepository(){
        return  new UserRepositoryHibernate();
    }
    @Bean
    public  UserService userService(){
        return  new UserService(userRepository());
    }
    @Bean
    public DaoVisitor visitorRepository(){
        return  new VisitorRepositoryHib();
    }
    @Bean
    public  VisitorService visitorService(){
        return  new VisitorService(visitorRepository());
    }
    @Bean
    public  VisitDao visitUserRepository(){
        return  new VisitUserRepHibernate();
    }
    @Bean
    public   VisitUserService visitUserService(){
        return  new VisitUserService(visitUserRepository());
    }


}
