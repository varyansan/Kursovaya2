package com.questions.exam.demo.controller;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.servise.ExaminerService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping
public class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestion(@PathVariable("amount") int amount) {
        return examinerService.getQuestion(amount);
    }
}
