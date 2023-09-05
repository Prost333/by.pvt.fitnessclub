package by.pvt.fitnesclub;

import by.pvt.fitnesclub.entity.Status;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.repository.UserRepository;
import by.pvt.fitnesclub.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        BigDecimal bigDecimal = BigDecimal.valueOf(1000);
        UserService userService=new UserService(new UserRepository());
//        System.out.println(userService.getAllUser());
//        User user= new User(3L," ", " ",12L," ", localDate,bigDecimal,Status.ACTIVITY);
//        userRepository.add(user);
//        System.out.println(userRepository.getAllUser());
//        System.out.println(userRepository.findUserById(1L));
//        userRepository.deleteUser(3L);

    }
}