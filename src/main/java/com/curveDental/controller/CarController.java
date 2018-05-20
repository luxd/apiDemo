package com.curveDental.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.curveDental.dto.ServiceRecordDTO;
import com.curveDental.dto.ServiceTypeDTO;
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

	// get all service records of a specific car
	@RequestMapping(value = "/car/{carId}/services", method = RequestMethod.GET)
	public List<ServiceRecordDTO> listAllCarService(@PathVariable Long carId) {
		return carService.findAllRecordsByCarId(carId);
	}

	// get all available service types for a specific car type
	@RequestMapping(value = "/car_type/{carTypeId}/service_types", method = RequestMethod.GET)
	public List<ServiceTypeDTO> listAllServiceTypes(@PathVariable Long carTypeId) {
		return carService.findServiceTypesByCarTypeId(carTypeId);
	}

	// update car if existing, otherwise create new one
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public Car UpdateCreateCar(@RequestBody Car car) {
		return carService.updateCreateCar(car);
	}
}

