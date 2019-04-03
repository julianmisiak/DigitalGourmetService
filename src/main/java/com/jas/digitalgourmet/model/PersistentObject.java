package com.jas.digitalgourmet.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jas.digitalgourmet.model.auditable.Auditable;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class PersistentObject extends Auditable<String> {
	protected Long OID;

	@Id
	@Column(name = "OID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	public Long getOID() {
		return OID;
	}

	public void setOID(Long OID) {
		this.OID = OID;
	}

}
