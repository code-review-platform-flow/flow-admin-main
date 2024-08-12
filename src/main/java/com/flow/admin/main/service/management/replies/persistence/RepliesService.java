package com.flow.admin.main.service.management.replies.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.replies.RepliesDto;
import com.flow.admin.main.entity.RepliesEntity;
import com.flow.admin.main.mapper.RepliesMapper;
import com.flow.admin.main.repository.RepliesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RepliesService {

	private final RepliesRepository repliesRepository;
	private final RepliesMapper repliesMapper;

	@Transactional
	public RepliesDto save(RepliesDto repliesDto) {
		RepliesEntity repliesEntity = repliesMapper.toEntity(repliesDto);
		return repliesMapper.toDto(repliesRepository.save(repliesEntity));
	}

	@Transactional(readOnly = true)
	public RepliesDto findByReplyId(Long replyId, Long userId) {
		RepliesEntity repliesEntity = repliesRepository.findByReplyId(replyId, userId)
			.orElseThrow(() -> new EntityNotFoundException(
				"Replies not found with replyId : " + replyId + " , userId : " + userId));
		return repliesMapper.toDto(repliesEntity);
	}

	@Transactional
	public RepliesDto delete(RepliesDto repliesDto) {
		RepliesEntity repliesEntity = repliesMapper.toEntity(repliesDto);
		repliesEntity.markDeleted();
		return repliesMapper.toDto(repliesRepository.save(repliesEntity));
	}
}
