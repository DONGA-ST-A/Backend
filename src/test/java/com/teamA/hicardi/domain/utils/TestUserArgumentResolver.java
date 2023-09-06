package com.teamA.hicardi.domain.utils;

import static org.mockito.BDDMockito.*;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class TestUserArgumentResolver implements HandlerMethodArgumentResolver {
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().equals(UserDetails.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		UserDetails userDetails = mock(UserDetails.class);
		given(userDetails.getUsername()).willReturn("userId");
		return userDetails;
	}
}
