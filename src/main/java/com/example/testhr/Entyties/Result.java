package com.example.testhr.Entyties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private static final String SEQ_NAME = ("relults_seq");
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;
    private int score_min;
    private int score_max;
    private String result;

}
