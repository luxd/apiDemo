package com.curveDental.service;
import java.util.List;

import com.curveDental.dto.ServiceRecordDTO;
import com.curveDental.model.Car;
import com.curveDental.model.CarType;
import com.curveDental.model.ServiceType;

public interface CarService {

	List<Car> findAll();

	List<CarType> findAllCarTypes();

	List<ServiceType> findAllServiceTypes();

	List<ServiceRecordDTO> findAllRecordsByCarId(Long carId);

}
