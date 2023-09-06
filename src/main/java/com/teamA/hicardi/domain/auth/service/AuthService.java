package com.teamA.hicardi.domain.auth.service;

import com.teamA.hicardi.domain.auth.dto.request.SignUpRequestDto;
import com.teamA.hicardi.domain.member.entity.Member;
import com.teamA.hicardi.domain.member.repository.MemberRepository;
import com.teamA.hicardi.error.exception.custom.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.teamA.hicardi.error.ErrorCode.ALREADY_EXIST_EMAIL;
import static com.teamA.hicardi.error.ErrorCode.ALREADY_EXIST_USERID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(SignUpRequestDto signUpRequestDto) {

        if (memberRepository.existsByUserId(signUpRequestDto.userId())) {
            throw new BusinessException(ALREADY_EXIST_USERID);
        }

        if (memberRepository.existsByEmail(signUpRequestDto.email())) {
            throw new BusinessException(ALREADY_EXIST_EMAIL);
        }

        Member member = signUpRequestDto.toEntity();
        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
    }
}