package com.example.demospringsecurityjwt.member.domain;

import lombok.Getter;

@Getter
public enum MemberRole {
    MEMBER("일반 사용자"),
    ADMIN("관리자");

    private static final String PREFIX = "ROLE_";

    private String description;

    MemberRole(final String description) {
        this.description = description;
    }

    public String getFullRoleName() {
        return PREFIX + this.description;
    }
}
