package com.teamA.hicardi.domain.notice.entity;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeCategory {
	NECESSARY("필독"), UPDATE("업데이트"), DATA("자료"), NEWS("언론 보도");

	@JsonCreator
	public static NoticeCategory create(String requestValue) {
		return Stream.of(values())
			.filter(v -> v.desc.equalsIgnoreCase(requestValue))
			.findFirst()
			.orElseThrow(() -> new BusinessException(ErrorCode.INVALID_CATEGORY));
	}

	private final String desc;
}
