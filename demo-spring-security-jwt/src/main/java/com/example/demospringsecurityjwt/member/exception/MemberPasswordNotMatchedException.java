package com.example.demospringsecurityjwt.member.exception;

public class MemberPasswordNotMatchedException extends MemberException{

    public MemberPasswordNotMatchedException(){
        super("비밀번호가 일치하지 않습니다.");
    }
}
