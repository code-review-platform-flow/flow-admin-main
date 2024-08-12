package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.major.MajorDto;
import com.flow.admin.main.entity.MajorEntity;

@Mapper(componentModel = "spring")
public interface MajorMapper extends GenericMapper<MajorDto, MajorEntity> {

}
