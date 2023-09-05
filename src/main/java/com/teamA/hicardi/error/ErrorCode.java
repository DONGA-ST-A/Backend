package com.teamA.hicardi.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    MEMBER_NOT_FOUND(NOT_FOUND, "해당 회원을 찾을 수 없습니다"),
    ALREADY_LOGOUT_MEMBER(BAD_REQUEST, "이미 로그아웃한 회원입니다"),
    ALREADY_EXIST_EMAIL(BAD_REQUEST, "이미 존재하는 이메일입니다."),
    INVALID_TOKEN(UNAUTHORIZED, "잘못된 토큰입니다.");

    private final int code;
    private final String message;

    ErrorCode(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }
}
