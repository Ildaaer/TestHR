package com.example.testhr.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String lastname;
    private int age;

    public UserDTO(Long id, String username, String email, String name, String lastname, int age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }


}
