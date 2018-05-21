package com.curveDental;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.curveDental.dao.GenericHibernateDao;
import com.curveDental.model.Car;
import com.curveDental.model.ServiceRecord;
import com.curveDental.model.ServiceType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resource/mvc-dispatcher-servlet.xml")
@Transactional
public class CarApiTest extends AbstractJUnit4SpringContextTests {

	static final String API_URL = "http://localhost:8080/APIDemo";
	GenericHibernateDao<ServiceType> serviceTypeDAO;

	@Autowired
	public void setServiceTypeDao(GenericHibernateDao<ServiceType> daoToSet) {
		serviceTypeDAO = daoToSet;
		serviceTypeDAO.setClazz(ServiceType.class);
	}

	@Test
	public void addCarWorksOK() {

		RestTemplate template = new RestTemplate();
		Car car = new Car();
		car.setCarTypeId(1L);
		car.setMake("Toyota");
		car.setModel("Corolla");
		car.setMadeYear(2010);
		car.setOdometer(90000);
		ResponseEntity<Void> resultSave = template
			.postForEntity(API_URL + "/car", car, Void.class);
		assertNotNull(resultSave);

	}

	@Test
	public void getAllCarsWorksOK() {

		RestTemplate template = new RestTemplate();
		ResponseEntity<List> resultList = template
			.getForEntity(API_URL + "/cars", List.class);
		assertNotNull(resultList);
		assertNotNull(resultList.getBody());
		assertTrue(resultList.getBody().size() > 1);
		assertThat(((Map) resultList.getBody().get(0)).entrySet().toArray()[1].toString(),
			is("make=Honda"));
	}

	@Test
	public void getAllCarTypesWorksOK() {

		RestTemplate template = new RestTemplate();
		ResponseEntity<List> result = template.getForEntity(API_URL + "/car_types", List.class);
		assertNotNull(result);
		assertNotNull(result.getBody());
		assertThat(((Map) result.getBody().get(0)).entrySet().toArray()[1].toString(),
			is("carTypeName=Gas"));
	}

	@Test
	public void getAllCarServicesWorksOK() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<List> result = template.getForEntity(API_URL + "/car/1/services",
			List.class);
		assertNotNull(result);
		assertNotNull(result.getBody());
		assertTrue(result.getBody().size() > 1);
		assertThat(((Map) result.getBody().get(0)).entrySet().toArray()[1].toString(),
			is("serviceDate=1461124800000"));
	}

	@Test
	public void saveCarServicesWorksOK() throws ParseException {
		RestTemplate template = new RestTemplate();
		ServiceRecord record = new ServiceRecord();
		record.setServiceDate(new SimpleDateFormat("dd/MM/yyyy").parse("21/05/2018"));
		record.setCarId(1L);
		record.setServiceId(0L);
		ServiceType serviceType = serviceTypeDAO.findOne(1L);
		record.addServiceType(serviceType);
		
		ResponseEntity<Void> result = template.postForEntity(API_URL + "/car/1/services", record,
			Void.class);
		assertNotNull(result);
		assertThat(result.getStatusCode().value(), is(200));
	}

	// car/{carId}/services/{serviceId}
	@Test
	public void deleteCarServicesWorksOK() throws ParseException {
		RestTemplate template = new RestTemplate();
		template.delete(API_URL + "/car/1/services/1");
		// assertThat(result.getStatusCode().value(), is(200));
	}

	/// car_type/{carTypeId}/service_types
	@Test
	public void getServieTypesWorksOK() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<List> result = template.getForEntity(API_URL + "/car_type/1/service_types",
			List.class);
		assertNotNull(result);
		assertNotNull(result.getBody());
		assertTrue(result.getBody().size() > 1);
	}

}
