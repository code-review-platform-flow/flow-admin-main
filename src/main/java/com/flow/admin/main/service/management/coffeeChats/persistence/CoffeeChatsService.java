package com.flow.admin.main.service.management.coffeeChats.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.coffeeChats.CoffeeChatsDto;
import com.flow.admin.main.entity.CoffeeChatsEntity;
import com.flow.admin.main.mapper.CoffeeChatsMapper;
import com.flow.admin.main.repository.CoffeeChatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeChatsService {

	private final CoffeeChatsRepository coffeeChatsRepository;
	private final CoffeeChatsMapper coffeeChatsMapper;

	@Transactional(readOnly = true)
	public List<CoffeeChatsDto> getAllByInitiatorUserIdWithPageable(Long initiatorUserId, Pageable pageable) {
		return coffeeChatsMapper.toListDto(
			coffeeChatsRepository.findAllCoffeeChatsByInitiatorUserIdWithPageable(initiatorUserId, pageable));
	}

	@Transactional
	public CoffeeChatsDto save(CoffeeChatsDto coffeeChatsDto) {
		CoffeeChatsEntity coffeeChatsEntity = coffeeChatsMapper.toEntity(coffeeChatsDto);
		coffeeChatsRepository.save(coffeeChatsEntity);
		return coffeeChatsMapper.toDto(coffeeChatsEntity);
	}

}
