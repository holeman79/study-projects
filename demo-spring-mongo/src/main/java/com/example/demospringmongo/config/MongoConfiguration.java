package com.example.demospringmongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class MongoConfiguration {

//    @Bean
//    public MongoCustomConversions customConversions() {
//        return new MongoCustomConversions(Arrays.asList(new MongoDoubleToCellConverter(), new MongoCellToDoubleConverter()));
//    }
//
//    private static class MongoDoubleToCellConverter implements Converter<Double, Cell> {
//
//        @Override
//        public Cell convert(final Double source) {
//            return Cell.volt(source);
//        }
//    }
//
//    private static class MongoCellToDoubleConverter implements Converter<Cell, Double> {
//
//        @Override
//        public Double convert(final Cell source) {
//            return source.getVoltage().doubleValue();
//        }
//    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(new MongoStringToLocalDateTimeConverter(formatter), new MongoLocalDateTimeToStringConverter(formatter)));
    }

    private static class MongoStringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
        private final DateTimeFormatter formatter;

        public MongoStringToLocalDateTimeConverter(final DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        @Override
        public LocalDateTime convert(final String source) {
            return LocalDateTime.parse(source, formatter);
        }
    }

    private static class MongoLocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
        private final DateTimeFormatter formatter;

        public MongoLocalDateTimeToStringConverter(final DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        @Override
        public String convert(final LocalDateTime source) {
            return formatter.format(source);
        }
    }
}
