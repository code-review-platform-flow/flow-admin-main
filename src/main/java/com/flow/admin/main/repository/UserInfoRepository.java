package com.flow.admin.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

	@Query("SELECT ui FROM UserInfoEntity ui WHERE ui.user.userId = :userId")
	Optional<UserInfoEntity> findByUserId(@Param("userId") Long userId);

}
