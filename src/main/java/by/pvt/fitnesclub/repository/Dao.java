package by.pvt.fitnesclub.repository;

import by.pvt.fitnesclub.entity.User;

import java.util.List;

public interface Dao {
    void add(User user);
    User findUserById(Long id);
    void deleteUser(Long id);
    List<User> getAllUser();
}
