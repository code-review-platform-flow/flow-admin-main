package com.flow.admin.main.service.management.major.persistence;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flow.admin.main.dto.jpa.major.MajorDto;
import com.flow.admin.main.mapper.MajorMapper;
import com.flow.admin.main.repository.MajorRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MajorService {

	private final MajorRepository majorRepository;
	private final MajorMapper majorMapper;

	@Transactional(readOnly = true)
	public MajorDto findByMajorName(String majorName) {
		return majorMapper.toDto(majorRepository.findByMajorName(majorName)
			.orElseThrow(() -> new EntityNotFoundException("Major not found with majorName : " + majorName)));
	}

	@Transactional(readOnly = true)
	public MajorDto findByMajorId(Long majorId) {
		return majorMapper.toDto(majorRepository.findByMajorId(majorId)
			.orElseThrow(() -> new EntityNotFoundException("Major not found with majorName : " + majorId)));
	}
}
