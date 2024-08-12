package com.flow.admin.main.service.management.posts.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.posts.PostsDto;
import com.flow.admin.main.entity.PostsEntity;
import com.flow.admin.main.mapper.PostsMapper;
import com.flow.admin.main.repository.PostsRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostsService {

	private final PostsRepository postsRepository;
	private final PostsMapper postsMapper;

	@Transactional
	public PostsDto save(PostsDto postsDto) {
		PostsEntity postsEntity = postsMapper.toEntity(postsDto);
		return postsMapper.toDto(postsRepository.save(postsEntity));
	}

	@Transactional(readOnly = true)
	public PostsDto findByPostId(Long postId) {
		PostsEntity postsEntity = postsRepository.findByPostId(postId)
			.orElseThrow(() -> new EntityNotFoundException("Posts not found with postId : " + postId));
		return postsMapper.toDto(postsEntity);
	}

	@Transactional(readOnly = true)
	public PostsDto findByPostId(Long postId, Long userId) {
		PostsEntity postsEntity = postsRepository.findByPostId(postId, userId)
			.orElseThrow(
				() -> new EntityNotFoundException("Posts not found with postId : " + postId + " , userId : " + userId));
		return postsMapper.toDto(postsEntity);
	}

	@Transactional
	public PostsDto delete(Long postId, Long userId) {
		PostsEntity postsEntity = postsRepository.findByPostId(postId, userId)
			.orElseThrow(
				() -> new EntityNotFoundException("Posts not found with postId : " + postId + " , userId : " + userId));
		postsEntity.markDeleted();
		return postsMapper.toDto(postsRepository.save(postsEntity));
	}
}
