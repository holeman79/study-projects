package com.example.demospringmongo.config;

import com.example.demospringmongo.domain.Cell;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfiguration {

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Arrays.asList(new MongoDoubleToCellConverter(), new MongoCellToDoubleConverter()));
    }

    private static class MongoDoubleToCellConverter implements Converter<Double, Cell> {

        @Override
        public Cell convert(final Double source) {
            return Cell.volt(source);
        }
    }

    private static class MongoCellToDoubleConverter implements Converter<Cell, Double> {

        @Override
        public Double convert(final Cell source) {
            return source.getVoltage().doubleValue();
        }
    }
}
