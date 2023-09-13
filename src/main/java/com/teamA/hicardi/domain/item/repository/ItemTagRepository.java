package com.teamA.hicardi.domain.item.repository;

import com.teamA.hicardi.domain.item.entity.Item;
import com.teamA.hicardi.domain.item.entity.ItemTag;
import com.teamA.hicardi.domain.item.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemTagRepository extends JpaRepository<ItemTag, Long> {

    List<ItemTag> findAllByItem(Item item);

    @Query("select distinct i.item from ItemTag i " +
            " where i.tag = :tag")
    Page<Item> findAllByTag(@Param("tag") Tag tag, Pageable pageable);
}