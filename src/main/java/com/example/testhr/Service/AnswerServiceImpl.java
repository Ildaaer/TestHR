package com.example.testhr.Service;

import com.example.testhr.Entyties.Answer;
import com.example.testhr.Repository.AnswerRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Data
public class AnswerServiceImpl implements AnswerService{
    private final AnswerRepository answerRepository;
    @Override
    public List<Answer> getAllAnswer() {
        return answerRepository.findAll();
    }
    @Override
    public List<Answer> saveAllAnswer(List<Answer> answers){
        try {
            return answerRepository.saveAll(answers);
        } catch (DataAccessException e) {
            // Логирование ошибки или обработка исключения
            e.printStackTrace(); // Просто вывод исключения в консоль
            return null; // Возвращаем null в случае ошибки
        }
    }
}
