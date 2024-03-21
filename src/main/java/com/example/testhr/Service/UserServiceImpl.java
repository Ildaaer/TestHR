package com.example.testhr.Service;

import com.example.testhr.DTO.RegistrationUserDTO;
import com.example.testhr.Entyties.Role;
import com.example.testhr.Entyties.User;
import com.example.testhr.Repository.RoleRepository;
import com.example.testhr.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService{
    private  UserRepository userRepository;
    private  RoleService roleService;
    private  PasswordEncoder passwordEncoder;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findUserByName(String username){
        return userRepository.findUserByName(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByName(username).orElseThrow(()-> new UsernameNotFoundException(
                String.format("User: " + username + " " + "not found")
        ));

        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
    @Transactional
    public User createNewUser(RegistrationUserDTO registrationUserDTO, Role role) {
        User user = new User();
        user.setName(registrationUserDTO.getUsername());
        user.setEmail(registrationUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationUserDTO.getPassword()));
        user.setRoles(List.of(role));
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        } else {
            throw new UsernameNotFoundException("User with id " + userId + " not found");
        }
    }
}
