package com.flow.admin.main.service.domain.user;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flow.admin.main.dto.controller.user.UserListRequestDto;
import com.flow.admin.main.dto.controller.user.UserListResponseDto;
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

	public UserListResponseDto getUsers(Pageable pageable, UserListRequestDto userListRequestDto) {

		Pageable adjustedPageable = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize(),
			pageable.getSort());

		List<UsersDto> usersDtoList = usersService.findAllWithSearch(userListRequestDto);

		Map<Long, UserInfoDto> userInfoMap = userInfoService.findAll()
			.stream()
			.collect(Collectors.toMap(
				UserInfoDto::getUserId,
				userInfoDto -> userInfoDto,
				(existing, replacement) -> replacement
			));

		List<UserListResponseDto.ItemsDto> responseItemsDtoList = usersDtoList.stream()
			.map(usersDto -> {
				UserInfoDto matchedUserInfo = userInfoMap.get(usersDto.getUserId());

				if (matchedUserInfo == null) {
					return null;
				}

				boolean matches = matchesSearchCriteria(userListRequestDto, usersDto, matchedUserInfo);
				if (!matches) {
					return null;
				}

				return UserListResponseDto.ItemsDto.builder()
					.userId(usersDto.getUserId())
					.userName(matchedUserInfo.getUserName())
					.email(usersDto.getEmail())
					.schoolName(fetchSchoolName(matchedUserInfo.getSchoolId()))
					.schoolNumber(matchedUserInfo.getStudentNumber())
					.majorName(fetchMajorName(matchedUserInfo.getMajorId()))
					.status(usersDto.getUseYn())
					.role(matchedUserInfo.getRole())
					.createDate(usersDto.getCreateDate())
					.modifyDate(usersDto.getModifyDate())
					.build();
			})
			.filter(Objects::nonNull)
			.toList();

		int start = (int)adjustedPageable.getOffset();
		int end = Math.min((start + adjustedPageable.getPageSize()), responseItemsDtoList.size());

		List<UserListResponseDto.ItemsDto> paginatedList = responseItemsDtoList.subList(start, end);

		UserListResponseDto.PageDto pageDto = UserListResponseDto.PageDto.builder()
			.currentPage(adjustedPageable.getPageNumber() + 1)
			.pageSize(adjustedPageable.getPageSize())
			.totalPage(
				(responseItemsDtoList.size() + adjustedPageable.getPageSize() - 1) / adjustedPageable.getPageSize())
			.totalCount(responseItemsDtoList.size())
			.build();

		return UserListResponseDto.builder().items(paginatedList).page(pageDto).build();
	}

	private boolean matchesSearchCriteria(UserListRequestDto userListRequestDto, UsersDto usersDto,
		UserInfoDto userInfoDto) {
		String searchType = userListRequestDto.getSearchType();
		String searchText = userListRequestDto.getSearchText();

		if ("COMPLETED".equalsIgnoreCase(userListRequestDto.getStatus()) && !usersDto.getUseYn()) {
			return false;
		}

		if ("WITHDRAWAL".equalsIgnoreCase(userListRequestDto.getStatus()) && usersDto.getUseYn()) {
			return false;
		}

		if (searchText == null || searchText.isEmpty()) {
			return true;
		}

		return switch (searchType) {
			case "userName" -> userInfoDto.getUserName().equalsIgnoreCase(searchText);
			case "email" -> usersDto.getEmail().equalsIgnoreCase(searchText);
			case "schoolName" -> {
				String schoolName = fetchSchoolName(userInfoDto.getSchoolId());
				yield schoolName != null && schoolName.equalsIgnoreCase(searchText);
			}
			case "schoolNumber" -> userInfoDto.getStudentNumber().equalsIgnoreCase(searchText);
			case "majorName" -> {
				String majorName = fetchMajorName(userInfoDto.getMajorId());
				yield majorName != null && majorName.equalsIgnoreCase(searchText);
			}
			default -> true;
		};
	}

	private String fetchSchoolName(Long schoolId) {
		SchoolDto schoolDto = schoolService.findBySchoolId(schoolId);
		return schoolDto != null ? schoolDto.getSchoolName() : null;
	}

	private String fetchMajorName(Long majorId) {
		MajorDto majorDto = majorService.findByMajorId(majorId);
		return majorDto != null ? majorDto.getMajorName() : null;
	}

}
