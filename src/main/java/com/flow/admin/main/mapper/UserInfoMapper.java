package com.flow.admin.main.mapper;

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

}
