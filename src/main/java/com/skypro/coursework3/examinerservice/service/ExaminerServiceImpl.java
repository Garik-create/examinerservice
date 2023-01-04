package com.skypro.coursework3.examinerservice.service;

import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.exceptions.ThereAreMoreQuestionsInRequirementException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    private final Collection<Question> examQuestions = new HashSet<>();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        examQuestions.clear();
        if (amount > questionService.getAll().size()) {
            throw new ThereAreMoreQuestionsInRequirementException("Превышено количество вопросов в билетах.");
        }
        int count = 1;
        while (count <= amount) {
            if (examQuestions.add(questionService.getRandomQuestion())) {
                count++;
            }
        }
        return examQuestions;
    }

}
