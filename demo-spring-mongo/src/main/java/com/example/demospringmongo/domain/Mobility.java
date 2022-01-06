package com.example.demospringmongo.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("mobility")
public class Mobility {
    @Id
    private String id;

    private Long mobiId;

    private String mobiTypCd;

    private Battery battery;

    private String eventCode;
}
