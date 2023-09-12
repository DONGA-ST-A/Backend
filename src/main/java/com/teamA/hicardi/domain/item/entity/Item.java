package com.teamA.hicardi.domain.item.entity;

import com.teamA.hicardi.common.entity.BaseTimeEntity;
import com.teamA.hicardi.domain.item.converter.SetTagConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Item extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    @Convert(converter = SetTagConverter.class)
    private EnumSet<Tag> tags;

    private String previewImage;

    private Integer price;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private SellStatus status;

    @Builder
    public Item(String title, String subtitle, EnumSet<Tag> tags, String previewImage, Integer price, Integer stock, SellStatus status) {
        this.title = title;
        this.subtitle = subtitle;
        this.tags = tags;
        this.previewImage = previewImage;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }
}
