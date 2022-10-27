package com.example.demospringjpa.entity.generic;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseCreatedTimeEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdTime;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }
}
