package com.example.testhr.Service;

import com.example.testhr.DTO.RegistrationUserDTO;
import com.example.testhr.DTO.UserDTO;
import com.example.testhr.Entyties.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface UserService extends UserDetailsService {
    User createNewUser(RegistrationUserDTO registrationUserDTO);
    void deleteUserById(Long userId);
    UserDTO getUserById(Long userId);
    Long getCurrentUserId();
    Optional<User> getUserByUsername(String username);
}
