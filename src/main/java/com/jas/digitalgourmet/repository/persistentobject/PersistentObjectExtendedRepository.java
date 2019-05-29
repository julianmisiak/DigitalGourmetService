package com.jas.digitalgourmet.repository.persistentobject;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.jas.digitalgourmet.model.PersistentObject;

@NoRepositoryBean
public interface PersistentObjectExtendedRepository <T, ID extends Serializable> extends CrudRepository<T, ID> {
	public List<T> findByAttributeContainsText(String attributeName, String text);  
	@Transactional
	public Integer activeOrInactiveObjectById(Long OID, Boolean active);  
	@Transactional
	public Integer activeObjectById(Long OID);  
	@Transactional
	public Integer inactiveObjectById(Long OID);
	@Transactional
	public <S extends T> S save(S entity);
}

