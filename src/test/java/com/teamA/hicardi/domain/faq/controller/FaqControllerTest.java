package com.teamA.hicardi.domain.faq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.faq.dto.request.FaqSaveRequestDto;
import com.teamA.hicardi.domain.faq.service.FaqService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
                .build();
    }

    @Test
    void FAQ_생성() throws Exception {
        //given
        FaqSaveRequestDto requestDto = new FaqSaveRequestDto("BATTERY", "질문입니다.", "답변입니다.");

        //when
        ResultActions result = mockMvc.perform(
                post("/faq")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto))
        );

        //then
        result.andExpect(status().isNoContent());
        verify(faqService, times(1)).saveFaq(any());
    }
}