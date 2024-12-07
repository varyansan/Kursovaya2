package com.questions.exam.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionAmountMismatchException extends RuntimeException{

    public QuestionAmountMismatchException(int amount) {
        super("Incorrect amount of questions: %s".formatted(amount));
    }
}
