package com.curveDental.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curveDental.model.CarType;

@Repository
@Transactional
public class ServiceTypeDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	public void insert(CarType carType) {
		sessionFactory.getCurrentSession().saveOrUpdate(carType);
	}

	public CarType findById(int id) {
		return sessionFactory.getCurrentSession().get(CarType.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<CarType> getCarTypes() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(CarType.class);
		List carTypes = crit.list();
		return carTypes;

	}
}