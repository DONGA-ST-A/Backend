package com.teamA.hicardi.domain.cartItem.dto;

import com.teamA.hicardi.domain.cart.entity.Cart;
import com.teamA.hicardi.domain.cartItem.entity.CartItem;
import com.teamA.hicardi.domain.item.entity.Item;

public record CartItemAddRequestDto (Long itemId, int count) {
	public CartItem toEntity(Cart cart, Item item) {
		return CartItem.builder()
			.cart(cart)
			.item(item)
			.count(count)
			.build();
	}
}
