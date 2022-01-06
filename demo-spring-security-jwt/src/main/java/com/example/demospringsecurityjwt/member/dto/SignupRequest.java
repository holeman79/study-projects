package com.example.demospringsecurityjwt.member.dto;

import com.example.demospringsecurityjwt.member.domain.Member;
import com.example.demospringsecurityjwt.member.domain.MemberRole;
import lombok.Getter;

@Getter
public class SignupRequest {
    private String loginId;

    private String password;

    private String nickName;

    private MemberRole memberRole;

    public Member toMember(String encodedPassword){
        return Member.createMember(loginId, encodedPassword, nickName, memberRole);
    }
}
