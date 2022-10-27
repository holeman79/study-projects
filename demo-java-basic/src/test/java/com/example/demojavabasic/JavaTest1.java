package com.example.demojavabasic;

import com.example.demojavabasic.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int result = random.nextInt(46);
        double value = (double) result / 10000;
        double latitude = 37.4920;
        System.out.println(latitude + value);
    }

    @Test
    void random2() {
        int[] batteryStates = new int[]{0, 2, 3, 6, 7};
        Random random = new Random();
        System.out.println(batteryStates[random.nextInt(5)]);
    }

    @Test
    void random3() {
        Random random = new Random();
        int result = random.nextInt(22000) + 35000;
        String format = String.format("%.6f", (((double) result / 1000) + 40) * 2);
        double doubleValue = BigDecimal.valueOf(Double.parseDouble(format)).multiply(BigDecimal.valueOf(0.5)).subtract(BigDecimal.valueOf(40)).doubleValue();
        System.out.println(doubleValue);
    }

    @Test
    void test() {
        System.out.println(String.format("%.4f", 37.3525));
    }


    @Test
    void builder() {
        Product product1 = Product.builder().name("product1").description("description1").build();
        System.out.println(product1);
    }

    @Test
    void map() {
        Map<String, Long> maps = new HashMap<>();
        maps.put("key1", 10L);

        Long key2 = maps.get("key2");
        System.out.println(key2);
    }

    @Test
    void makeTopics() {
        String topicPrefix = "/garak/mqtt/";
        String[] strings = IntStream.rangeClosed(1, 500)
                .mapToObj(value -> topicPrefix + value)
                .toArray(String[]::new);
        System.out.println(strings[0]);
    }

    @Test
    void set() {
        Set<String> stringSet = new LinkedHashSet<>();
        stringSet.add("A");
        stringSet.add("B");
        stringSet.add("C");

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.getBean("");
    }

    @Test
    void length() {
        Long length = 1536435353623L;
        int x = (int) Math.log10(length) + 1;
        System.out.println(x);

    }

    @Test
    void random23() {
        int length = 10;
        int maxBound = 10;
        SecureRandom secureRandom = new SecureRandom();
        IntStream.rangeClosed(1, maxBound)
                .map(i -> secureRandom.nextInt(length))
                .forEach(System.out::println);
    }

    @Test
    void reduce() {
        int length = 10;
        int maxBound = 10;
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        String s = secureRandom.ints(0, 10)
                .limit(10)
                .mapToObj((i) -> String.valueOf(i))
                .collect(Collectors.joining());
//                .reduce((x, y) -> x + y)
//                .get();
        secureRandom.ints(0, 10)
                .limit(10)
                .forEach((number) -> stringBuilder.append(number));


        System.out.println(s);


//        IntStream.rangeClosed(1, maxBound)
//                .mapToObj(i -> secureRandom.nextInt(length))
//                .reduce((x, y) -> x + "" + y)
//                .forEach(System.out::println);
    }

    @Test
    void bigdecimal() {
        BigDecimal amount = BigDecimal.valueOf(0L);
        int compareTo = amount.compareTo(BigDecimal.ZERO);
        System.out.println(compareTo);
    }
}
