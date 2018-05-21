package com.curveDental.service;
import java.util.List;

import com.curveDental.model.Car;
import com.curveDental.model.CarType;
import com.curveDental.model.ServiceRecord;
import com.curveDental.model.ServiceType;

public interface CarService {

	List<Car> findAll();

	List<CarType> findAllCarTypes();

	List<ServiceType> findAllServiceTypes();

	List<ServiceRecord> findAllRecordsByCarId(Long carId);

	ServiceRecord updateRecordsByCarId(Long carId, ServiceRecord serviceRecord);

	List<Long> findServiceTypesByCarTypeId(Long carTypeId);

	Car updateCreateCar(Car car);

	Car deleteCar(Long carId);

	ServiceRecord deleteRecordsByServiceId(Long carId, Long serviceId);

}
