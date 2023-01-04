package com.skypro.coursework3.examinerservice.service;
import com.skypro.coursework3.examinerservice.domain.Question;
import com.skypro.coursework3.examinerservice.record.QuestionRequest;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question == null
                || question.isEmpty()
                || question.isBlank()
                || answer == null
                || answer.isEmpty()
                || answer.isBlank()) {
            throw new IllegalArgumentException("Введите данные!");
        }
        var question1 = new Question(question, answer);
        if (!questions.add(question1)) {
            throw  new IllegalArgumentException("Такой вопрос уже существует!");
        }
        return question1;
    }

    @Override
    public Question add(QuestionRequest questionRequest) {
        if (questionRequest.getQuestion() == null
                || questionRequest.getQuestion().isEmpty()
                || questionRequest.getQuestion().isBlank()
                || questionRequest.getAnswer() == null
                || questionRequest.getAnswer().isEmpty()
                || questionRequest.getAnswer().isBlank()) {
            throw new IllegalArgumentException("Введите данные!");
        }
        var question = new Question(questionRequest.getQuestion(), questionRequest.getAnswer());
        if (!questions.add(question)) {
            throw  new IllegalArgumentException("Такой вопрос уже существует!");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            System.out.println("Такой вопрос отсутствует в списке!");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        Question[] questionsArray = new Question[questions.size()];
        questions.toArray(questionsArray);
        return new ArrayList<>(List.of(questionsArray));
    }

    @Override
    public Question getRandomQuestion() {

        Random randomQuestion = new Random();
        var digit = randomQuestion.nextInt(questions.size());
        Question[] questionsArray = new Question[questions.size()];
        questions.toArray(questionsArray);
        return questionsArray[digit];
    }

}
