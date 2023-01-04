package com.skypro.coursework3.examinerservice.controller;

import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService service;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String QuestionText,
                                   @RequestParam("answer") String QuestionAnswer) {
        return service.remove(new Question(QuestionText, QuestionAnswer));
    }

    @GetMapping("")
    public String getQuestions() {
        return "Вопросы в билетах:\n" + service.getAll();
    }
}
