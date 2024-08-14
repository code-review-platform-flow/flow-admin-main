package com.flow.admin.main.dto.controller.user;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponseDto {

	private List<ItemsDto> items;
	private PageDto page;

	@Getter
	@Builder
	@EqualsAndHashCode
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ItemsDto {
		private Long userId;
		private String email;
		private String userName;
		private String schoolName;
		private String schoolNumber;
		private String majorName;
		private Boolean status;
		private String role;
		private LocalDateTime createDate;
		private LocalDateTime modifyDate;
	}

	@Getter
	@Builder
	@EqualsAndHashCode
	@AllArgsConstructor
	@NoArgsConstructor
	public static class PageDto {
		private Integer currentPage;
		private Integer pageSize;
		private Integer totalPage;
		private Integer totalCount;
	}

}
