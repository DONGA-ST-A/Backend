package com.teamA.hicardi.domain.cartItem.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemAddRequestDto {
	private Long itemId;
	private int count;

	@Builder
	public CartItemAddRequestDto(Long itemId, int count) {
		this.itemId = itemId;
		this.count = count;
	}
}
