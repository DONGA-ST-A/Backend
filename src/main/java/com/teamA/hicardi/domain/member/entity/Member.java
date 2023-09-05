package com.teamA.hicardi.domain.member.entity;

import com.teamA.hicardi.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private String email;

    private String name;

    @Builder
    public Member(String userId, String password, String email, String name) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }
}