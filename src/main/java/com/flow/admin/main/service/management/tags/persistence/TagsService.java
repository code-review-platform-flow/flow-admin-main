package com.flow.admin.main.service.management.tags.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.tags.TagsDto;
import com.flow.admin.main.entity.TagsEntity;
import com.flow.admin.main.mapper.TagsMapper;
import com.flow.admin.main.repository.TagsRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagsService {

	private final TagsRepository tagsRepository;
	private final TagsMapper tagsMapper;

	@Transactional
	public TagsDto saveOrFindByTagName(String tagName) {
		boolean check = tagsRepository.existsByTagName(tagName);
		if (!check)
			return tagsMapper.toDto(tagsRepository.save(TagsEntity.builder().tagName(tagName).build()));
		else
			return findByTagName(tagName);
	}

	@Transactional(readOnly = true)
	public TagsDto findByTagName(String tagName) {
		return tagsMapper.toDto(tagsRepository.findByTagName(tagName)
			.orElseThrow(() -> new EntityNotFoundException("Tag not found with tagName : " + tagName)));
	}

}
