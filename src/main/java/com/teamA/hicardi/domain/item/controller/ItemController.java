package com.teamA.hicardi.domain.item.controller;

import com.teamA.hicardi.common.dto.PageResponseDto;
import com.teamA.hicardi.domain.item.dto.response.ItemGetAllResponseDto;
import com.teamA.hicardi.domain.item.dto.response.ItemGetResponseDto;
import com.teamA.hicardi.domain.item.service.ItemService;
import com.teamA.hicardi.error.dto.ErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Operation(summary = "상품 목록 조회", description = "상품 목록을 조회합니다.",
            security = { @SecurityRequirement(name = "bearer-key") },
            responses = {
                    @ApiResponse(responseCode = "200", description = "상품 목록 조회 성공")
            })
    @GetMapping
    public ResponseEntity<PageResponseDto> getAllItems(Pageable pageable) {
        Page<ItemGetAllResponseDto> response = itemService.getAllItems(pageable);
        return PageResponseDto.of(response);
    }

    @Operation(summary = "상품 상세 조회", description = "상품을 조회합니다.",
        security = { @SecurityRequirement(name = "bearer-key") },
        responses = {
            @ApiResponse(responseCode = "200", description = "상품 상세 조회 성공"),
            @ApiResponse(responseCode = "404", description = "해당 상품을 찾을 수 없습니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
        })
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemGetResponseDto> getItem(@PathVariable Long itemId){
        ItemGetResponseDto itemGetResponseDto = itemService.getItem(itemId);
        return ResponseEntity.ok(itemGetResponseDto);
    }
}
