package com.teamA.hicardi.domain.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamA.hicardi.domain.notice.dto.response.NoticeGetResponseDto;
import com.teamA.hicardi.domain.notice.entity.Notice;
import com.teamA.hicardi.domain.notice.entity.NoticeCategory;
import com.teamA.hicardi.domain.notice.repository.NoticeRepository;
import com.teamA.hicardi.error.ErrorCode;
import com.teamA.hicardi.error.exception.custom.BusinessException;

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

	public Page<NoticeGetResponseDto> getCategoryNotices(String search, Pageable pageable) {
		NoticeCategory category = NoticeCategory.create(search);
		Page<Notice> notices = noticeRepository.findAllOrderedByIsTopAndCategory(category, pageable);
		Page<NoticeGetResponseDto> response = notices.map(f -> NoticeGetResponseDto.from(f));
		return response;
	}

	public Page<NoticeGetResponseDto> searchNotice(String search, Pageable pageable) {
		Page<Notice> notices = noticeRepository.findAllBySearch(search, pageable);
		Page<NoticeGetResponseDto> response = notices.map(f -> NoticeGetResponseDto.from(f));
		return response;
	}

	@Transactional
	public List<NoticeGetResponseDto> getNotice(Long noticeId) {

		Notice notice = noticeRepository.findById(noticeId)
			.orElseThrow(() -> new BusinessException(ErrorCode.NOTICE_NOT_FOUND));

		noticeRepository.updateView(noticeId);

		Notice previousNotice = noticeRepository.findPreviousNotice(noticeId);

		Notice nextNotice = noticeRepository.findNextNotice(noticeId);

		List<NoticeGetResponseDto> response = new ArrayList<>();

		if (previousNotice != null) {
			response.add(NoticeGetResponseDto.from(previousNotice));
		}else
			response.add(null);

		response.add(NoticeGetResponseDto.from(notice));

		if (nextNotice != null) {
			response.add(NoticeGetResponseDto.from(nextNotice));
		}else
			response.add(null);

		return response;
	}
}
