package com.teamA.hicardi.domain.item.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Tag {
    SmartPatch("Smart Patch"),
    DeviceBody("기기 본체"),
    HicardiOnly("하이카디 전용"),
    AdditionalItem("추가 용품"),
    HicardiPlusOnly("하이카디 플러스, 하이카디플러스 H100 전용"),
    OxygenMeasurement("산소포화도 측정"),
    RemoteReading("원격 판독"),
    AdditionalService("추가 서비스"),
    SmartPhone("스마트폰");

    private final String desc;

    @JsonCreator
    public static Tag create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.toString().equalsIgnoreCase(requestValue))
                .findFirst()
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_TAG));
    }
}
