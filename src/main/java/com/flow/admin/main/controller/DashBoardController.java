package com.flow.admin.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flow.admin.main.dto.controller.dashboard.DashboardResponseDto;
import com.flow.admin.main.service.domain.dashboard.DashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/dashboard")
@RequiredArgsConstructor
public class DashBoardController {

	private final DashboardService dashboardService;

	@GetMapping
	public ResponseEntity<DashboardResponseDto> views() {
		return ResponseEntity.ok().body(dashboardService.getDashboard());
	}

}
