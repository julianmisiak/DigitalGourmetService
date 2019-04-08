package com.jas.digitalgourmet.dao.persistentobject;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersistentObjectExtendedDAO <T, ID extends Serializable> extends JpaRepository<T, ID> {
	public List<T> findByAttributeContainsText(String attributeName, String text);  
	@Transactional
	public Integer activeOrInactiveObjectById(Long OID, Boolean active);  
	@Transactional
	public Integer activeObjectById(Long OID);  
	@Transactional
	public Integer inactiveObjectById(Long OID);  

}

