package com.teamA.hicardi.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    MEMBER_NOT_FOUND(NOT_FOUND, "해당 회원을 찾을 수 없습니다."),
    ALREADY_LOGOUT_MEMBER(BAD_REQUEST, "이미 로그아웃한 회원입니다."),
    ALREADY_EXIST_EMAIL(BAD_REQUEST, "이미 존재하는 이메일입니다."),
    ALREADY_EXIST_USERID(BAD_REQUEST, "이미 존재하는 아이디입니다."),
    INVALID_FILE_UPLOAD(BAD_REQUEST, "파일 업로드에 실패하였습니다."),
    INVALID_CATEGORY(BAD_REQUEST, "잘못된 카테고리입니다."),
    INVALID_TAG(BAD_REQUEST, "잘못된 태그입니다."),
    WRONG_CATEGORY(BAD_REQUEST, "카테고리를 입력해야 합니다."),
    WRONG_SEARCH(BAD_REQUEST, "검색어를 입력해야 합니다."),
    INVALID_TOKEN(UNAUTHORIZED, "잘못된 토큰입니다."),
    CART_NOT_FOUND(NOT_FOUND, "해당 장바구니를 찾을 수 없습니다."),
    ITEM_NOT_FOUND(NOT_FOUND, "해당 상품을 찾을 수 없습니다."),
    NOTICE_NOT_FOUND(NOT_FOUND, "해당 공지사항을 찾을 수 없습니다.");



    private final int code;
    private final String message;

    ErrorCode(HttpStatus code, String message) {
        this.code = code.value();
        this.message = message;
    }
}
