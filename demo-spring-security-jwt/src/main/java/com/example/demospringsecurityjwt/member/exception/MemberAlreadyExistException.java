package com.example.demospringsecurityjwt.member.exception;

public class MemberAlreadyExistException extends MemberException{

    public MemberAlreadyExistException(){
        super("이미 존재하는 회원 ID입니다.");
    }
}
