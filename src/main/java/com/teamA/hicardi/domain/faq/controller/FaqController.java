package com.teamA.hicardi.domain.faq.controller;

import com.teamA.hicardi.common.dto.PageResponseDto;
import com.teamA.hicardi.common.dto.ResponseDto;
import com.teamA.hicardi.domain.faq.dto.request.FaqSaveRequestDto;
import com.teamA.hicardi.domain.faq.dto.response.FaqGetAllResponseDto;
import com.teamA.hicardi.domain.faq.service.FaqService;
import com.teamA.hicardi.error.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faqs")
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

    @Operation(summary = "FAQ 전체 조회", description = "FAQ 전체를 조회합니다.",
            security = { @SecurityRequirement(name = "bearer-key") },
            responses = {
                    @ApiResponse(responseCode = "200", description = "FAQ 전체 조회 성공")
            })
    @GetMapping
    public ResponseEntity<PageResponseDto> getAllFaqs(Pageable pageable) {
        Page<FaqGetAllResponseDto> response = faqService.getAllFaqs(pageable);
        return PageResponseDto.of(response);
    }

}
