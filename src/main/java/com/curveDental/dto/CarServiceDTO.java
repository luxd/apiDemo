package com.curveDental.dto;

import java.util.ArrayList;
import java.util.List;

public class CarServiceDTO {

	private Long carId;

	private String make;

	private String model;

	private int madeYear;

	private int odometer;

	private String carType;

	private List<ServiceRecordDTO> serviceRecords = new ArrayList<>();

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMadeYear() {
		return madeYear;
	}

	public void setMadeYear(int madeYear) {
		this.madeYear = madeYear;
	}

	public int getOdometer() {
		return odometer;
	}

	public void setOdometer(int odometer) {
		this.odometer = odometer;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public List<ServiceRecordDTO> getServiceRecords() {
		return serviceRecords;
	}

	public void setServiceRecords(List<ServiceRecordDTO> serviceRecords) {
		this.serviceRecords = serviceRecords;
	}

}
