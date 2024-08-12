package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.tags.TagsDto;
import com.flow.admin.main.entity.TagsEntity;

@Mapper(componentModel = "spring")
public interface TagsMapper extends GenericMapper<TagsDto, TagsEntity> {

}
