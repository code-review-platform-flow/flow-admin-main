package com.flow.admin.main.service.management.school.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.school.SchoolDto;
import com.flow.admin.main.mapper.SchoolMapper;
import com.flow.admin.main.repository.SchoolRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

	private final SchoolRepository schoolRepository;
	private final SchoolMapper schoolMapper;

	@Transactional(readOnly = true)
	public SchoolDto findBySchoolName(String schoolName) {
		return schoolMapper.toDto(schoolRepository.findBySchoolName(schoolName)
			.orElseThrow(() -> new EntityNotFoundException("School not found with schoolName : " + schoolName)));
	}
}
