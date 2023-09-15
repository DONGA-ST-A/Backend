package com.teamA.hicardi.domain.notice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.notice.dto.response.NoticeGetResponseDto;
import com.teamA.hicardi.domain.notice.service.NoticeService;

@ExtendWith(MockitoExtension.class)
public class NoticeControllerTest {
	@InjectMocks
	private NoticeController noticeController;
	@Mock
	private NoticeService noticeService;
	private ObjectMapper objectMapper = new ObjectMapper();
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(noticeController)
			.addFilter(new CharacterEncodingFilter("UTF-8", true))
			.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
			.build();
	}

	@Test
	void 공지사항_전체_조회() throws Exception {
		PageRequest pageable = PageRequest.of(0, 5);
		List<NoticeGetResponseDto> dtos = new ArrayList<>();
		dtos.add(new NoticeGetResponseDto(1L, "NEWS", "뉴스", "내용1", "첨부파일1", false, LocalDate.now()));
		dtos.add(new NoticeGetResponseDto(2L, "DATA", "자료", "내용2", "첨부파일2", true, LocalDate.now()));
		Page<NoticeGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

		given(noticeService.getAllNotices(any())).willReturn(response);
		ResultActions result = mockMvc.perform(
			get("/notices")
		);

		result.andExpect(status().isOk());
		verify(noticeService, times(1)).getAllNotices(any());
	}

	@Test
	void 공지사항_카테고리별_조회() throws Exception {
		PageRequest pageable = PageRequest.of(0, 5);
		List<NoticeGetResponseDto> dtos = new ArrayList<>();
		dtos.add(new NoticeGetResponseDto(1L, "NEWS", "뉴스", "내용1", "첨부파일1", false, LocalDate.now()));
		dtos.add(new NoticeGetResponseDto(2L, "DATA", "자료", "내용2", "첨부파일2", true, LocalDate.now()));
		Page<NoticeGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

		given(noticeService.getCategoryNotices(anyString(), any())).willReturn(response);
		ResultActions result = mockMvc.perform(
			get("/notices/category")
				.param("search", "자료")
		);

		result.andExpect(status().isOk());
		verify(noticeService, times(1)).getCategoryNotices(anyString(), any());
	}
}
