package com.fiappostech.fastfood.domain.dto.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.fiappostech.fastfood.domain.dto.order.OrderRequest;
import com.fiappostech.fastfood.domain.entity.PaymentStatus;

public record PaymentRequest(
		UUID paymentId,
		UUID externalReference,
		OrderRequest order,
		LocalDateTime created,
		Boolean approved,
		PaymentStatus status,
		String detail,
		BigDecimal value) {
	public PaymentRequest(OrderRequest orderRequest) {
		this(null,
				null,
				orderRequest,
				LocalDateTime.now(),
				false,
				PaymentStatus.PENDING,
				"Waiting Payment Reply...",
				orderRequest.value());
	}
}