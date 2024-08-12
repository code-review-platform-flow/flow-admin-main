package com.flow.admin.main.service.management.userinfo.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.userinfo.UserInfoDto;
import com.flow.admin.main.entity.UserInfoEntity;
import com.flow.admin.main.mapper.UserInfoMapper;
import com.flow.admin.main.repository.UserInfoRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;
	private final UserInfoMapper userInfoMapper;

	@Transactional
	public UserInfoDto save(UserInfoDto userInfoDto) {
		UserInfoEntity userInfoEntity = userInfoMapper.toEntity(userInfoDto);
		return userInfoMapper.toDto(userInfoRepository.save(userInfoEntity));
	}

	@Transactional(readOnly = true)
	public UserInfoDto findByUserId(Long userId) {
		return userInfoMapper.toDto(userInfoRepository.findByUserId(userId).orElseThrow(
			() -> new EntityNotFoundException("UserInfo not found with userI : " + userId)
		));
	}

}
