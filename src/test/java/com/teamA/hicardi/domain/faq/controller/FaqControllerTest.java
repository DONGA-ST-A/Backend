package com.teamA.hicardi.domain.faq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.faq.dto.request.FaqSaveRequestDto;
import com.teamA.hicardi.domain.faq.dto.response.FaqGetResponseDto;
import com.teamA.hicardi.domain.faq.entity.Category;
import com.teamA.hicardi.domain.faq.service.FaqService;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class FaqControllerTest {

    @InjectMocks
    private FaqController faqController;
    @Mock
    private FaqService faqService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(faqController)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    void FAQ_생성() throws Exception {
        //given
        FaqSaveRequestDto requestDto = new FaqSaveRequestDto("BATTERY", "질문입니다.", "답변입니다.");

        //when
        ResultActions result = mockMvc.perform(
                post("/faqs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto))
        );

        //then
        result.andExpect(status().isNoContent());
        verify(faqService, times(1)).saveFaq(any());
    }

    @Test
    void FAQ_전체_조회() throws Exception {
        //given
        PageRequest pageable = PageRequest.of(0, 5);
        List<FaqGetResponseDto> dtos = new ArrayList<>();
        dtos.add(new FaqGetResponseDto(1L, "사용법", "사용 질문", "사용 대답"));
        dtos.add(new FaqGetResponseDto(2L, "기기", "기기 질문", "기기 대답"));
        Page<FaqGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

        //when
        given(faqService.getAllFaqs(any())).willReturn(response);
        ResultActions result = mockMvc.perform(
                get("/faqs")
        );

        //then
        result.andExpect(status().isOk());
        verify(faqService, times(1)).getAllFaqs(any());
    }


    @Test
    void FAQ_카테고리별_조회() throws Exception {
        //given
        PageRequest pageable = PageRequest.of(0, 5);
        List<FaqGetResponseDto> dtos = new ArrayList<>();
        dtos.add(new FaqGetResponseDto(1L, "사용법", "사용 질문1", "사용 대답1"));
        dtos.add(new FaqGetResponseDto(2L, "사용법", "사용 질문2", "사용 대답2"));
        Page<FaqGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

        //when
        given(faqService.getCategoryFaqs(anyString(), any())).willReturn(response);
        ResultActions result = mockMvc.perform(
                get("/faqs/category")
                        .param("search", "사용법")
        );

        //then
        result.andExpect(status().isOk());
        verify(faqService, times(1)).getCategoryFaqs(anyString(), any());
    }

    @Test
    void FAQ_키워드_검색() throws Exception {
        //given
        PageRequest pageable = PageRequest.of(0, 5);
        List<FaqGetResponseDto> dtos = new ArrayList<>();
        dtos.add(new FaqGetResponseDto(1L, "사용법", "배터리는 어떻게 교체하나요?", "하이카디 패치의 배터리는 교환이 불가능한 재충전식 내장배터리로 구성되어 있습니다. 방전 후 재충전을 하실 수 있는 충전기를 제공해 드립니다."));
        dtos.add(new FaqGetResponseDto(2L, "기기", "구매한 패치에 이상이 있습니다.", "패치에 이상이 있으실 경우 1대1 문의를 이용해 주세요."));
        Page<FaqGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

        //when
        given(faqService.searchFaq(anyString(), any())).willReturn(response);
        ResultActions result = mockMvc.perform(
                get("/faqs/keyword")
                        .param("search", "패치")
        );

        //then
        result.andExpect(status().isOk());
        verify(faqService, times(1)).searchFaq(anyString(), any());
    }

}