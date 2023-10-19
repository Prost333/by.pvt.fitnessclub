package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.repository.dao.Dao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private  final Dao dao;

    public UserService(Dao dao) {
        this.dao = dao;
    }

    public void add(User user){
       dao.add(user);
   }
    public User findUserById(Long id){
      return dao.findUserById(id);
    }
    public void deleteUser(Long id){
       dao.deleteUser(id);
    }
    public List<User> getAllUser(){
       return  dao.getAllUser();
    }
    public  List <User> findUserByName (String name){
        return dao.findUserByName(name);
    }
    public List<User> findAllBySalary(Long minAge, Long maxAge){
       return dao.findAllBySalary(minAge,maxAge);
    }
}
