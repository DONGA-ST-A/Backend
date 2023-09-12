package com.teamA.hicardi.domain.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamA.hicardi.domain.item.entity.ItemImage;

public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {
	List<ItemImage> findItemImagesByItemId(Long itemId);
}
