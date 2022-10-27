package com.example.demospringbasic.exception;

public class MembershipException extends RuntimeException {
    public MembershipException(String message) {
        super("[MembershipException] " + message);
    }
}
