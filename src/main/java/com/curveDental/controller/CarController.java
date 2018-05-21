package com.curveDental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.curveDental.model.Car;
import com.curveDental.model.CarType;
import com.curveDental.model.ServiceRecord;
import com.curveDental.service.CarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	public ResponseEntity<List<ServiceRecord>> listAllCarService(@PathVariable Long carId) {
		List<ServiceRecord> list = carService.findAllRecordsByCarId(carId);
		return new ResponseEntity<List<ServiceRecord>>(list, HttpStatus.OK);

	}

	// save service records for a specific car
	@RequestMapping(value = "/car/{carId}/services", method = RequestMethod.POST)
	public ResponseEntity<ServiceRecord> updateCarServiceRecords(@PathVariable Long carId,
		@RequestBody ServiceRecord serviceRecord) {
		ServiceRecord record = carService.updateRecordsByCarId(carId, serviceRecord);
		return new ResponseEntity<ServiceRecord>(record, HttpStatus.OK);

	}

	// delete service records for a specific car
	@RequestMapping(value = "/car/{carId}/services/{serviceId}", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceRecord> deleteCarServiceRecord(@PathVariable Long carId,
		@PathVariable Long serviceId) {
		ServiceRecord record = carService.deleteRecordsByServiceId(carId, serviceId);
		if (record == null)
			return new ResponseEntity<ServiceRecord>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<ServiceRecord>(HttpStatus.NO_CONTENT);

	}

	// get all available service types for a specific car type
	@RequestMapping(value = "/car_type/{carTypeId}/service_types", method = RequestMethod.GET)
	public List<Long> listAllServiceTypes(@PathVariable Long carTypeId) {
		return carService.findServiceTypesByCarTypeId(carTypeId);
	}

	// update car if existing, otherwise create new one
	@RequestMapping(value = "/car", method = RequestMethod.POST)
	public ResponseEntity<Car> updateCreateCar(@RequestBody Car car) {
		Car newCar = carService.updateCreateCar(car);
		return new ResponseEntity<Car>(newCar, HttpStatus.OK);
	}

	// update car if existing, otherwise create new one
	@RequestMapping(value = "/car/{carId}", method = RequestMethod.DELETE)
	public ResponseEntity<Car> deleteCar(@PathVariable Long carId) {
		Car car = carService.deleteCar(carId);
		if (car == null)
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
	}

}

