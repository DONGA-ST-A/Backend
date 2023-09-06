package com.teamA.hicardi.domain.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamA.hicardi.domain.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
