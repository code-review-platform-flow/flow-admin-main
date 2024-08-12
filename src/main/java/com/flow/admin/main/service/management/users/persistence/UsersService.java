package com.flow.admin.main.service.management.users.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.users.UsersDto;
import com.flow.admin.main.mapper.UsersMapper;
import com.flow.admin.main.repository.UsersRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {

	private final UsersRepository usersRepository;
	private final UsersMapper usersMapper;

	@Transactional
	public UsersDto save(UsersDto usersDto) {
		return usersMapper.toDto(usersRepository.save(usersMapper.toEntity(usersDto)));
	}

	public boolean existsByEmail(String email) {
		return usersRepository.existsByEmail(email);
	}

	@Transactional(readOnly = true)
	public UsersDto findByEmail(String email) {
		return usersMapper.toDto(usersRepository.findByEmail(email).orElseThrow(
			() -> new EntityNotFoundException("User not found with email : " + email)));
	}

	@Transactional(readOnly = true)
	public Long countAll() {
		return usersRepository.count();
	}

}
