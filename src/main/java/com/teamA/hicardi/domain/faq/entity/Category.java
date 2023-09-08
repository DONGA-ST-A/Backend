package com.teamA.hicardi.domain.faq.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;

import java.util.stream.Stream;

public enum Category {
    BATTERY, EXERCISE;   // 추가 예정

    @JsonCreator
    public static Category create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.toString().equalsIgnoreCase(requestValue))
                .findFirst()
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_CATEGORY));
    }
}
