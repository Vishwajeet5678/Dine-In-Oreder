package com.example.dine_in_order.service.serviceimpl;

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
        return userRepository.save(user);
    }
}
