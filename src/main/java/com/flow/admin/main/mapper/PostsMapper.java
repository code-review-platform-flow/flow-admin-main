package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.posts.PostsDto;
import com.flow.admin.main.entity.PostsEntity;

@Mapper(componentModel = "spring")
public interface PostsMapper extends GenericMapper<PostsDto, PostsEntity> {

	@Mapping(source = "userId", target = "user.userId")
	@Mapping(source = "categoryId", target = "category.categoryId")
	PostsEntity toEntity(PostsDto postsDto);

	@Mapping(source = "user.userId", target = "userId")
	@Mapping(source = "category.categoryId", target = "categoryId")
	PostsDto toDto(PostsEntity postsEntity);

}
