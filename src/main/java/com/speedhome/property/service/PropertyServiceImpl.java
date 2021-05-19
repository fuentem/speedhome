package com.speedhome.property.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedhome.property.entity.PropertyEntityWrapper;
import com.speedhome.property.entity.Property;
import com.speedhome.property.entity.PropertyStatus;
import com.speedhome.property.repository.PropertyRepository;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	@Transactional
	public Property create(PropertyEntityWrapper propertyWrapper) {
		
		Property property = new Property(propertyWrapper);
		
		//setting initial unapproved status
		property.setStatus(PropertyStatus.UNAPPROVED.name());
		property.setCreatedDate(new Date());
		
		return propertyRepository.save(property);
	}

	@Override
	@Transactional
	public Property update(Long id, PropertyEntityWrapper propertyWrapper) {
		
		Property prop = getValidProperty(id);
		prop.assignWrapperToObj(propertyWrapper);
		
		return propertyRepository.update(prop);
	}

	@Override
	@Transactional
	public Property approve(Long id) {
		
		//retrieving property details first
		Property prop = getValidProperty(id);
		
		//setting approved status
		prop.setStatus(PropertyStatus.APPROVED.name());
		prop.setApprovedDate(new Date());
		
		propertyRepository.update(prop);
		
		return prop;
	}

	@Override
	public List<Property> search(String name, String address) {
		return propertyRepository.search(name, address);
	}
	
	private Property getValidProperty(Long id) {
		Property prop = propertyRepository.getById(id);
		
		if(prop != null) {
			return prop;
		}else {
			throw new EntityNotFoundException("Property does not exist!");
		}
	}
	
}
