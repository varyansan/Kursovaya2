package com.questions.exam.demo.servise;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.exception.QuestionNotFoundException;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer) throws QuestionNotFoundException;

    Question add(Question question) throws QuestionNotFoundException;

    Question remove(String question, String answer) throws QuestionNotFoundException;

    Question remove(Question question) throws QuestionNotFoundException;

    Collection<Question> getAll();

    Question getRandomQuestion();


}
