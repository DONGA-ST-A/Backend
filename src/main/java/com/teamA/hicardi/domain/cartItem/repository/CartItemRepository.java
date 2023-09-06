package com.teamA.hicardi.domain.cartItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamA.hicardi.domain.cartItem.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
