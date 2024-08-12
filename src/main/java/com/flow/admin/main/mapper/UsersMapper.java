package com.flow.admin.main.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.users.UsersDto;
import com.flow.admin.main.entity.UsersEntity;

@Mapper(componentModel = "spring")
public interface UsersMapper extends GenericMapper<UsersDto, UsersEntity> {
	List<UsersDto> toListDto(List<UsersEntity> users);
}
