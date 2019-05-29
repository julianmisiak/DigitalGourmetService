package com.jas.digitalgourmet.repository.persistentobject;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.jas.digitalgourmet.util.BusinessException;

public class PersistentObjectImplRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements PersistentObjectExtendedRepository<T, ID> {

	private EntityManager entityManager;

	public PersistentObjectImplRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public List<T> findByAttributeContainsText(String attributeName, String text) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cQuery = builder.createQuery(getDomainClass());
		Root<T> root = cQuery.from(getDomainClass());
		cQuery.select(root).where(builder.like(root.<String>get(attributeName), "%" + text + "%"));
		TypedQuery<T> query = entityManager.createQuery(cQuery);
		return query.getResultList();
	}

	@Override
	public Integer activeOrInactiveObjectById(Long OID, Boolean active) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<T> update = builder.createCriteriaUpdate(getDomainClass());
		Root<T> root = update.from(getDomainClass());
		update.where(builder.equal(root.get("OID"), builder.parameter(Long.class, "OID")));
		update.set("isActive", active);
		Query query = entityManager.createQuery(update);
		query.setParameter("OID", OID);
		return query.executeUpdate();
	}

	@Override
	public Integer activeObjectById(Long OID) {
		return activeOrInactiveObjectById(OID, Boolean.TRUE);
	}

	@Override
	public Integer inactiveObjectById(Long OID) {
		return activeOrInactiveObjectById(OID, Boolean.FALSE);
	}

	@Override
	public <S extends T> S save(S entity) {
		try {
			return super.save(entity);
		} catch (OptimisticLockException e) {
			e.printStackTrace();
			throw new BusinessException("Otro usuario modifico la entidad. Recargue la página");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("Error desconocido, Consulte al administrador");
		}
	}
}
