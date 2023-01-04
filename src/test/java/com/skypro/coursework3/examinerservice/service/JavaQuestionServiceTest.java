package com.skypro.coursework3.examinerservice.service;

import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.record.QuestionRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;
    private final String newQuestion = "question6";
    private final String newAnswer = "answer6";

    private final Question question1 = new Question("question1", "answer1");
    private final Question question2 = new Question("question2", "answer2");
    private final Question question3 = new Question("question3", "answer3");
    Collection<Question> questions = List.of(question1, question2, question3);
    private final QuestionRequest questionRequest = new QuestionRequest();

    private final QuestionRequest questionRequest1 = new QuestionRequest();
    private final QuestionRequest questionRequest2 = new QuestionRequest();
    private final QuestionRequest questionRequest3 = new QuestionRequest();


    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();

        questionRequest.setQuestion(newQuestion);
        questionRequest.setAnswer(newAnswer);

        questionRequest1.setQuestion("question1");
        questionRequest1.setAnswer("answer1");

        questionRequest2.setQuestion("question2");
        questionRequest2.setAnswer("answer2");

        questionRequest3.setQuestion("question3");
        questionRequest3.setAnswer("answer3");



        javaQuestionService.add(questionRequest1);
        javaQuestionService.add(questionRequest2);
        javaQuestionService.add(questionRequest3);

    }

    @Test
    void add() {
        Question expected = new Question(newQuestion, newAnswer);
        var actual = javaQuestionService.add(newQuestion, newAnswer);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void remove() {
        Question expected = new Question(questionRequest1.getQuestion(), questionRequest1.getAnswer());
        Question actual = javaQuestionService.remove(question1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllQuestions() {
        Collection<Question> actual = javaQuestionService.getAll();
        Collection<Question> expected = questions;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnRandomQuestion() {
        Question actual = javaQuestionService.getRandomQuestion();
        List<Question> expected = questions.stream().toList();
        Assertions.assertTrue(expected.contains(actual));
    }
}