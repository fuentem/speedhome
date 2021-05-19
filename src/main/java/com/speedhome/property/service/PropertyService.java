package com.speedhome.property.service;

import java.util.List;

import com.speedhome.property.entity.PropertyEntityWrapper;
import com.speedhome.property.entity.Property;

public interface PropertyService {

	Property create(PropertyEntityWrapper propertyWrapper);

	Property update(Long id, PropertyEntityWrapper property);
	
	Property approve(Long id);

	List<Property> search(String name, String address);

}
