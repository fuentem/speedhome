package com.speedhome.property.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speedhome.property.entity.Property;
import com.speedhome.property.entity.PropertyEntityWrapper;
import com.speedhome.property.service.PropertyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/property")
@Api(value = "Property API", produces = "application/json", tags = {"Property API"})
public class PropertyApi {

	@Autowired
	private PropertyService propertyService;

	@PostMapping
	@ApiOperation(value = "Create Property", response = Object.class)
	public ResponseEntity<Property> create(@RequestBody PropertyEntityWrapper property) {
		return new ResponseEntity<>(propertyService.create(property), HttpStatus.OK);
	}

	@PutMapping
	@ApiOperation(value = "Update Property", response = Object.class)
	public ResponseEntity<Property> update(@RequestParam Long id, @RequestBody PropertyEntityWrapper property) {
		return new ResponseEntity<>(propertyService.update(id, property), HttpStatus.OK);
	}

	@PostMapping(value="/approve")
	@ApiOperation(value = "Approve Property", response = Object.class)
	public ResponseEntity<Property> approve(@RequestParam Long id) {
		return new ResponseEntity<>(propertyService.approve(id), HttpStatus.OK);
	}

	@GetMapping(value="/search")
	@ApiOperation(value = "Search Property by Name and/or Address", response = Object.class)
	public ResponseEntity<List<Property>> search(@RequestParam(required = false) String name, @RequestParam(required = false) String address) {
		return new ResponseEntity<>(propertyService.search(name, address), HttpStatus.OK);
	}
	
}
