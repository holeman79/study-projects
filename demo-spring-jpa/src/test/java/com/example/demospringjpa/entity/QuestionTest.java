package com.example.demospringjpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class QuestionTest {
    @Autowired
    private QuestionRepository questionRepository;

//    @BeforeEach
//    void save() {
//        questionRepository.deleteAll();
//    }

    @Test
    void find() {
        Question question = questionRepository.findById(1L).get();
        System.out.println(question);
    }

    @Test
    void optional() {
        Question question4 = questionRepository.findByMemberId(new MemberId(135797531L))
                .orElseGet(() -> {
                    System.out.println("in OrElseGet");
                    return Question.builder()
                            .questionNumber(new QuestionNumber(4))
                            .prevQuestionNumber(new QuestionNumber(13))
                            .content("content4")
                            .memberId(555555555L)
                            .build();
                });
        questionRepository.save(question4);
        //System.out.println(byMemberId.get());
    }

    @Test
    void exists() {
        boolean result = questionRepository.existsByMemberId(new MemberId(135797532L));
        assertThat(result).isFalse();
    }


    @Test
    @Rollback(value = false)
    void saveAll() {
        Question question1 = Question.builder()
                .questionNumber(new QuestionNumber(1))
                .prevQuestionNumber(new QuestionNumber(10))
                .content("content1")
                .memberId(123456789L)
                .build();
        Question question2 = Question.builder()
                .questionNumber(new QuestionNumber(2))
                .prevQuestionNumber(new QuestionNumber(11))
                .content("content2")
                .memberId(234567890L)
                .build();
        Question question3 = Question.builder()
                .questionNumber(new QuestionNumber(3))
                .prevQuestionNumber(new QuestionNumber(12))
                .content("content3")
                .memberId(135797531L)
                .build();

        questionRepository.saveAll(Arrays.asList(question1, question2, question3));
    }

}
