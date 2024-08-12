package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.comments.CommentsDto;
import com.flow.admin.main.entity.CommentsEntity;

@Mapper(componentModel = "spring")
public interface CommentsMapper extends GenericMapper<CommentsDto, CommentsEntity> {

	@Mapping(source = "userId", target = "user.userId")
	@Mapping(source = "postId", target = "post.postId")
	CommentsEntity toEntity(CommentsDto commentsDto);

	@Mapping(source = "user.userId", target = "userId")
	@Mapping(source = "post.postId", target = "postId")
	CommentsDto toDto(CommentsEntity commentsEntity);

}
