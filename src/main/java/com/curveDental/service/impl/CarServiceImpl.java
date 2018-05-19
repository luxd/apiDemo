package com.curveDental.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curveDental.dao.GenericHibernateDao;
import com.curveDental.dto.ServiceRecordDTO;
import com.curveDental.model.Car;
import com.curveDental.model.CarType;
import com.curveDental.model.ServiceType;
import com.curveDental.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	GenericHibernateDao<Car> carDAO;
	GenericHibernateDao<CarType> carTypeDAO;

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
	public List<ServiceRecordDTO> findAllRecordsByCarId(Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServiceType> findAllServiceTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}