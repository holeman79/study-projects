package com.example.demospringsecurityjwt.member.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "MEMBERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NICK_NAME")
    private String nickName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private MemberRole memberRole;

    @CreationTimestamp
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    private LocalDateTime updatedDate;

    public static Member createMember(String loginId, String password, String nickName, MemberRole memberRole){
        if(memberRole == null) memberRole = MemberRole.MEMBER;
        return new Member(loginId, password, nickName, memberRole);
    }

    private Member(String loginId, String password, String nickName, MemberRole memberRole){
        this.loginId = loginId;
        this.password = password;
        this.nickName = nickName;
        this.memberRole = memberRole;
    }
}
