package com.teamA.hicardi.domain.notice.dto.response;

import java.time.LocalDate;

import com.teamA.hicardi.domain.notice.entity.Notice;

public record NoticeGetResponseDto(Long id, String category, String title, String content, String file, Boolean isTop, LocalDate createdDate) {

	public static NoticeGetResponseDto from(Notice notice) {
		return new NoticeGetResponseDto(notice.getId(), notice.getCategory().getDesc(), notice.getTitle(), notice.getContent(), notice.getFile(), notice.getIsTop(), notice.getCreatedDate().toLocalDate());
	}
}
