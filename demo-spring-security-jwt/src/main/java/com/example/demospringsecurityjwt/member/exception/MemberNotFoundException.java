package com.example.demospringsecurityjwt.member.exception;

public class MemberNotFoundException extends MemberException{

    public MemberNotFoundException(){
        super("존재하지 않는 회원입니다.");
    }
}
