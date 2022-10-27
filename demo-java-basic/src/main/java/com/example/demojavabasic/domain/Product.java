package com.example.demojavabasic.domain;

import lombok.Builder;

import java.time.LocalDateTime;

public class Product {
    private String name;

    private String description;

    private LocalDateTime localDateTime = LocalDateTime.now();

    @Builder
    private Product(final String name, final String description) {
        if (description == null) {
            System.out.println("description is null");
        }
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
