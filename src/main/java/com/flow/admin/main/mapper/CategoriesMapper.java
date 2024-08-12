package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.categories.CategoriesDto;
import com.flow.admin.main.entity.CategoriesEntity;

@Mapper(componentModel = "spring")
public interface CategoriesMapper extends GenericMapper<CategoriesDto, CategoriesEntity> {

}
