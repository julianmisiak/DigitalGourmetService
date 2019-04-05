package com.jas.digitalgourmet.model.auditable;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
	protected Calendar  createTimestamp;
	protected Calendar  modificationTimestamp;
	protected U creationUser;
	protected U modificationUser;
	

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIMESTAMP", nullable = false)
	public Calendar getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Calendar  createDate) {
		this.createTimestamp = createDate;
	}

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFICATION_TIMESTAMP", nullable = false)
	public Calendar  getModificationTimestamp() {
		return modificationTimestamp;
	}

	public void setModificationTimestamp(Calendar  modificationDate) {
		this.modificationTimestamp = modificationDate;
	}

	@CreatedBy
	@Column(name = "CREATION_USER", nullable = false)
	public U getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(U creationUser) {
		this.creationUser = creationUser;
	}

	@LastModifiedBy
	@Column(name = "MODIFICATION_USER", nullable = false)
	public U getModificationUser() {
		return modificationUser;
	}

	public void setModificationUser(U modificationUser) {
		this.modificationUser = modificationUser;
	}
	

}
