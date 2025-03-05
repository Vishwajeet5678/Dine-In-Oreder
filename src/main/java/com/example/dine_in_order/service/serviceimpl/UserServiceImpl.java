package com.example.dine_in_order.service.serviceimpl;

import com.example.dine_in_order.dto.request.RegistrationRequest;
import com.example.dine_in_order.dto.request.UserRequest;
import com.example.dine_in_order.dto.response.UserResponse;
import com.example.dine_in_order.enums.UserRole;
import com.example.dine_in_order.exception.UserNotFoundByIdException;
import com.example.dine_in_order.mapper.UserMapper;
import com.example.dine_in_order.model.Admin;
import com.example.dine_in_order.model.Staff;
import com.example.dine_in_order.model.User;
import com.example.dine_in_order.repository.UserRepository;
import com.example.dine_in_order.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    @Override
    public UserResponse registerUser(RegistrationRequest registration) {
       User user=this.createUserByRole(registration.getRole());
       mapper.mapToUser(registration,user);
        userRepository.save(user);

       return mapper.mapToUserResponse(user);
    }


    /**
     * Creates a User instance based on the given role.
     *
     * @param role The UserRole enum value determining the type of user to be created.
     * @return A User instance of the corresponding role type.
     * @throws RuntimeException If the role is invalid.
     */

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



    @Override
    public UserResponse findUserById(long userId) {
                User user=userRepository.findById(userId)
                .orElseThrow(
                        ()->new UserNotFoundByIdException("User not found by id")
                );
               return mapper.mapToUserResponse(user);

    }

    @Override
    public UserResponse updateUserById(long userId, UserRequest user) {
        User exUser=userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundByIdException("User Not found"));
        mapper.mapToNewUserRequest(user,exUser);
         userRepository.save(exUser);
         return mapper.mapToUserResponse(exUser);


    }


}
