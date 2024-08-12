package com.flow.admin.main.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.userinfo.UserInfoDto;
import com.flow.admin.main.entity.UserInfoEntity;

@Mapper(componentModel = "spring")
public interface UserInfoMapper extends GenericMapper<UserInfoDto, UserInfoEntity> {

	@Mapping(source = "majorId", target = "major.majorId")
	@Mapping(source = "schoolId", target = "school.schoolId")
	@Mapping(source = "userId", target = "user.userId")
	UserInfoEntity toEntity(UserInfoDto userInfoDto);

	@Mapping(source = "major.majorId", target = "majorId")
	@Mapping(source = "school.schoolId", target = "schoolId")
	@Mapping(source = "user.userId", target = "userId")
	UserInfoDto toDto(UserInfoEntity userInfoEntity);

	List<UserInfoDto> toListDto(List<UserInfoEntity> userInfoEntities);

}
