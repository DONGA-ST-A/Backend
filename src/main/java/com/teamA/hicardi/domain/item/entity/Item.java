package com.teamA.hicardi.domain.item.entity;

import com.teamA.hicardi.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;     // 추후 수정

    private Integer price;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private SellStatus status;

    @Builder
    public Item(String content, Integer price, Integer stock, SellStatus status) {
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }
}
