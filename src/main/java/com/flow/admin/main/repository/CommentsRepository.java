package com.flow.admin.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.CommentsEntity;

public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {

	@Query("SELECT c FROM CommentsEntity c WHERE c.commentId = :commentId")
	Optional<CommentsEntity> findByCommentId(@Param("commentId") Long commentId);

	@Query("SELECT c FROM CommentsEntity c WHERE c.commentId = :commentId AND c.user.userId = :userId")
	Optional<CommentsEntity> findByCommentId(@Param("commentId") Long commentId, @Param("userId") Long userId);

}
