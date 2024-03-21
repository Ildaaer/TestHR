package com.example.testhr.Controllers;

import com.example.testhr.Component.JwtCore;
import com.example.testhr.DTO.JwtRequest;
import com.example.testhr.DTO.JwtResponse;
import com.example.testhr.DTO.RegistrationUserDTO;
import com.example.testhr.DTO.UserDTO;
import com.example.testhr.Entyties.Role;
import com.example.testhr.Entyties.User;
import com.example.testhr.Exceptions.AppError;
import com.example.testhr.Repository.UserRepository;
import com.example.testhr.Service.AuthService;
import com.example.testhr.Service.RoleService;
import com.example.testhr.Service.UserServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final RoleService roleService;
    private final UserServiceImpl userService;

    @PostMapping("/signin")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest){
        return authService.createAuthToken(authRequest);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegistrationUserDTO registrationUserDTO, @RequestParam("role") String roleName) {
        return authService.signup(registrationUserDTO, roleName);
    }


}
