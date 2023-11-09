package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.mapper.UserMapper;
import by.pvt.fitnesclub.repository.dao.Dao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp {
    @Autowired
    private Dao dao;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public User add(User user) {
        Collection<User> users = dao.findAll();
        boolean userIsPresent = users.stream().allMatch(user1 -> user1.getId().equals(user.getId()));
        if (userIsPresent) {

        }
        return dao.save(user);
    }

    public List<User> getAll() {
        return dao.findAll();
    }

    public List<UserResponse> getAllUserRes() {
        List<User> users = getAll();
        List<UserResponse> userResponses = users.stream().map(user -> userMapper.userToUserResponse(user)).toList();
        return userResponses;
    }
}
