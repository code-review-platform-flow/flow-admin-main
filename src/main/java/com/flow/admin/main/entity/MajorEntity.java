package com.flow.admin.main.entity;

import org.hibernate.annotations.Where;

import com.flow.admin.main.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "majors")
@Where(clause = "use_yn = true")
public class MajorEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "major_id")
	private Long majorId;

	@Column(name = "major_name", nullable = false)
	private String majorName;

	@Column(name = "note")
	private String note;

	@Version
	private int version;
}
