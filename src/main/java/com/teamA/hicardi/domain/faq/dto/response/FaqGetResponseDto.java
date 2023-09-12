package com.teamA.hicardi.domain.faq.dto.response;

import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.entity.Faq;

public record FaqGetResponseDto(Long id, String category, String question, String answer) {

    public static FaqGetResponseDto from(Faq faq) {
        return new FaqGetResponseDto(faq.getId(), faq.getCategory().getDesc(), faq.getQuestion(), faq.getAnswer());
    }
}
