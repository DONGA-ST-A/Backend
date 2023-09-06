package com.teamA.hicardi.domain.cart.service;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamA.hicardi.domain.cart.entity.Cart;
import com.teamA.hicardi.domain.cart.repository.CartRepository;
import com.teamA.hicardi.domain.cartItem.dto.CartItemAddRequestDto;
import com.teamA.hicardi.domain.cartItem.entity.CartItem;
import com.teamA.hicardi.domain.cartItem.repository.CartItemRepository;
import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.repository.ItemRepository;
import com.teamA.hicardi.domain.member.entity.Member;
import com.teamA.hicardi.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {

	private final CartRepository cartRepository;

	private final CartItemRepository cartItemRepository;

	private final MemberRepository memberRepository;

	private final ItemRepository itemRepository;

}
