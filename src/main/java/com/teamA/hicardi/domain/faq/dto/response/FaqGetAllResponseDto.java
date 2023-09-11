package com.teamA.hicardi.domain.faq.dto.response;

import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.entity.Faq;

public record FaqGetAllResponseDto(Long id, Category category, String question, String answer) {

    public static FaqGetAllResponseDto from(Faq faq) {
        return new FaqGetAllResponseDto(faq.getId(), faq.getCategory(), faq.getQuestion(), faq.getAnswer());
    }
}
