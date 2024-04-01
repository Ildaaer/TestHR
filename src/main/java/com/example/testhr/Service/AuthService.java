
package com.example.testhr.Service;

import com.example.testhr.Component.JwtCore;
import com.example.testhr.Config.PasswordEncoderConfig;
import com.example.testhr.DTO.JwtRequest;
import com.example.testhr.DTO.JwtResponse;
import com.example.testhr.DTO.RegistrationUserDTO;
import com.example.testhr.DTO.UserDTO;
import com.example.testhr.Entyties.Role;
import com.example.testhr.Entyties.User;
import com.example.testhr.Exceptions.AppError;
import com.example.testhr.Repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Data
@RequiredArgsConstructor
public class AuthService {
    private final UserServiceImpl userService;
    private final JwtCore jwtCore;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public ResponseEntity<?> signin(@RequestBody JwtRequest authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        }catch (BadCredentialsException e){
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неверный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtCore.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


    public ResponseEntity<?> signup(@RequestBody RegistrationUserDTO registrationUserDTO){
        if(!registrationUserDTO.getPassword().equals(registrationUserDTO.getConfirmPassword())){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпали"), HttpStatus.BAD_REQUEST);
        }
        if (userService.findUserByName(registrationUserDTO.getUsername()).isPresent()){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.createNewUser(registrationUserDTO);
        return ResponseEntity.ok(new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getName(), user.getLastname(), user.getAge()));
    }
}
