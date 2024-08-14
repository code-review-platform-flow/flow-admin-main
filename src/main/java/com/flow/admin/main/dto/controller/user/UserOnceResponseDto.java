package com.flow.admin.main.dto.controller.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserOnceResponseDto {
	private String email;
	private String userName;
	private String schoolName;
	private String schoolNumber;
	private String majorName;
}
