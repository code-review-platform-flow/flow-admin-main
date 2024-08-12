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
@Table(name = "schools")
@Where(clause = "use_yn = true")
public class SchoolEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private Long schoolId;

	@Column(name = "school_name", nullable = false)
	private String schoolName;

	@Column(name = "note")
	private String note;

	@Version
	private int version;
}
