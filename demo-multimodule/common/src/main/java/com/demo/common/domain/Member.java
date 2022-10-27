package com.demo.common.domain;

import javax.persistence.*;

@Entity
@Table(name = "MEMBERS")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    public Member(final String name) {
        this.name = name;
    }
}
