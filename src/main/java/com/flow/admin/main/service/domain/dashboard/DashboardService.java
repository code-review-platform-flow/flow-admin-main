package com.flow.admin.main.service.domain.dashboard;

import org.springframework.stereotype.Service;

import com.flow.admin.main.dto.controller.dashboard.DashboardResponseDto;
import com.flow.admin.main.service.management.payments.persistence.PaymentsService;
import com.flow.admin.main.service.management.users.persistence.UsersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DashboardService {

	private final UsersService usersService;
	private final PaymentsService paymentsService;

	public DashboardResponseDto getDashboard() {
		Long countAllByUser = usersService.countAll();
		Long countAllByPayment = paymentsService.count();

		DashboardResponseDto.ValueDto memberValue = DashboardResponseDto.ValueDto.builder()
			.value(countAllByUser)
			.build();

		DashboardResponseDto.ValueDto paymentValue = DashboardResponseDto.ValueDto.builder()
			.value(countAllByPayment)
			.build();

		DashboardResponseDto.ValueDto incomeValue = DashboardResponseDto.ValueDto.builder()
			.value(countAllByPayment * 2000)
			.build();

		return DashboardResponseDto.builder().member(memberValue).order(paymentValue).income(incomeValue).build();
	}

}
