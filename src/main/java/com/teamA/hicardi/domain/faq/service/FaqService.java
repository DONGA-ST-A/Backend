package com.teamA.hicardi.domain.faq.service;

import com.teamA.hicardi.domain.faq.dto.request.FaqSaveRequestDto;
import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.entity.Faq;
import com.teamA.hicardi.domain.faq.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public void saveFaq(FaqSaveRequestDto requestDto) {
        Category category = Category.create(requestDto.category());
        Faq faq = requestDto.toEntity(category, requestDto.question(), requestDto.answer());
        faqRepository.save(faq);
    }
}
