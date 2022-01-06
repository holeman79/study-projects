package com.example.demospringsecurityjwt.generic.config.security.jwt;

import com.example.demospringsecurityjwt.member.domain.MemberRole;
import lombok.Getter;

@Getter
public class JwtMember {
    private Long id;

    private String nickName;

    private MemberRole memberRole;

    private JwtMember(Long id, String nickName, MemberRole memberRole){
        this.id = id;
        this.nickName = nickName;
        this.memberRole = memberRole;
    }

    public static JwtMember of(Long id, String nickName, MemberRole memberRole){
        return new JwtMember(id, nickName, memberRole);
    }

    @Override
    public String toString() {
        return "JwtMember{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", memberRole=" + memberRole +
                '}';
    }
}
