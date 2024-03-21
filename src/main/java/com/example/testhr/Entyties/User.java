package com.example.testhr.Entyties;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    private static final String SEQ_NAME = ("user_seq");
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String name;
    private String lastname;
    private int age;
    private String password;
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
    private String team;


}


