package com.flow.admin.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flow.admin.main.entity.PaymentsEntity;

public interface PaymentsRepository extends JpaRepository<PaymentsEntity, Long> {
	long count();
}
