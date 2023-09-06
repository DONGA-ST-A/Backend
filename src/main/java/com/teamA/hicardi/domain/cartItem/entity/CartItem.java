package com.teamA.hicardi.domain.cartItem.entity;

import com.teamA.hicardi.common.entity.BaseTimeEntity;
import com.teamA.hicardi.domain.cart.entity.Cart;
import com.teamA.hicardi.domain.item.entity.Item;
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
public class CartItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;

    private Integer count;

    @Builder
    public CartItem(Cart cart, Item item, Integer count) {
        this.cart = cart;
        this.item = item;
        this.count = count;
    }
}
