package com.questions.exam.demo.servise.impl;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.exception.QuestionAmountMismatchException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static com.questions.exam.demo.servise.impl.TestData.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void setUp() {
        when(javaQuestionService.getAll()).thenReturn(getAll());
    }

    @AfterEach
    public void setDown() {
        verify(javaQuestionService, times(1)).getAll();
    }

    @Test
    @DisplayName("Возвращает коллекцию рандомных вопросов")
    void getQuestion() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                RANDOM_QUESTION_1,
                RANDOM_QUESTION_2,
                RANDOM_QUESTION_3
        );
        int amount = 2;

        //test
        Collection<Question> actual = examinerService.getQuestion(2);

        //check
        assertThat(getAll()).containsAnyElementsOf(actual);

        verify(javaQuestionService, times(amount)).getRandomQuestion();
    }

    @Test
    @DisplayName("Возвращает все вопросы и не вызывает сервис повторно")
    void getQuestion_2() {
        int amount = 3;

        //test
        Collection<Question> actual = examinerService.getQuestion(amount);

        //check
        assertThat(getAll()).containsAnyElementsOf(actual);

        verify(javaQuestionService, never()).getRandomQuestion();
    }

    @Test
    @DisplayName("Возвращает все вопросы и не вызывает сервис повторно")
    void getQuestion_3() {
        //test
        assertThatExceptionOfType(QuestionAmountMismatchException.class)
                .isThrownBy(() -> examinerService.getQuestion(4));

    }
}