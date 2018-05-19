package com.curveDental.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curveDental.model.ServiceType;
import com.curveDental.service.CarService;

@RestController
public class ServiceController {

    @Autowired
	private CarService carService;


	@RequestMapping(value = "/service_types", method = RequestMethod.GET)
	public List<ServiceType> listServiceTypes() {
		return carService.findAllServiceTypes();
	}

}

