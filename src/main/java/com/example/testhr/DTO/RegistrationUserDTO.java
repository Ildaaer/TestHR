package com.example.testhr.DTO;

import com.example.testhr.Entyties.Role;
import lombok.Data;

@Data
public class RegistrationUserDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private Role role;


}
