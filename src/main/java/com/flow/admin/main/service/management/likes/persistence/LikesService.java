package com.flow.admin.main.service.management.likes.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.likes.LikesDto;
import com.flow.admin.main.entity.LikesEntity;
import com.flow.admin.main.mapper.LikesMapper;
import com.flow.admin.main.repository.LikesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikesService {

	private final LikesRepository likesRepository;
	private final LikesMapper likesMapper;

	@Transactional
	public LikesDto save(LikesDto likesDto) {
		LikesEntity likesEntity = likesMapper.toEntity(likesDto);
		return likesMapper.toDto(likesRepository.save(likesEntity));
	}

	@Transactional(readOnly = true)
	public LikesDto findOrCreateByUserIdAndPostId(Long userId, Long postId) {
		return likesMapper.toDto(likesRepository.findByUserIdAndPostId(userId, postId)
			.orElse(LikesEntity.builder().build()));
	}

	@Transactional
	public LikesDto reuse(LikesDto likesDto) {
		LikesEntity likesEntity = likesMapper.toEntity(likesDto);
		likesEntity.markReuse();
		return likesMapper.toDto(likesRepository.save(likesEntity));
	}
}
