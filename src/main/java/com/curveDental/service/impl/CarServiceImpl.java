package com.curveDental.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curveDental.constants.Constants;
import com.curveDental.dao.GenericHibernateDao;
import com.curveDental.exception.ValidationException;
import com.curveDental.model.Car;
import com.curveDental.model.CarType;
import com.curveDental.model.ServiceRecord;
import com.curveDental.model.ServiceType;
import com.curveDental.service.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	GenericHibernateDao<Car> carDAO;
	GenericHibernateDao<CarType> carTypeDAO;
	GenericHibernateDao<ServiceType> serviceTypeDAO;

	@Autowired
	public void setCarDao(GenericHibernateDao<Car> daoToSet) {
		carDAO = daoToSet;
		carDAO.setClazz(Car.class);
	}

	@Autowired
	public void setCarTypeDao(GenericHibernateDao<CarType> daoToSet) {
		carTypeDAO = daoToSet;
		carTypeDAO.setClazz(CarType.class);
	}

	@Autowired
	public void setServiceTypeDao(GenericHibernateDao<ServiceType> daoToSet) {
		serviceTypeDAO = daoToSet;
		serviceTypeDAO.setClazz(ServiceType.class);
	}


	public List<Car> findAll() {
		List<Car> carList = new ArrayList<>();
		carList = carDAO.findAll();
		return carList;
    }

	@Override
	public List<CarType> findAllCarTypes() {
		List<CarType> carTypeList = new ArrayList<>();
		carTypeList = carTypeDAO.findAll();
		return carTypeList;
	}

	@Override
	public List<ServiceRecord> findAllRecordsByCarId(Long carId) {
		Car car = carDAO.findOne(carId);
		if (car == null)
			throw new ValidationException(Constants.INVALID_CAR_ID, Constants.VALIDATION_ERROR);
		// Hibernate.initialize(car.getRecords());
		for (ServiceRecord record : car.getRecords()) {
			Hibernate.initialize(record.getServiceTypes());
		}
		return car.getRecords();
		// List<ServiceRecord> records = car.getRecords();
		// List<ServiceType> serviceTypes = serviceTypeDAO.findAll();
		// List<ServiceRecordDTO> recordDTOs = new ArrayList<>();
		// for (ServiceRecord record : records) {
		// boolean isChecked = false;
		// boolean isAllowed = false;
		// for (ServiceType serviceType : serviceTypes) {
		// if (serviceType.getServiceTypeId() ==
		// record.getServiceType().getServiceTypeId()) {
		// isChecked = true;
		// break;
		// }
		// }
		// Long serviceId = record.getServiceId();
		// Long service_type_id = record.getServiceType().getServiceTypeId();
		// Date serviceDate = record.getServiceDate();
		//
		// recordDTOs.add(new ServiceRecordDTO(serviceId, service_type_id,
		// serviceDate, isAllowed,
		// isChecked));
		// }
		// return recordDTOs;
		// return null;
	}

	@Override
	public List<ServiceType> findAllServiceTypes() {
		return serviceTypeDAO.findAll();
	}

	@Override
	public List<Long> findServiceTypesByCarTypeId(Long carTypeId) {
		List<Long> rtn = new ArrayList<>();
		CarType carType = carTypeDAO.findOne(carTypeId);
		for(ServiceType serviceType : carType.getServiceTypes()){
			rtn.add(serviceType.getServiceTypeId());
		}
			
			
			
//		List<ServiceType> serviceTypes = serviceTypeDAO.findAll();
//		for (ServiceType serviceType : serviceTypes) {
//			CarType carType = carTypeDAO.findOne(carTypeId);
//			boolean isAllowed = false;
//			if (carType.getServiceTypes().contains(serviceType))
//				isAllowed = true;
//			rtn.add(new ServiceTypeDTO(serviceType.getServiceTypeId(),
//				serviceType.getServiceTypeName(), isAllowed));
//		}
		return rtn;
	}

	// when changing carType, the service record may be deleted as service may
	// be not allowed after change
	@Override
	public Car updateCreateCar(Car car) {
		if (car.getCarId() == null || car.getCarId() == 0) {
			Long id = carDAO.create(car);
			car.setCarId(id);
		} else {
			Car newCar = carDAO.findOne(car.getCarId());
			if (newCar == null) {
				car.setCarId(null);
				Long id = carDAO.create(car);
				car.setCarId(id);
			} else {
				newCar.setCarId(car.getCarId());
				newCar.setCarTypeId(car.getCarTypeId());
				newCar.setMake(car.getMake());
				newCar.setMadeYear(car.getMadeYear());
				newCar.setModel(car.getModel());
				newCar.setOdometer(car.getOdometer());
				carDAO.update(newCar);
			}
		}
		return car;
	}

	@Override
	public Car deleteCar(Long carId) {
		Car car = carDAO.findOne(carId);
		if (car == null) {
			return null;
		}
		carDAO.delete(car);
		return car;

	}

}