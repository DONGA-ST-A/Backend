package com.teamA.hicardi.domain.item.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SellStatus {
    SELL("판매중"), SOLD_OUT("품절");

    private final String desc;
}
