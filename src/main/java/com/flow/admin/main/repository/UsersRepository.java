package com.flow.admin.main.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

	boolean existsByEmail(String email);

	@Query("SELECT u FROM UsersEntity u WHERE u.email = :email")
	Optional<UsersEntity> findByEmail(@Param("email") String email);

	@Query("SELECT u FROM UsersEntity u WHERE " +
		"(:searchDateType IS NULL OR (CASE WHEN :searchDateType = 'created' THEN u.createDate ELSE u.modifyDate END) BETWEEN :startDate AND :endDate)")
	List<UsersEntity> findAllWithSearch(
		@Param("searchDateType") String searchDateType,
		@Param("startDate") LocalDateTime startDate,
		@Param("endDate") LocalDateTime endDate
	);

	long count();

}
