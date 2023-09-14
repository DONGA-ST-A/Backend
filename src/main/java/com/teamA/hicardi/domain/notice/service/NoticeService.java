package com.teamA.hicardi.domain.notice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamA.hicardi.domain.faq.dto.response.FaqGetResponseDto;
import com.teamA.hicardi.domain.faq.entity.Faq;
import com.teamA.hicardi.domain.notice.dto.response.NoticeGetResponseDto;
import com.teamA.hicardi.domain.notice.entity.Notice;
import com.teamA.hicardi.domain.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class NoticeService {

	private final NoticeRepository noticeRepository;
	public Page<NoticeGetResponseDto> getAllNotices(Pageable pageable) {
		Page<Notice> notices = noticeRepository.findAllOrderedByIsTopAndCreateDate(pageable);
		Page<NoticeGetResponseDto> response = notices.map(f -> NoticeGetResponseDto.from(f));
		return response;
	}
}
