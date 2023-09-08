package com.teamA.hicardi.domain.auth.controller;

import com.teamA.hicardi.common.dto.ResponseDto;
import com.teamA.hicardi.domain.auth.dto.request.SignUpRequestDto;
import com.teamA.hicardi.domain.auth.service.AuthService;
import com.teamA.hicardi.error.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "회원가입", description = "회원가입을 합니다.",
            responses = {@ApiResponse(responseCode = "204", description = "회원가입 성공")
                    , @ApiResponse(responseCode = "400", description = "1. 이미 존재하는 아이디입니다. \t\n 2. 이미 존재하는 이메일입니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequestDto signUpRequestDto) {
        authService.signUp(signUpRequestDto);
        return ResponseDto.noContent();
    }

    @Operation(summary = "로그아웃", description = "로그아웃 후 사용자의 토큰을 블랙리스트에 등록합니다.", security = { @SecurityRequirement(name = "bearer-key") },
            responses = {
                    @ApiResponse(responseCode = "204", description = "로그아웃 성공")
                    , @ApiResponse(responseCode = "401", description = "잘못된 토큰입니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
                    , @ApiResponse(responseCode = "404", description = "해당 회원을 찾을 수 없습니다.", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
            })
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        authService.logout(request);
        return ResponseDto.noContent();
    }
}
