package com.example.testhr.Entyties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Struct;
import java.util.List;

@Entity
@Table(name = "tests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private static final String SEQ_NAME = ("test_seq");
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Question> questions;
    @OneToOne(cascade = CascadeType.ALL)
    private Result result;

}
