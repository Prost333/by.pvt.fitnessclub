package by.pvt.fitnesclub;

import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.Status;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.repository.OfficeRepositoryHibernate;
import by.pvt.fitnesclub.repository.UserRepository;
import by.pvt.fitnesclub.repository.UserRepositoryHibernate;
import by.pvt.fitnesclub.service.OfficeServise;
import by.pvt.fitnesclub.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        BigDecimal bigDecimal = BigDecimal.valueOf(1000);
        UserService userService=new UserService(new UserRepositoryHibernate());
        OfficeServise officeServise=new OfficeServise(new OfficeRepositoryHibernate());
//        Office office =new Office("1",123L,"AKTIV",10L,new BigDecimal(23));
//        officeServise.add1(office,35265L);
//        Office office=officeServise.findUserById(1L);
//        officeServise.changPrice(1L,new BigDecimal(75));
//        officeServise.changeMAXUser(1L,100L);
        System.out.println(officeServise.priceForUser(2L));


    }
}