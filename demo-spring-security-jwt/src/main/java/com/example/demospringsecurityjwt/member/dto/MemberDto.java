package com.example.demospringsecurityjwt.member.dto;

import com.example.demospringsecurityjwt.member.domain.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long id;
    private String nickName;
    private String token;

    private MemberDto(Long id, String nickName, String token){
        this.id = id;
        this.nickName = nickName;
        this.token = token;
    }

    public static MemberDto of(Member member, String token){
        return new MemberDto(member.getId(), member.getNickName(), token);
    }
}
