package com.flow.admin.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.PostsEntity;

public interface PostsRepository extends JpaRepository<PostsEntity, Long> {

	@Query("SELECT p FROM PostsEntity p WHERE p.postId = :postId")
	Optional<PostsEntity> findByPostId(@Param("postId") Long postId);

	@Query("SELECT p FROM PostsEntity p WHERE p.postId = :postId AND p.user.userId = :userId")
	Optional<PostsEntity> findByPostId(@Param("postId") Long postId, @Param("userId") Long userId);

}
