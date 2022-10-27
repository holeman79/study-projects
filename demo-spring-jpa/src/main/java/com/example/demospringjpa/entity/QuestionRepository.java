package com.example.demospringjpa.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByMemberId(final MemberId memberId);

    boolean existsByMemberId(final MemberId memberId);
}
