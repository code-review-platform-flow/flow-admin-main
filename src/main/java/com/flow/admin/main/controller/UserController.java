package com.flow.admin.main.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flow.admin.main.dto.controller.user.UserRequestDto;
import com.flow.admin.main.dto.controller.user.UserResponseDto;
import com.flow.admin.main.service.domain.user.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<UserResponseDto> views(Pageable pageable,
		@RequestParam(required = false) String searchDateType,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
		@RequestParam(required = false) String status,
		@RequestParam(required = false) String searchType,
		@RequestParam(required = false) String searchText) {

		LocalDateTime startDateTime = startDate != null ? startDate.atStartOfDay() : null;
		LocalDateTime endDateTime = endDate != null ? endDate.atTime(LocalTime.MAX) : null;

		UserRequestDto userRequestDto = UserRequestDto.builder()
			.searchDateType(searchDateType)
			.startDate(startDateTime)
			.endDate(endDateTime)
			.status(status)
			.searchType(searchType)
			.searchText(searchText)
			.build();

		return ResponseEntity.ok().body(userService.getUser(pageable, userRequestDto));
	}

}
