package com.teamA.hicardi.domain.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.auth.dto.request.SignUpRequestDto;
import com.teamA.hicardi.domain.auth.service.AuthService;
import com.teamA.hicardi.utils.TestUserArgumentResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks
    private AuthController authController;
    @Mock
    private AuthService authService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController)
                .setCustomArgumentResolvers(new TestUserArgumentResolver())
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }


    @Test
    void 회원가입() throws Exception{
        //given
        SignUpRequestDto requestDto = new SignUpRequestDto("test", "password", "test@naver.com", "테스트");

        //when
        ResultActions result = mockMvc.perform(
                post("/auth/sign-up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto))
        );
        //then
        result.andExpect(status().isNoContent());
        verify(authService, times(1)).signUp(any());

    }

    @Test
    void 로그아웃() throws Exception {
        //given, when
        ResultActions result = mockMvc.perform(
                post("/auth/logout")
        );
        //then
        result.andExpect(status().isNoContent());
        verify(authService, times(1)).logout(any());
    }
}