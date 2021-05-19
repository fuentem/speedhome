package com.speedhome.property.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.speedhome.property.entity.Property;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Property save(Property property) {
		entityManager.persist(property);
		entityManager.flush();
		return property;
	}

	@Override
	public Property update(Property property) {
		entityManager.merge(property);
		entityManager.flush();
		return property;
	}

	@Override
	public List<Property> search(String name, String address) {
		TypedQuery<Property> cq = entityManager
				.createQuery("SELECT prop FROM Property prop " + "WHERE LOWER(prop.name) LIKE LOWER(CONCAT('%', ?1,'%')) "
						+ "OR LOWER(prop.address) LIKE LOWER(CONCAT('%', ?2,'%'))", Property.class)
				.setParameter(1, name).setParameter(2, address);

		return cq.getResultList();
	}

	@Override
	public Property getById(Long id) {
		return entityManager.find(Property.class, id);
	}

}
