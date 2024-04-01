package com.example.testhr.Service;

import com.example.testhr.Entyties.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> getAllAnswer();
    List<Answer> saveAllAnswer(List<Answer> answers);
    

}
