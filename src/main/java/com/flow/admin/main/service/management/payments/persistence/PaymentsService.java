package com.flow.admin.main.service.management.payments.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.payments.PaymentsDto;
import com.flow.admin.main.entity.PaymentsEntity;
import com.flow.admin.main.mapper.PaymentsMapper;
import com.flow.admin.main.repository.PaymentsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentsService {

	private final PaymentsRepository paymentsRepository;
	private final PaymentsMapper paymentsMapper;

	@Transactional
	public PaymentsDto save(PaymentsDto paymentsDto) {
		PaymentsEntity payments = paymentsMapper.toEntity(paymentsDto);
		paymentsRepository.save(payments);
		return paymentsMapper.toDto(payments);
	}

	public Long count() {
		return paymentsRepository.count();
	}

}
