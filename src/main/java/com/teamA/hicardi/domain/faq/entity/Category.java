package com.teamA.hicardi.domain.faq.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Category {
    USE("사용법"), DELIVERY("배송"), DEVICE("기기"), ETC("기타");

    @JsonCreator
    public static Category create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.desc.equalsIgnoreCase(requestValue))
                .findFirst()
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_CATEGORY));
    }

    private final String desc;
}
