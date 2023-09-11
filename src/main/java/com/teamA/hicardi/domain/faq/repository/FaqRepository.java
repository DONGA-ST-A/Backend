package com.teamA.hicardi.domain.faq.repository;

import com.teamA.hicardi.domain.faq.entity.Faq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    Page<Faq> findAll(Pageable pageable);
}
