package com.teamA.hicardi.domain.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeCategory {
	NECESSARY("필독"), UPDATE("업데이트"), DATA("자료"), NEWS("언론 보도");

	private final String desc;
}
