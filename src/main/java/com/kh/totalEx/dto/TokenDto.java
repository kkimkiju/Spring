package com.kh.totalEx.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long tokenExpiresIn;
    private String refreshToken; //리프레시 토큰
    private Long refreshTokenExpiresIn; //리프레시 토큰 만료 시간
}
