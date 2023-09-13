package com.teamA.hicardi.domain.item.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.item.dto.response.ItemsGetResponseDto;
import com.teamA.hicardi.domain.item.dto.response.ItemGetResponseDto;
import com.teamA.hicardi.domain.item.service.ItemService;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;
    @Mock
    private ItemService itemService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(itemController)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    void 상품_목록_조회() throws Exception {
        //given
        PageRequest pageable = PageRequest.of(0, 5);
        List<ItemsGetResponseDto> dtos = new ArrayList<>();
        dtos.add(new ItemsGetResponseDto(1L, "하이카디플러스", "하이카디", Collections.singletonList("SmartPatch,DeviceBody"), "1.svg", 10000, 100, "SELL"));
        dtos.add(new ItemsGetResponseDto(1L, "하이카디플러스2", "하이카디2", Collections.singletonList("SmartPatch,DeviceBody"), "2.svg", 20000, 200, "SELL"));
        Page<ItemsGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

        //when
        given(itemService.getAllItems(any())).willReturn(response);
        ResultActions result = mockMvc.perform(
                get("/items")
        );

        //then
        result.andExpect(status().isOk());
        verify(itemService, times(1)).getAllItems(any());
    }

    @Test
    void 상품_상세_조회() throws Exception{
        List<String> images = new ArrayList<>();
        images.add("1.svg");
        images.add("2.svg");
        ItemGetResponseDto response = new ItemGetResponseDto(1L, "하이카디플러스", "하이카디", Collections.singletonList("SmartPatch,DeviceBody"), "1.svg", 10000, 100, "SELL", images);

        given(itemService.getItem(any())).willReturn(response);
        ResultActions result = mockMvc.perform(
            get("/items/1")
        );

        result.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
        verify(itemService, times(1)).getItem(any());
    }

    @Test
    void 상품_태그로_상품_조회() throws Exception {
        //given
        PageRequest pageable = PageRequest.of(0, 5);
        List<ItemsGetResponseDto> dtos = new ArrayList<>();
        dtos.add(new ItemsGetResponseDto(1L, "하이카디플러스", "하이카디", Collections.singletonList("SmartPatch,DeviceBody"), "1.svg", 10000, 100, "SELL"));
        dtos.add(new ItemsGetResponseDto(1L, "하이카디플러스2", "하이카디2", Collections.singletonList("SmartPatch,DeviceBody"), "2.svg", 20000, 200, "SELL"));
        Page<ItemsGetResponseDto> response = new PageImpl<>(dtos, pageable, 2);

        //when
        given(itemService.searchTagItems(anyString(), any())).willReturn(response);
        ResultActions result = mockMvc.perform(
                get("/items/tags")
                        .param("search", "Smart Patch")
        );

        //then
        result.andExpect(status().isOk());
        verify(itemService, times(1)).searchTagItems(anyString(), any());
    }
}