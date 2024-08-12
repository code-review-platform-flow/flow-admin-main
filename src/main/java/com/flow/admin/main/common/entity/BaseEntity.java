package com.flow.admin.main.common.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

	@Column(name = "use_yn")
	private boolean useYn;

	@Column(name = "create_code", updatable = false)
	private String createCode;

	@CreatedDate
	@Column(name = "create_date", updatable = false)
	private LocalDateTime createDate;

	@LastModifiedBy
	@Column(name = "modify_code")
	private String modifyCode;

	@LastModifiedDate
	@Column(name = "modify_date")
	private LocalDateTime modifyDate;

	@Column(name = "delete_code")
	private String deleteCode;

	@Column(name = "delete_date")
	private LocalDateTime deleteDate;

	@Version
	public int version;

	@PrePersist
	public void prePersist() {
		this.createDate = LocalDateTime.now();
		this.createCode = "flow-payment";
		this.useYn = true;
	}
}
