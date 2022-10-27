package com.demo.apiserver.domain;

import com.demo.common.domain.Member;
import com.demo.common.domain.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void member() {
        Member member = new Member("jowonjin");

    }
}
