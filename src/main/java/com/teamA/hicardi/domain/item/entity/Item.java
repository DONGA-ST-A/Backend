package com.teamA.hicardi.domain.item.entity;

import com.teamA.hicardi.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String subname;

    private String previewImage;

    private Integer price;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private SellStatus status;

    @Builder
    public Item(String name, String subname, String previewImage, Integer price, Integer stock, SellStatus status) {
        this.name = name;
        this.subname = subname;
        this.previewImage = previewImage;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }
}
