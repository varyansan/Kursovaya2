package com.questions.exam.demo.servise;

import com.questions.exam.demo.Question;
import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
