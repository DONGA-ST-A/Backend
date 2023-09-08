package com.teamA.hicardi.domain.faq.controller;

import com.teamA.hicardi.common.dto.ResponseDto;
import com.teamA.hicardi.domain.faq.dto.request.FaqSaveRequestDto;
import com.teamA.hicardi.domain.faq.service.FaqService;
import com.teamA.hicardi.error.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faq")
public class FaqController {

    private final FaqService faqService;

    @Operation(summary = "FAQ 저장", description = "FAQ를 저장합니다.",
            security = { @SecurityRequirement(name = "bearer-key") },
            responses = {
                    @ApiResponse(responseCode = "204", description = "FAQ 저장 성공")
                    , @ApiResponse(responseCode = "400", description = "1. 잘못된 카테고리입니다. \t\n 2. 질문은 필수 입력 값입니다. \t\n 3. 답변은 필수 입력 값입니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    @PostMapping
    public ResponseEntity<Void> saveFaq(@RequestBody @Valid FaqSaveRequestDto requestDto) {
        faqService.saveFaq(requestDto);
        return ResponseDto.noContent();
    }


}
