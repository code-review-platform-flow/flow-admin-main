package com.flow.admin.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.LikesEntity;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {

	@Query("SELECT l FROM LikesEntity l WHERE l.user.userId = :userId AND l.post.postId = :postId")
	Optional<LikesEntity> findByUserIdAndPostId(@Param("userId") Long userId, @Param("postId") Long postId);

}
