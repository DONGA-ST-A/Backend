package com.teamA.hicardi.domain.faq.service;

import com.teamA.hicardi.domain.faq.dto.request.FaqSaveRequestDto;
import com.teamA.hicardi.domain.faq.dto.response.FaqGetResponseDto;
import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.entity.Faq;
import com.teamA.hicardi.domain.faq.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<FaqGetResponseDto> getAllFaqs(Pageable pageable) {
        Page<Faq> faqs = faqRepository.findAll(pageable);
        Page<FaqGetResponseDto> response = faqs.map(f -> FaqGetResponseDto.from(f));
        return response;
    }

    public Page<FaqGetResponseDto> getCategoryFaqs(String search, Pageable pageable) {
        Category category = Category.create(search);
        Page<Faq> faqs = faqRepository.findAllByCategory(category, pageable);
        Page<FaqGetResponseDto> response = faqs.map(f -> FaqGetResponseDto.from(f));
        return response;
    }
}
