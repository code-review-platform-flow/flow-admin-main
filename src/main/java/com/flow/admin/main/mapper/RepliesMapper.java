package com.flow.admin.main.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.replies.RepliesDto;
import com.flow.admin.main.entity.RepliesEntity;

@Mapper(componentModel = "spring")
public interface RepliesMapper extends GenericMapper<RepliesDto, RepliesEntity> {

	@Mapping(source = "userId", target = "user.userId")
	@Mapping(source = "commentId", target = "comment.commentId")
	RepliesEntity toEntity(RepliesDto repliesDto);

	@Mapping(source = "user.userId", target = "userId")
	@Mapping(source = "comment.commentId", target = "commentId")
	RepliesDto toDto(RepliesEntity repliesEntity);

}
