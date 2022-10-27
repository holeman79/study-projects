package com.example.demospringjpa.application;

import com.example.demospringjpa.entity.Question;
import com.example.demospringjpa.entity.QuestionNumber;
import com.example.demospringjpa.entity.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void saveAll() {
        Question question1 = Question.builder()
                .questionNumber(new QuestionNumber(1))
                .content("content1")
                .build();
        Question question2 = Question.builder()
                .questionNumber(new QuestionNumber(2))
                .content("content2")
                .build();
        Question question3 = Question.builder()
                .questionNumber(new QuestionNumber(3))
                .content("content3")
                .build();

        questionRepository.saveAll(Arrays.asList(question1, question2, question3));
    }
}
