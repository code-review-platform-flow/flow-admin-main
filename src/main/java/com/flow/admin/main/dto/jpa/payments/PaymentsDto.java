package com.flow.admin.main.dto.jpa.payments;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsDto {

	private Long paymentId;
	private Long orderId;
	private BigDecimal amount;
	private String paymentKey;
	private String status;

}
