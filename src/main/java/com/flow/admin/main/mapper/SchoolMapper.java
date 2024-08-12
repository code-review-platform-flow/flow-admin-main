package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.school.SchoolDto;
import com.flow.admin.main.entity.SchoolEntity;

@Mapper(componentModel = "spring")
public interface SchoolMapper extends GenericMapper<SchoolDto, SchoolEntity> {

}
