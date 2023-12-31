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
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartService {

	private final CartRepository cartRepository;

	private final CartItemRepository cartItemRepository;

	private final MemberRepository memberRepository;

	private final ItemRepository itemRepository;

	@Transactional
	public void addCartItem(CartItemAddRequestDto cartItemAddRequestDto, String userId) {

		Member findMember =  memberRepository.findByUserId(userId)
			.orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));

		Long memberId = findMember.getId();

		boolean existsCart = cartRepository.existsCartByMemberId(memberId);

		// 장바구니가 존재하지 않을때 장바구니 생성
		if(!existsCart){
			cartRepository.save(
				Cart.builder()
					.member(findMember)
					.build());
		}

		// 해당 회원의 장바구니를 가져와서 상품을 추가
		Cart findCart = cartRepository.findByMemberId(memberId)
			.orElseThrow(() -> new BusinessException(ErrorCode.CART_NOT_FOUND));
		Item findItem = itemRepository.findById(cartItemAddRequestDto.itemId())
			.orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND));

		CartItem cartItem = cartItemAddRequestDto.toEntity(findCart, findItem);

		cartItemRepository.save(cartItem);
	}

}
