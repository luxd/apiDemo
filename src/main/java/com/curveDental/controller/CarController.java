package com.curveDental.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.curveDental.model.Car;
import com.curveDental.model.CarType;
import com.curveDental.service.CarService;

@RestController
public class CarController {

    @Autowired
	private CarService carService;


	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public List<Car> listAllCars() {
		return carService.findAll();
	}

	@RequestMapping(value = "/car_types", method = RequestMethod.GET)
	public List<CarType> listAllCarTypes() {
		return carService.findAllCarTypes();
	}
}

