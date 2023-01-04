package com.skypro.coursework3.examinerservice.service;

import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.exceptions.ThereAreMoreQuestionsInRequirementException;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl examinerService;
    @Mock
    private QuestionService questionService;


    private Collection<Question> questionsList;

    private final Question question1 = new Question("question1", "answer1");

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(questionService);
        questionsList = Set.of(question1);
    }

    @Test
    void getQuestions() {
        Question expected = question1;
        Collection<Question> expectedList = questionsList;
        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Collection<Question> actualList = examinerService.getQuestions(1);
        Assertions.assertEquals(expectedList,actualList);

    }

    @Test
    void shouldReturnThereAreMoreQuestionsInRequirementException() {
        Collection<Question> expectedList = questionsList;
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Assertions.assertThrows(ThereAreMoreQuestionsInRequirementException.class,
                ()->examinerService.getQuestions(2));
    }
}