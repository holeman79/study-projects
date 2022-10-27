package com.example.demospringjpa.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class MemberId {
    private static final int LENGTH = 9;

    private Long memberId;

    public MemberId(final Long memberId) {
        validateLength(memberId);
        this.memberId = memberId;
    }

    private void validateLength(final Long memberId) {
        int inputLength = (int)Math.log10(memberId) + 1;
        if (inputLength != 9) {
            throw new IllegalArgumentException("member id 길이가 9자리가 아닙니다.");
        }
    }
}
