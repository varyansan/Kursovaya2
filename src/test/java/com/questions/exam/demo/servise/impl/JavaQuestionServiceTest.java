package com.questions.exam.demo.servise.impl;

import com.questions.exam.demo.Question;
import com.questions.exam.demo.exception.QuestionNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.questions.exam.demo.servise.impl.TestData.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();


    @Test
    void shouldAddQuestion_WhenCorrectQuestion_ThenAdd() throws QuestionNotFoundException {

        //test
        Question actual = javaQuestionService.add(RANDOM_QUESTION_1);

        //check
        Collection<Question> result = javaQuestionService.getAll();
        assertThat(result).hasSize(1);
        assertThat(result.iterator().next()).isEqualTo(RANDOM_QUESTION_1);
    }

    @Test
    void shouldAddQuestion_WhenQuestionAlreadyAdded_ThenThrowException() throws QuestionNotFoundException {
        javaQuestionService.add(RANDOM_QUESTION_1);
        //check
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.add(RANDOM_QUESTION_1));
    }

    @Test
    void shouldAddQuestion_WhenAnotherQuestionAlreadyAdded_ThenAddQuestion() throws QuestionNotFoundException {
        javaQuestionService.add(RANDOM_QUESTION_2);
        //check
        assertDoesNotThrow(()-> javaQuestionService.add(RANDOM_QUESTION_1));
    }

    @Test
    void shouldRemoveQuestion_WhenCorrectQuestion_ThenRemove() throws QuestionNotFoundException {
        javaQuestionService.add(RANDOM_QUESTION_1);

        //test
        Question actual = javaQuestionService.remove(RANDOM_QUESTION_1);

        //check
        Collection<Question> result = javaQuestionService.getAll();
        assertThat(result).isEmpty();
        assertThat(actual).isEqualTo(RANDOM_QUESTION_1);
    }

    @Test
    void shouldRemoveQuestion_WhenCorrectQuestionNotExist_ThenRemove() throws QuestionNotFoundException {
        //check
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> javaQuestionService.remove(RANDOM_QUESTION_1));
    }

    @Test
    void shouldReturnAllQuestions() throws QuestionNotFoundException {
        javaQuestionService.add(RANDOM_QUESTION_1);
        javaQuestionService.add(RANDOM_QUESTION_2);
        javaQuestionService.add(RANDOM_QUESTION_3);

        //test
        Collection<Question> actual = javaQuestionService.getAll();

        //check
        assertThat(actual).hasSize(3);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(getAll());
    }

    @Test
    void shouldReturnRandomQuestions() throws QuestionNotFoundException {
        javaQuestionService.add(RANDOM_QUESTION_1);
        javaQuestionService.add(RANDOM_QUESTION_2);
        javaQuestionService.add(RANDOM_QUESTION_3);

        //test
        Question actual = javaQuestionService.getRandomQuestion();

        //check
        assertThat(getAll()).contains(actual);

    }
}