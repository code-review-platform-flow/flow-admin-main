package com.flow.admin.main.dto.controller.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;

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
public class UserResponseDto {

	private List<DataDto> data;
	private Pageable page;

	@Getter
	@Builder
	@EqualsAndHashCode
	@AllArgsConstructor
	@NoArgsConstructor
	public static class DataDto {
		private Long userId;
		private String email;
		private String userName;
		private String schoolName;
		private String schoolNumber;
		private String majorName;
		private Boolean status;
		private String role;
		private LocalDateTime createDate;
		private LocalDateTime modifyDate;
	}

}
