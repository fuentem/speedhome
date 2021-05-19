package com.speedhome.property.repository;

import java.util.List;

import com.speedhome.property.entity.Property;

public interface PropertyRepository {

	Property save(Property taxpayer);
	
	Property update(Property taxpayer);

	List<Property> search(String name, String address);

	Property getById(Long id);
}
