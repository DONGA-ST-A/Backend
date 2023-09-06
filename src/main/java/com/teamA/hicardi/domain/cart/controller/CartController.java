package com.teamA.hicardi.domain.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teamA.hicardi.common.dto.ResponseDto;
import com.teamA.hicardi.domain.cart.service.CartService;
import com.teamA.hicardi.domain.cartItem.dto.CartItemAddRequestDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

	private final CartService cartService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> addCartItem(@RequestBody CartItemAddRequestDto cartItemAddRequestDto, @AuthenticationPrincipal UserDetails loginUser){
		cartService.addCartItem(cartItemAddRequestDto, loginUser.getUsername());
		return ResponseDto.noContent();
	}

}
