package com.teamA.hicardi.domain.cart.controller;

import static org.mockito.Mockito.*;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.cart.service.CartService;
import com.teamA.hicardi.domain.cartItem.dto.CartItemAddRequestDto;
import com.teamA.hicardi.domain.utils.TestUserArgumentResolver;

@ExtendWith(MockitoExtension.class)
class CartControllerTest {

	@InjectMocks
	private CartController cartController;

	@Mock
	private CartService cartService;
	private ObjectMapper objectMapper = new ObjectMapper();

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(cartController)
			.setCustomArgumentResolvers(new TestUserArgumentResolver())
			.addFilter(new CharacterEncodingFilter("UTF-8", true))
			.build();
	}

	@Test
	@DisplayName("장바구니 상품 추가 성공")
	void cartItemAddSuccess() throws Exception {
		CartItemAddRequestDto cartItemAddRequestDto = CartItemAddRequestDto.builder()
			.itemId(1L)
			.count(1)
			.build();

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/cart/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(cartItemAddRequestDto))
			);

			result.andExpect(MockMvcResultMatchers.status().isNoContent());
			verify(cartService, times(1)).addCartItem(any(), anyString());

	}

}