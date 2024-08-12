package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.payments.PaymentsDto;
import com.flow.admin.main.entity.PaymentsEntity;

@Mapper(componentModel = "spring")
public interface PaymentsMapper extends GenericMapper<PaymentsDto, PaymentsEntity> {

	@Mapping(target = "orderId", source = "order.orderId")
	PaymentsDto toDto(PaymentsEntity paymentsEntity);

	@Mapping(target = "order.orderId", source = "orderId")
	PaymentsEntity toEntity(PaymentsDto paymentsDto);

}
