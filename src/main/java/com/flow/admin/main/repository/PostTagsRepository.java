package com.flow.admin.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.PostTagsEntity;

public interface PostTagsRepository extends JpaRepository<PostTagsEntity, Long> {

	@Query("SELECT p FROM PostTagsEntity p WHERE p.post.postId = :postId AND p.useYn = true")
	Optional<List<PostTagsEntity>> findAllByPostId(@Param("postId") Long postId);

	@Query("SELECT p FROM PostTagsEntity p WHERE p.post.postId = :postId AND p.tag.tagId = :tagId AND p.useYn = true")
	Optional<PostTagsEntity> findByPostIdAndTagId(@Param("postId") Long postId, @Param("tagId") Long tagId);

	@Query("SELECT p FROM PostTagsEntity p WHERE p.post.postId = :postId AND p.tag.tagId = :tagId AND p.useYn = false")
	Optional<PostTagsEntity> findByPostIdAndTagIdUseYnFalse(@Param("postId") Long postId, @Param("tagId") Long tagId);
}
