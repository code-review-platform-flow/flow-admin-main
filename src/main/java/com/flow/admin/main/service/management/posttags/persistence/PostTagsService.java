package com.flow.admin.main.service.management.posttags.persistence;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.posttags.PostTagsDto;
import com.flow.admin.main.entity.PostTagsEntity;
import com.flow.admin.main.mapper.PostTagsMapper;
import com.flow.admin.main.repository.PostTagsRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostTagsService {

	private final PostTagsRepository postTagsRepository;
	private final PostTagsMapper postTagsMapper;

	@Transactional
	public PostTagsDto save(PostTagsDto postTagsDto) {
		PostTagsEntity postTagsEntity = postTagsMapper.toEntity(postTagsDto);
		return postTagsMapper.toDto(postTagsRepository.save(postTagsEntity));
	}

	@Transactional(readOnly = true)
	public List<PostTagsDto> findAllByPostId(Long postId) {
		List<PostTagsEntity> postTagsEntities = postTagsRepository.findAllByPostId(postId).orElse(
			Collections.emptyList());
		return postTagsMapper.toListDto(postTagsEntities);
	}

	@Transactional(readOnly = true)
	public PostTagsDto findByPostIdAndTagId(Long postId, Long tagId) {
		return postTagsMapper.toDto(postTagsRepository.findByPostIdAndTagId(postId, tagId)
			.orElseThrow(() -> new EntityNotFoundException(
				"PostTags not found with postId : " + postId + " and tagId : " + tagId)));
	}

	@Transactional
	public PostTagsDto reuseOrSavePostTags(PostTagsDto postTagsDto) {
		PostTagsEntity postTagsEntity = postTagsRepository.findByPostIdAndTagIdUseYnFalse(
			postTagsDto.getPostId(), postTagsDto.getTagId()).orElse(null);
		if (postTagsEntity == null) {
			return postTagsMapper.toDto(postTagsRepository.save(postTagsMapper.toEntity(postTagsDto)));
		}
		postTagsEntity.markReuse();
		return postTagsMapper.toDto(postTagsRepository.save(postTagsEntity));

	}

	@Transactional
	public PostTagsDto delete(PostTagsDto postTagsDto) {
		PostTagsEntity postTagsEntity = postTagsMapper.toEntity(postTagsDto);
		postTagsEntity.markDeleted();
		return postTagsMapper.toDto(postTagsRepository.save(postTagsEntity));
	}
}
