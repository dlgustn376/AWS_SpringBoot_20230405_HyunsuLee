package com.web.study.dto.response.auth;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class JwtTokenRespDto {
	private String grantType;
	private String accessToken;
}
