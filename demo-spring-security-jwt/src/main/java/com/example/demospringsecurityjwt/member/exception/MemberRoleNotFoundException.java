package com.example.demospringsecurityjwt.member.exception;

public class MemberRoleNotFoundException extends MemberException{

    public MemberRoleNotFoundException(){
        super("존재하지 않는 권한입니다.");
    }
}
