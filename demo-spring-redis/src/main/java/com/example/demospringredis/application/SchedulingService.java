//package com.example.demospringredis.application;
//
//import com.example.demospringredis.domain.Mobility;
//import com.example.demospringredis.domain.MobilityRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.StreamSupport;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class SchedulingService {
//    private final MobilityRepository mobilityRepository;
//
//    //@Scheduled(fixedDelay = 1000L)
//    @Scheduled(fixedDelay = 1000L)
//    private void updateMobilityState() {
//        //log.info("In Update");
//        Mobility mobility1 = mobilityRepository.findById(1L).get();
//
//        mobilityRepository.save(mobility1);
//    }
//
//    @Scheduled(fixedDelay = 1000L)
//    private void updateMobilityState2() {
//
//    }
//
//    //@Scheduled(fixedDelay = 1000L, initialDelayString = "#{ T(java.util.concurrent.ThreadLocalRandom).current().nextInt(1000) }" )
//    private void updateMobilityState3() {
//
//    }
//
//    @Scheduled(fixedDelay = 1000L)
//    private void getList() {
//        StreamSupport.stream(mobilityRepository.findAll().spliterator(), false)
//        .forEach(mobility -> log.info(mobility.getName()));
//    }
//}
