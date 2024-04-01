package com.example.testhr;

import com.example.testhr.Controllers.TestController;
import com.example.testhr.Entyties.Answer;
import com.example.testhr.Entyties.User;
import com.example.testhr.Service.AnswerServiceImpl;
import com.example.testhr.Service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestControllerTest {

    @Mock
    private AnswerServiceImpl answerService;

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private TestController testController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSubmitTestAnswers() {
        List<Answer> answers = new ArrayList<>();
        User user1 = User.builder()
                .id(1L)
                .name("Иван")
                .username("ivan123")
                .lastname("Иванов")
                .age(30)
                .password("password123")
                .email("ivan@example.com")
                .build();
        User user2 = User.builder()
                .id(2L)
                .name("Мария")
                .username("maria456")
                .lastname("Петрова")
                .age(25)
                .password("password456")
                .email("maria@example.com")
                .build();
        Answer answer1 = new Answer(1L, "ответ1", user1);
        Answer answer2 = new Answer(2L,"Ответ2", user1);
        answers.add(answer1);
        answers.add(answer2);

        ResponseEntity<?> expectedResponse = ResponseEntity.ok("Результаты успешно сохранены");
        when(answerService.saveAllAnswer(answers)).thenReturn(new ArrayList<>());

        ResponseEntity<?> actualResponse = testController.submitTestAnswers(answers);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
    }
}
