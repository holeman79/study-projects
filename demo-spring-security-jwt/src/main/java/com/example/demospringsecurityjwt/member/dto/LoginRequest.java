package com.example.demospringsecurityjwt.member.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String loginId;

    private String password;
}
