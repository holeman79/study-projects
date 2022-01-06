package com.example.demospringmongo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MobilityMongoRepository extends MongoRepository<Mobility, String> {
    List<Mobility> findByMobiId(String mobileId);

    List<Mobility> findByEventCode(String eventCode);
}
