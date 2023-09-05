package com.teamA.hicardi.domain.auth.dto.request;

import com.teamA.hicardi.domain.member.entity.Member;

public record SignUpRequestDto(String userId, String password, String email, String name) {

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .name(name)
                .build();
    }
}
