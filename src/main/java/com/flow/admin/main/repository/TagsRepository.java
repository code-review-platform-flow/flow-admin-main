package com.flow.admin.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.TagsEntity;

public interface TagsRepository extends JpaRepository<TagsEntity, Long> {

	boolean existsByTagName(String tagName);

	@Query("SELECT t FROM TagsEntity t WHERE t.tagName = :tagName")
	Optional<TagsEntity> findByTagName(@Param("tagName") String tagName);
}
