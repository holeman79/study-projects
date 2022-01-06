package com.example.demospringjpa.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Question {
    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "number", column = @Column(name = "prev_question_number"))
    })
    private QuestionNumber questionNumber;

    private String content;

    @Builder
    private Question(final QuestionNumber questionNumber, final String content) {
        this.questionNumber = questionNumber;
        this.content = content;
    }
}
