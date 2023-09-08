package com.teamA.hicardi.domain.faq.dto.request;

import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.entity.Faq;
import jakarta.validation.constraints.NotBlank;

public record FaqSaveRequestDto(String category, @NotBlank(message = "질문은 필수 입력 값입니다.") String question, @NotBlank(message = "답변은 필수 입력 값입니다.") String answer) {

    public Faq toEntity(Category category, String question, String answer) {
        return Faq.builder()
                .category(category)
                .question(question)
                .answer(answer)
                .build();
    }
}
