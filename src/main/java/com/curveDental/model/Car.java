package com.curveDental.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Car")
@Table(name = "car")
public class Car implements Serializable {

	private static final long serialVersionUID = 6566063169012898575L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id", nullable = false)
	private Long carId;

	@Column(name = "make", nullable = false, length = 30)
	private String make;

	@Column(name = "model", nullable = false, length = 30)
	private String model;

	@Column(name = "madeyear", nullable = false)
	private int madeYear;

	@Column(name = "odometer", nullable = false)
	private int odometer;

	@Column(name = "car_type_id", nullable = false)
	private Long carTypeId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "car_type_id", referencedColumnName = "car_type_id", insertable = false,
		updatable = false)
	@JsonIgnore
	private CarType carType;

	@OneToMany(mappedBy = "car", fetch = FetchType.LAZY, orphanRemoval = true,
		cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<ServiceRecord> records = new ArrayList<>();


	public Car() {

	}

	public Car(Long carId, String make, String model, int madeYear, int odometer, Long carTypeId,
		CarType carType, List<ServiceRecord> records) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.madeYear = madeYear;
		this.odometer = odometer;
		this.carTypeId = carTypeId;
		this.carType = carType;
		this.records = records;
	}

	public Long getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Long carTypeId) {
		this.carTypeId = carTypeId;
	}

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

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public List<ServiceRecord> getRecords() {
		return records;
	}

	public void setRecords(List<ServiceRecord> records) {
		this.records = records;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		return true;
	}

}

