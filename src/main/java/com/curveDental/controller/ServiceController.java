package com.curveDental.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curveDental.model.ServiceType;
import com.curveDental.service.CarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ServiceController {

    @Autowired
	private CarService carService;

	// get all service types
	@RequestMapping(value = "/service_types", method = RequestMethod.GET)
	public ResponseEntity<List<ServiceType>> listServiceTypes() {
		return new ResponseEntity<List<ServiceType>>(carService.findAllServiceTypes(),
			HttpStatus.OK);
	}

}

