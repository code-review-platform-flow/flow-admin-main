package com.flow.admin.main.service.management.categories.persistence;

import org.springframework.stereotype.Service;

import com.flow.admin.main.dto.jpa.categories.CategoriesDto;
import com.flow.admin.main.mapper.CategoriesMapper;
import com.flow.admin.main.repository.CategoriesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesService {

	private final CategoriesRepository categoriesRepository;
	private final CategoriesMapper categoriesMapper;

	public CategoriesDto findByCategoryName(String categoryName) {
		return categoriesMapper.toDto(categoriesRepository.findByCategoryName(categoryName)
			.orElseThrow(() -> new EntityNotFoundException("Category not found with categoryName : " + categoryName)));
	}

}
