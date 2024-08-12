package com.flow.admin.main.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flow.admin.main.common.mapper.GenericMapper;
import com.flow.admin.main.dto.jpa.posttags.PostTagsDto;
import com.flow.admin.main.entity.PostTagsEntity;

@Mapper(componentModel = "spring")
public interface PostTagsMapper extends GenericMapper<PostTagsDto, PostTagsEntity> {

	@Mapping(source = "postId", target = "post.postId")
	@Mapping(source = "tagId", target = "tag.tagId")
	PostTagsEntity toEntity(PostTagsDto postTagsDto);

	@Mapping(source = "post.postId", target = "postId")
	@Mapping(source = "tag.tagId", target = "tagId")
	PostTagsDto toDto(PostTagsEntity postTagsEntity);

	@Mapping(source = "post.postId", target = "postId")
	@Mapping(source = "tag.tagId", target = "tagId")
	List<PostTagsDto> toListDto(List<PostTagsEntity> postTagsEntities);

	@Mapping(source = "post.postId", target = "postId")
	@Mapping(source = "tag.tagId", target = "tagId")
	List<PostTagsEntity> toListEntity(List<PostTagsDto> postTagsDtos);
}
