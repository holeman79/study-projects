package com.example.demospringjpa.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class QuestionTest {
    @Autowired
    private QuestionRepository questionRepository;

    @BeforeEach
    void save() {
        questionRepository.save(Question.builder().content("dddd").build());
    }

    @Test
    void find() {
        Question question = questionRepository.findById(1L).get();
        System.out.println(question);
    }
}
