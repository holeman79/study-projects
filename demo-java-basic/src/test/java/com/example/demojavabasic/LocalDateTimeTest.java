package com.example.demojavabasic;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    @Test
    void format() {
        String result = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(result);
    }

    @Test
    void epochTime() {
        //LocalDateTime.ofEpochSecond(1643104217843L, )
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(1643104217843L, 0, ZoneOffset.UTC);
        localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(1643104217L, 0), ZoneId.systemDefault());
        localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(1644835078818L), ZoneId.systemDefault());

        //1644835268020
        //1644147525615
        System.out.println(localDateTime);
    }

    @Test
    void localDateTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.of(2022, 6, 19);
        System.out.println("LocalDateTime : " + dateTime);
        System.out.println("LocalDate : " + localDate);

        //boolean after = dateTime.isAfter(localDate);
        localDate.isBefore(dateTime.toLocalDate());

        //System.out.println(after);
    }
}
