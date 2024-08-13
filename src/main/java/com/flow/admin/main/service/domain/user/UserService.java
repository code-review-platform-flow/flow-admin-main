package com.flow.admin.main.service.domain.user;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flow.admin.main.dto.controller.user.UserResponseDto;
import com.flow.admin.main.dto.jpa.major.MajorDto;
import com.flow.admin.main.dto.jpa.school.SchoolDto;
import com.flow.admin.main.dto.jpa.userinfo.UserInfoDto;
import com.flow.admin.main.dto.jpa.users.UsersDto;
import com.flow.admin.main.service.management.major.persistence.MajorService;
import com.flow.admin.main.service.management.school.persistence.SchoolService;
import com.flow.admin.main.service.management.userinfo.persistence.UserInfoService;
import com.flow.admin.main.service.management.users.persistence.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

	private final UsersService usersService;
	private final UserInfoService userInfoService;
	private final MajorService majorService;
	private final SchoolService schoolService;

	public UserResponseDto getUser(Pageable pageable) {
		List<UsersDto> usersDtoList = usersService.findAll();

		Map<Long, UserInfoDto> userInfoMap = userInfoService.findAll()
			.stream()
			.collect(Collectors.toMap(
				UserInfoDto::getUserId,
				userInfoDto -> userInfoDto,
				(existing, replacement) -> replacement
			));

		List<UserResponseDto.DataDto> responseDataDtoList = usersDtoList.stream()
			.map(usersDto -> {
				UserInfoDto matchedUserInfo = userInfoMap.get(usersDto.getUserId());

				return Optional.ofNullable(matchedUserInfo)
					.map(userInfoDto -> UserResponseDto.DataDto.builder()
						.userId(usersDto.getUserId())
						.userName(userInfoDto.getUserName())
						.email(usersDto.getEmail())
						.schoolName(fetchSchoolName(userInfoDto.getSchoolId()))
						.schoolNumber(userInfoDto.getStudentNumber())
						.majorName(fetchMajorName(userInfoDto.getMajorId()))
						.status(usersDto.getUseYn())
						.role(userInfoDto.getRole())
						.createDate(usersDto.getCreateDate())
						.modifyDate(usersDto.getModifyDate())
						.build())
					.orElse(null);
			})
			.filter(Objects::nonNull)
			.toList();

		int start = (int)pageable.getOffset();
		int end = Math.min((start + pageable.getPageSize()), responseDataDtoList.size());

		List<UserResponseDto.DataDto> paginatedList = responseDataDtoList.subList(start, end);

		UserResponseDto.PageDto pageDto = UserResponseDto.PageDto.builder()
			.currentPage(pageable.getPageNumber() + 1)
			.pageSize(pageable.getPageSize())
			.totalPage((paginatedList.size() + pageable.getPageSize() - 1) / pageable.getPageSize())
			.totalCount(responseDataDtoList.size())
			.build();

		return UserResponseDto.builder().data(paginatedList).page(pageDto).build();
	}

	private String fetchSchoolName(Long schoolId) {
		SchoolDto schoolDto = schoolService.findBySchoolId(schoolId);
		return schoolDto.getSchoolName();
	}

	private String fetchMajorName(Long majorId) {
		MajorDto majorDto = majorService.findByMajorId(majorId);
		return majorDto.getMajorName();
	}

}
