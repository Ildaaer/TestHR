package com.example.testhr.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationUserDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String lastname;
    private String email;
    private int age;
}
