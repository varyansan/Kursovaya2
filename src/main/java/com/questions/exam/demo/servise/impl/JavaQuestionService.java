package com.questions.exam.demo.servise.impl;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.exception.QuestionNotFoundException;
import com.questions.exam.demo.servise.QuestionService;
import org.springframework.stereotype.Service;
import java.util.*;

import static java.util.Collections.unmodifiableSet;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) throws QuestionNotFoundException {
        Question questionResult = new Question(question, answer);
        if (questions.contains(questionResult)) {
            throw new QuestionNotFoundException(question, answer);
        }
        questions.add(questionResult);
        return questionResult;
    }

    @Override
    public Question add(Question question) throws QuestionNotFoundException {
        if (questions.contains(question)) {
            throw new QuestionNotFoundException(question.getQuestion(), question.getAnswer());
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) throws QuestionNotFoundException {
        Question questionResult = new Question(question, answer);
        if (!questions.contains(questionResult)) {
            throw new QuestionNotFoundException(question, answer);
        }
        questions.remove(questionResult);
        return questionResult;
    }

    @Override
    public Question remove(Question question) throws QuestionNotFoundException {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException(question.getQuestion(), question.getAnswer());
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.toArray(new Question[0])[random.nextInt(questions.size())];
    }

}
