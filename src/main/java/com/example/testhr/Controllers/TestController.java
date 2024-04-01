package com.example.testhr.Controllers;

import com.example.testhr.Entyties.Answer;
import com.example.testhr.Entyties.User;
import com.example.testhr.Service.AnswerService;
import com.example.testhr.Service.AnswerServiceImpl;
import com.example.testhr.Service.UserService;
import com.example.testhr.Service.UserServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tests")
public class TestController {
    private final AnswerService answerService;
    private final UserService userService;


    @PostMapping("/submit")
    public ResponseEntity<String> submitTestAnswers(@RequestBody List<Answer> answers){
        answers = answerService.saveAllAnswer(answers);
        return ResponseEntity.ok("Результаты успешно сохранены");
    }
}
