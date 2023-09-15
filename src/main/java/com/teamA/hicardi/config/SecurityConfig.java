package com.teamA.hicardi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamA.hicardi.domain.auth.filter.CustomJsonAuthenticationFilter;
import com.teamA.hicardi.domain.auth.handler.LoginFailureHandler;
import com.teamA.hicardi.domain.auth.handler.LoginSuccessHandler;
import com.teamA.hicardi.domain.auth.service.LoginService;
import com.teamA.hicardi.domain.member.repository.MemberRepository;
import com.teamA.hicardi.jwt.JwtAccessDeniedHandler;
import com.teamA.hicardi.jwt.JwtAuthenticationEntryPoint;
import com.teamA.hicardi.jwt.filter.JwtAuthenticationProcessingFilter;
import com.teamA.hicardi.jwt.service.JwtService;
import com.teamA.hicardi.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    private final ObjectMapper objectMapper;
    private final LoginService loginService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final RedisUtil redisUtil;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
        http
                .formLogin(formLogin -> formLogin.disable())
                .httpBasic(httpBasic -> httpBasic.disable())
                .csrf(csrf -> csrf.disable())
                .cors(withDefaults())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request ->
                        request.requestMatchers(mvcMatcherBuilder.pattern("/auth/login")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/auth/sign-up")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/h2-console/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/css/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/js/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/images/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/error")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/favicon.ico")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/swagger-ui/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/swagger-resources/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/v3/api-docs/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/faqs/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/items/**")).permitAll()
                                .requestMatchers(mvcMatcherBuilder.pattern("/notices/**")).permitAll()
                                .anyRequest().authenticated())
                .addFilterAfter(customJsonUsernamePasswordAuthenticationFilter(), LogoutFilter.class)
                .addFilterBefore(jwtAuthenticationProcessingFilter(), CustomJsonAuthenticationFilter.class)
                .exceptionHandling(exception -> exception.accessDeniedHandler(jwtAccessDeniedHandler)
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(loginService);
        return new ProviderManager(provider);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler(jwtService, memberRepository);
    }

    @Bean
    public LoginFailureHandler loginFailureHandler() {
        return new LoginFailureHandler();
    }

    @Bean
    public CustomJsonAuthenticationFilter customJsonUsernamePasswordAuthenticationFilter() {
        CustomJsonAuthenticationFilter customJsonUsernamePasswordLoginFilter
                = new CustomJsonAuthenticationFilter(objectMapper);
        customJsonUsernamePasswordLoginFilter.setAuthenticationManager(authenticationManager());
        customJsonUsernamePasswordLoginFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
        customJsonUsernamePasswordLoginFilter.setAuthenticationFailureHandler(loginFailureHandler());
        return customJsonUsernamePasswordLoginFilter;
    }

    @Bean
    public JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() {
        JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter = new JwtAuthenticationProcessingFilter(jwtService, memberRepository, redisUtil);
        return jwtAuthenticationProcessingFilter;
    }
}