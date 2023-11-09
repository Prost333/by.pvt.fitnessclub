package by.pvt.fitnesclub.controller;

import by.pvt.fitnesclub.dto.UserRequest;
import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.mapper.UserMapper;
import by.pvt.fitnesclub.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getAll")
    public List<UserResponse> findAllUsers(){
        return userServiceImp.getAllUserRes();
    }

}
