package com.speedhome.property.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.speedhome.property.entity.Property;

public class PropertyRepositoryTest {
	
	@Mock
	EntityManager entityManager;
	@Mock
	Property property;
	@InjectMocks
	PropertyRepositoryImpl propertyRepository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveTest() {
		Mockito.doNothing().when(entityManager).persist(Mockito.any());
		Mockito.doNothing().when(entityManager).flush();
		Assert.assertNotNull(propertyRepository.save(property));
	}

	@Test
	public void updateTest() {
		Mockito.when(entityManager.merge(Mockito.any())).thenReturn(property);
		Mockito.doNothing().when(entityManager).flush();
		Assert.assertNotNull(propertyRepository.update(property));
	}
	
	@Test
	public void getByIdTest() {
		Mockito.when(entityManager.find(Mockito.any(), Mockito.any())).thenReturn(property);
		Assert.assertNotNull(propertyRepository.getById(1l));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void searchValidTest() {
		ArrayList<Property> value = new ArrayList<Property>();
		value.add(new Property());
		
		TypedQuery<Property> query = Mockito.mock(TypedQuery.class);
		Mockito.when(entityManager.createQuery("SELECT prop FROM Property prop " + "WHERE LOWER(prop.name) LIKE LOWER(CONCAT('%', ?1,'%')) "
				+ "OR LOWER(prop.address) LIKE LOWER(CONCAT('%', ?2,'%'))", Property.class)).thenReturn(query);
		Mockito.when(query.setParameter(1, "test")).thenReturn(query);
		Mockito.when(query.setParameter(2, "test")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(value);
		Assert.assertTrue(propertyRepository.search("test", "test").size() > 0);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void searchInvalidTest() {
		TypedQuery<Property> query = Mockito.mock(TypedQuery.class);
		Mockito.when(entityManager.createQuery("SELECT prop FROM Property prop " + "WHERE LOWER(prop.name) LIKE LOWER(CONCAT('%', ?1,'%')) "
				+ "OR LOWER(prop.address) LIKE LOWER(CONCAT('%', ?2,'%'))", Property.class)).thenReturn(query);
		Mockito.when(query.setParameter(1, "notexisting")).thenReturn(query);
		Mockito.when(query.setParameter(2, "notexisting")).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(new ArrayList<Property>());
		Assert.assertFalse(propertyRepository.search("notexisting", "notexisting").size() > 0);
	}
}
