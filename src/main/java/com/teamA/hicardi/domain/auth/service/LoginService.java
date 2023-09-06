package com.teamA.hicardi.domain.auth.service;

import com.teamA.hicardi.domain.member.entity.Member;
import com.teamA.hicardi.domain.member.repository.MemberRepository;
import com.teamA.hicardi.error.exception.custom.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.teamA.hicardi.error.ErrorCode.MEMBER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserId(userId).orElseThrow(() -> new BusinessException(MEMBER_NOT_FOUND));

        return org.springframework.security.core.userdetails.User.builder()
                .username(member.getUserId())
                .password(member.getPassword())
                .build();
    }
}
