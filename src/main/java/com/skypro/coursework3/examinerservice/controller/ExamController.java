package com.skypro.coursework3.examinerservice.controller;

import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.exceptions.ThereAreMoreQuestionsInRequirementException;
import com.skypro.coursework3.examinerservice.service.ExaminerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(@Qualifier("examinerServiceImpl") ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return service.getQuestions(amount);
    }

    @ExceptionHandler(value = ThereAreMoreQuestionsInRequirementException.class)
    public String illegalNumberHandler(ThereAreMoreQuestionsInRequirementException e) {
        return ResponseEntity.badRequest().build().getStatusCode() + " " + e.getMessage();
    }
}
