package com.speedhome.property.api;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.speedhome.property.entity.Property;
import com.speedhome.property.entity.PropertyEntityWrapper;
import com.speedhome.property.service.PropertyService;

public class PropertyApiTest {

	@Mock
	PropertyService propertyService;
	@Mock
	PropertyEntityWrapper propertyWrapper;
	@Mock
	Property property;
	@InjectMocks
	PropertyApi propertyApi;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createPropertyTest() {
		Mockito.when(propertyService.create(propertyWrapper)).thenReturn(property);
		Assert.assertNotNull(propertyApi.create(propertyWrapper));
	}
	
	@Test
	public void updatePropertyTest() {
		Mockito.when(propertyService.update(1l, propertyWrapper)).thenReturn(property);
		Assert.assertNotNull(propertyApi.update(1l, propertyWrapper));
	}
	
	@Test
	public void approvePropertyTest() {
		Mockito.when(propertyService.approve(1l)).thenReturn(property);
		Assert.assertNotNull(propertyApi.approve(1l));
	}
	
	@Test
	public void searchPropertyTest() {
		Mockito.when(propertyService.search("test", "test")).thenReturn(new ArrayList<Property>());
		Assert.assertNotNull(propertyApi.search("test", "test"));
	}

}
