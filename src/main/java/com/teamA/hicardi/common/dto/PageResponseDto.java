package com.teamA.hicardi.common.dto;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public record PageResponseDto<T>(
        List<T> content,
        long totalElements,
        int totalPages,
        int pageNumber,
        int numberOfElements,
        boolean hasNextPages
) {

    public static <T> ResponseEntity<PageResponseDto> of(Page<T> page) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(new PageResponseDto<>(
                        page.getContent(),
                        page.getTotalElements(),
                        page.getTotalPages(),
                        page.getNumber(),
                        page.getNumberOfElements(),
                        page.hasNext()
                ));
    }
}