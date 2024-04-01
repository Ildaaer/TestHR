package com.example.testhr.Controllers;

import com.example.testhr.DTO.JwtRequest;
import com.example.testhr.DTO.RegistrationUserDTO;
import com.example.testhr.Service.AuthService;
import com.example.testhr.Service.RoleService;
import com.example.testhr.Service.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final UserServiceImpl userService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody JwtRequest authRequest){
        return authService.signin(authRequest);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegistrationUserDTO registrationUserDTO) {
        return authService.signup(registrationUserDTO);
    }


}
