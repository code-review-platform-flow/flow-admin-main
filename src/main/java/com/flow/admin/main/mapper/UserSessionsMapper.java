package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.usersessions.UserSessionsDto;
import com.flow.admin.main.entity.UserSessionsEntity;

@Mapper(componentModel = "spring")
public interface UserSessionsMapper extends GenericMapper<UserSessionsDto, UserSessionsEntity> {

	@Mapping(source = "userId", target = "user.userId")
	UserSessionsEntity toEntity(UserSessionsDto userSessionsDto);

	@Mapping(source = "user.userId", target = "userId")
	UserSessionsDto toDto(UserSessionsEntity userSessionsEntity);

}
