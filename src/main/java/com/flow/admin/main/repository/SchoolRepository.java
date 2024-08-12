package com.flow.admin.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flow.admin.main.entity.SchoolEntity;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

	@Query("SELECT s FROM SchoolEntity s WHERE s.schoolName = :schoolName AND s.useYn = true")
	Optional<SchoolEntity> findBySchoolName(@Param("schoolName") String schoolName);

}
