package com.speedhome.property.service;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.speedhome.property.entity.Property;
import com.speedhome.property.entity.PropertyEntityWrapper;
import com.speedhome.property.repository.PropertyRepository;

public class PropertyServiceTest {

	@Mock
	PropertyRepository propertyRepository;
	@Mock
	PropertyEntityWrapper propertyWrapper;
	@Mock
	Property property;
	@InjectMocks
	PropertyServiceImpl propertyService;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createPropertyTest() {
		Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(property);
		PropertyEntityWrapper createObj = new PropertyEntityWrapper();
		Assert.assertNotNull(propertyService.create(createObj));
	}
	
	@Test
	public void updatePropertyValidTest() {
		Mockito.when(propertyRepository.getById(1l)).thenReturn(property);
		Mockito.when(propertyRepository.update(Mockito.any())).thenReturn(property);
		Assert.assertNotNull(propertyService.update(1l, propertyWrapper));
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void updatePropertyInvalidTest() {
		Mockito.when(propertyRepository.getById(1l)).thenReturn(null);
		propertyService.update(1l, propertyWrapper);
	}
	
	@Test
	public void approveValidPropertyTest() {
		Mockito.when(propertyRepository.getById(1l)).thenReturn(property);
		Mockito.when(propertyRepository.update(Mockito.any())).thenReturn(property);
		Assert.assertNotNull(propertyService.approve(1l));
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void approveInvalidPropertyTest() {
		Mockito.when(propertyRepository.getById(1l)).thenReturn(null);
		propertyService.approve(1l);
	}
	
	@Test
	public void searchNameAndAddressPropertyTest() {
		Mockito.when(propertyService.search("test", "test")).thenReturn(new ArrayList<Property>());
		Assert.assertNotNull(propertyService.search("test", "test"));
	}
	
	@Test
	public void searchNamePropertyTest() {
		Mockito.when(propertyService.search("test", "")).thenReturn(new ArrayList<Property>());
		Assert.assertNotNull(propertyService.search("test", ""));
	}
	
	@Test
	public void searchAddressPropertyTest() {
		Mockito.when(propertyService.search("", "test")).thenReturn(new ArrayList<Property>());
		Assert.assertNotNull(propertyService.search("", "test"));
	}
	
	@Test
	public void searchNoResultPropertyTest() {
		Mockito.when(propertyService.search("noresult", "noresult")).thenReturn(new ArrayList<Property>());
		Assert.assertFalse(propertyService.search("noresult", "noresult").size() > 0);
	}

}
