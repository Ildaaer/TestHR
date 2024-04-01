package com.example.testhr.Service;

import com.example.testhr.Entyties.Answer;
import com.example.testhr.Entyties.User;
import com.example.testhr.Repository.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AnswerServiceImplTest {

    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private AnswerServiceImpl answerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllAnswer() {
        // Создаем тестовые данные
        List<Answer> expectedAnswers = new ArrayList<>();
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
        expectedAnswers.add(new Answer(1L, "Answer 1", user1));
        expectedAnswers.add(new Answer(2L, "Answer 2", user1));

        // Устанавливаем поведение mock репозитория при вызове findAll()
        when(answerRepository.findAll()).thenReturn(expectedAnswers);

        // Вызываем метод сервиса
        List<Answer> actualAnswers = answerService.getAllAnswer();

        // Проверяем, что ответы, возвращенные сервисом, соответствуют ожидаемым
        assertEquals(expectedAnswers, actualAnswers);
    }

    @Test
    public void testSaveAllAnswer_Success() {
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
        // Создаем тестовые данные
        List<Answer> answersToSave = new ArrayList<>();
        answersToSave.add(new Answer(1L, "Answer 1", user1));
        answersToSave.add(new Answer(2L, "Answer 2", user1 ));

        // Устанавливаем поведение mock репозитория при вызове saveAll()
        when(answerRepository.saveAll(answersToSave)).thenReturn(answersToSave);

        // Вызываем метод сервиса
        List<Answer> savedAnswers = answerService.saveAllAnswer(answersToSave);

        // Проверяем, что сохраненные ответы совпадают с ожидаемыми
        assertEquals(answersToSave, savedAnswers);
    }

    @Test
    public void testSaveAllAnswer_Failure() {
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
        // Создаем тестовые данные
        List<Answer> answersToSave = new ArrayList<>();
        answersToSave.add(new Answer(1L, "Answer 1", user1));
        answersToSave.add(new Answer(2L, "Answer 2", user1));

        // Устанавливаем поведение mock репозитория при вызове saveAll() для выброса исключения
        when(answerRepository.saveAll(answersToSave)).thenThrow(new DataAccessException("Simulated error") {});

        // Вызываем метод сервиса
        List<Answer> savedAnswers = answerService.saveAllAnswer(answersToSave);

        // Проверяем, что метод возвращает null в случае ошибки
        assertNull(savedAnswers);
    }
}
