package com.flow.admin.main.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flow.admin.main.dto.controller.user.UserResponseDto;
import com.flow.admin.main.service.domain.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<UserResponseDto> views(Pageable pageable) {
		return ResponseEntity.ok().body(userService.getUser(pageable));
	}

}
