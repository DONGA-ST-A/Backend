package com.teamA.hicardi.domain.faq.repository;

import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.entity.Faq;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    Page<Faq> findAll(Pageable pageable);

    Page<Faq> findAllByCategory(Category category, Pageable pageable);

    @Query("select q from Faq q " +
            " where q.question Like %:search% or q.answer Like %:search% ")
    Page<Faq> findAllBySearch(@Param("search") String search, Pageable pageable);
}
