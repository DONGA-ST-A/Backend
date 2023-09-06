package com.teamA.hicardi.domain.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamA.hicardi.domain.cart.entity.Cart;
import com.teamA.hicardi.domain.member.entity.Member;

public interface CartRepository extends JpaRepository<Cart, Long> {
	Boolean existsCartByMember_Id(Long memberId);
	Optional<Cart> findCartByMember_Id(Long memberId);
}
