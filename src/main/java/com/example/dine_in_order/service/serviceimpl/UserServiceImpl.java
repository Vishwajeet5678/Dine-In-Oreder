package com.example.dine_in_order.service.serviceimpl;

import com.example.dine_in_order.enums.UserRole;
import com.example.dine_in_order.model.Admin;
import com.example.dine_in_order.model.Staff;
import com.example.dine_in_order.model.User;
import com.example.dine_in_order.repository.UserRepository;
import com.example.dine_in_order.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User registerUser(User user) {
       User child=this.createUserByRole(user.getRole());
       this.mapToNewUser(user,child);
        return userRepository.save(child);
    }

    private  User createUserByRole(UserRole role) {
        User user;
        switch (role)
        {
            case ADMIN -> user=new Admin();
            case STAFF -> user=new Staff();
            default -> throw new RuntimeException("Invalid user");
        }
        return user;
    }
    private void mapToNewUser(User user,User user2){
        user2.setUserName(user.getUserName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setPhno(user.getPhno());
        user2.setRole(user.getRole());

    }

}
