package com.flow.admin.main.dto.controller.user;

import java.time.LocalDateTime;

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
public class UserRequestDto {
	private String searchDateType;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String status;
	private String searchType;
	private String searchText;
}
