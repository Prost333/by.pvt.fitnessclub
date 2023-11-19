package by.pvt.fitnesclub.controller;

import by.pvt.fitnesclub.dto.UserRequest;
import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.mapper.UserMapper;
import by.pvt.fitnesclub.service.SaleService;
import by.pvt.fitnesclub.service.imp.UserServiceImp;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserRestController {
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    SaleService saleService;
    @PostMapping("/add")
    public UserResponse add(@RequestBody UserRequest userRequest){
        User user=userServiceImp.add(userMapper.toEntity(userRequest));
        return userMapper.userToUserResponse(user);
    }

    @GetMapping("/getAll")
    public List<UserResponse> findAllUsers() {
        return userServiceImp.getAllUserRes();
    }

    @GetMapping("/changeStatus")
    public UserResponse changeStatus(Long id) {
        return userServiceImp.changeStatus(id);
    }

    @GetMapping("/addSale")
    public String addSale(Long userId, Long saleId) {
        userServiceImp.addSaleToUser(userId, saleService.findEntityById(saleId));
        return "sale add";
    }



}
