package com.skypro.coursework3.examinerservice.exceptions;

public class ThereAreMoreQuestionsInRequirementException extends RuntimeException {
    public ThereAreMoreQuestionsInRequirementException() {
    }

    public ThereAreMoreQuestionsInRequirementException(String message) {
        super(message);
    }

    public ThereAreMoreQuestionsInRequirementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThereAreMoreQuestionsInRequirementException(Throwable cause) {
        super(cause);
    }

    public ThereAreMoreQuestionsInRequirementException(String message, Throwable cause,
                                                       boolean enableSuppression,
                                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
