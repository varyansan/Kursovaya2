package com.questions.exam.demo.servise.impl;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.exception.QuestionAmountMismatchException;
import com.questions.exam.demo.servise.ExaminerService;
import com.questions.exam.demo.servise.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Collection<Question> allQuestions = questionService.getAll();
        if (amount < 0 || amount > allQuestions.size()) {
            throw new QuestionAmountMismatchException(amount);
        }
        if (amount == allQuestions.size()) {
            return allQuestions;
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
