package com.teamA.hicardi.domain.item.repository;

import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.entity.ItemTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTagRepository extends JpaRepository<ItemTag, Long> {

    List<ItemTag> findAllByItem(Item item);
}