package com.example.demospringjpa.entity;

import com.example.demospringjpa.entity.generic.BaseCreatedTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Question extends BaseCreatedTimeEntity {
    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private QuestionNumber questionNumber;

    @Embedded
    private MemberId memberId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "number", column = @Column(name = "prev_question_number"))
    })
    private QuestionNumber prevQuestionNumber;

    private String content;

    @Builder
    private Question(final QuestionNumber prevQuestionNumber, final QuestionNumber questionNumber, final String content,
                     final Long memberId) {
        this.prevQuestionNumber = prevQuestionNumber;
        this.questionNumber = questionNumber;
        this.content = content;
        this.memberId = new MemberId(memberId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionNumber=" + questionNumber +
                ", memberId=" + memberId +
                ", prevQuestionNumber=" + prevQuestionNumber +
                ", content='" + content + '\'' +
                '}';
    }
}
