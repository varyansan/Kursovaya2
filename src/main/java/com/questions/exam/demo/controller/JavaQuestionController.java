package com.questions.exam.demo.controller;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.exception.QuestionNotFoundException;
import com.questions.exam.demo.servise.QuestionService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionServiceImp) {
        this.questionService = questionServiceImp;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) throws QuestionNotFoundException {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) throws QuestionNotFoundException {
        return questionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
