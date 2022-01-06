package com.example.demospringsecurityjwt.member.domain;

import com.example.demospringsecurityjwt.member.exception.MemberRoleNotFoundException;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum MemberRole {

    MEMBER("ROLE_MEMBER", "일반 사용자"),
    ADMIN("ROLE_ADMIN", "관리자")
    ;

    private String key;

    private String value;

    MemberRole(String key, String value){
        this.key = key;
        this.value = value;
    }

    public static MemberRole findRole(String key){
        return Arrays.stream(MemberRole.values())
                .filter(memberRole -> Objects.equals(memberRole.key, key))
                .findFirst()
                .orElseThrow(MemberRoleNotFoundException::new);
    }
}
