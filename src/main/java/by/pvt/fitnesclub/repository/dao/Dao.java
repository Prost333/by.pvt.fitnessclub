package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Dao extends JpaRepository<User,Long> {

//    List <User> findByName (String name);
//    List<User> findAllBySalary(Long minAge, Long maxAge);
}
