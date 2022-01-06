package com.example.demospringbasic.application;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {
    @Scheduled(fixedDelay = 5000)
    public void test() {
        System.out.println("schedule Test");
    }

    @Scheduled(fixedDelay = 3000)
    private void test2() {
        System.out.println("schedule Test2");
    }
}
