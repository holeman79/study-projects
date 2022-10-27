package com.example.demospringmongo.domain;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document("mobility2")
@Builder
public class Mobility {
    @Id
    private String id;

    private Long mobiId;

    private String mobiTypCd;

    private Battery battery;

    private String eventCode;

    private BatteryType batteryType;

    private long value1;

    private LocalDateTime localDateTime;
}
