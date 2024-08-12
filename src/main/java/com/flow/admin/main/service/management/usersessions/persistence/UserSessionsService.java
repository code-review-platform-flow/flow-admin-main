package com.flow.admin.main.service.management.usersessions.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.usersessions.UserSessionsDto;
import com.flow.admin.main.entity.UserSessionsEntity;
import com.flow.admin.main.mapper.UserSessionsMapper;
import com.flow.admin.main.mapper.UsersMapper;
import com.flow.admin.main.repository.UserSessionsRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSessionsService {

	private final UserSessionsRepository userSessionsRepository;
	private final UserSessionsMapper userSessionsMapper;
	private final UsersMapper usersMapper;

	@Transactional
	public UserSessionsDto save(UserSessionsDto userSessionsDto) {
		UserSessionsEntity userSessionsEntity = userSessionsMapper.toEntity(userSessionsDto);
		return userSessionsMapper.toDto(userSessionsRepository.save(userSessionsEntity));
	}

	public UserSessionsDto existsByUserId(Long userId) {
		boolean check = userSessionsRepository.existsByUserId(userId);
		if (!check)
			return UserSessionsDto.builder().build();
		else
			return findByUserId(userId);
	}

	@Transactional(readOnly = true)
	public UserSessionsDto findByUserId(Long userId) {
		return userSessionsMapper.toDto(userSessionsRepository.findByUserId(userId)
			.orElseThrow(() -> new EntityNotFoundException("UserSessions not found with userId : " + userId)));
	}

	@Transactional(readOnly = true)
	public UserSessionsDto findByRefreshToken(String refreshToken) {
		return userSessionsMapper.toDto(userSessionsRepository.findByRefreshToken(refreshToken)
			.orElseThrow(
				() -> new EntityNotFoundException("UserSessions not found with refreshToken : " + refreshToken)));
	}
}
