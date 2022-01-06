package com.example.demojavabasic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JavaTest1 {

    @Test
    void parseLong() {
        Long.parseLong(null);
    }

    @Test
    @DisplayName("localDateTime 시간표기 테스트")
    void localDateTimeNow() {
        LocalDateTime localDateTime;
        System.out.println();
        System.out.println(LocalDateTime.now());
    }

    @Test
    void localDateTimeDifferenceTest() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime interfacedTime = LocalDateTime.now().minusSeconds(11);
        //LocalDateTime minusSeconds = now.minusSeconds(10);
        System.out.println(interfacedTime);
        System.out.println(now);

        System.out.println(now.minusSeconds(10).isAfter(interfacedTime));
    }

    @Test
    void localDateTimeToEpochTime() {
        //TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")));
        System.out.println(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
    }

    @Test
    void hashMap() {
        Map<String, Long> timeMap = new HashMap<>();
        timeMap.put("1", 100000L);
        timeMap.put("1", 100001L);

        assertThat(timeMap.size()).isEqualTo(1);

    }

    @Test
    void createDirectory() {
        String path = "/Users/jowonjin/mind-file/Q1";
        File Folder = new File(path);
        if (!Folder.exists()) {
            Folder.mkdirs(); //폴더 생성합니다.
            System.out.println("폴더가 생성되었습니다.");
        }
    }

    @Test
    void random() {
        Random random = new Random();
        int result = random.nextInt(5);
        System.out.println(result);
    }
}
