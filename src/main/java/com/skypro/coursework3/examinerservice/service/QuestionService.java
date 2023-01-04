package com.skypro.coursework3.examinerservice.service;
import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.record.QuestionRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface QuestionService {
    Question add(String question, String answer);

    Question add(QuestionRequest questionRequest);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
