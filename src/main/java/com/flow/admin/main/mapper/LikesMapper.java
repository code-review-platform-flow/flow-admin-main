package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.likes.LikesDto;
import com.flow.admin.main.entity.LikesEntity;

@Mapper(componentModel = "spring")
public interface LikesMapper extends GenericMapper<LikesDto, LikesEntity> {

	@Mapping(source = "userId", target = "user.userId")
	@Mapping(source = "postId", target = "post.postId")
	LikesEntity toEntity(LikesDto postsDto);

	@Mapping(source = "user.userId", target = "userId")
	@Mapping(source = "post.postId", target = "postId")
	@Mapping(source = "useYn", target = "useYn")
	LikesDto toDto(LikesEntity likesEntity);

}
