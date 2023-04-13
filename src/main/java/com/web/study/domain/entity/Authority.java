package com.web.study.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Authority {
	private int authority_id;
	private int user_id;
	private int role_id;
	private Role role;
}
