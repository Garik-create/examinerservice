package com.skypro.coursework3.examinerservice.service;

import com.skypro.coursework3.examinerservice.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
