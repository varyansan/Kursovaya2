package com.questions.exam.demo.exception;

import com.questions.exam.demo.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotFoundException extends Throwable {

    private final String question;
    private final String answer;

    public QuestionNotFoundException(String question, String answer) {
        super("Question: " + question + ", with answer: " + answer + " is not found");
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
