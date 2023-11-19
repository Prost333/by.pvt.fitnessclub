package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.exception.EntityNotFoundException;
import by.pvt.fitnesclub.mapper.UserMapper;
import by.pvt.fitnesclub.repository.dao.Dao;
import by.pvt.fitnesclub.service.SaleService;
import by.pvt.fitnesclub.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final Dao dao;

    private final UserMapper userMapper;

    private final SaleService saleService;
    private final PasswordEncoder passwordEncoder;


    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return dao.save(user);
    }
    public UserResponse findById(Long id){
        User user=dao.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
        return  userMapper.userToUserResponse(user);
    }
    public User findEntityById(Long id){
        User user=dao.findById(id).orElseThrow(()-> new EntityNotFoundException("not found"));
        return  user;
    }

    public List<User> getAll() {
        return dao.findAll();
    }

    public List<UserResponse> getAllUserRes() {
        List<User> users = getAll();
        List<UserResponse> userResponses = users.stream().map(user -> userMapper.userToUserResponse(user)).toList();
        return userResponses;
    }

    public UserResponse changeStatus(Long id){
        User user =findEntityById(id);
       user.setStatus("передан");
       dao.save(user);
       return userMapper.userToUserResponse(user);
    }

    public void addSaleToUser(Long userId, Sale sale) {
        User user = dao.findById(userId).orElse(null);
            if (user != null && !user.getSale().contains(sale)) {
                user.getSale().add(sale);
                sale.setUser(user);
                saleService.addEntity(sale);
                dao.save(user);
            }
         else {
            System.out.println(" ");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user=dao.findByName(username);
        return (UserDetails) user;

    }
}
