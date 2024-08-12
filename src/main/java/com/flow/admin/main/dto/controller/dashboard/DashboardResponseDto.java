package com.flow.admin.main.dto.controller.dashboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponseDto {
	private ValueDto member;
	private ValueDto order;
	private ValueDto income;

	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ValueDto {
		private Long value;
	}

}
