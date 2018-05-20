package com.curveDental.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "CarType")
@Table(name = "car_type")
public class CarType implements Serializable {

	private static final long serialVersionUID = -4904898793481774303L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_type_id", nullable = false)
	private Long carTypeId;

	@Column(name = "name", nullable = false, length = 30)
	private String carTypeName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "cartype_servicetype", joinColumns = @JoinColumn(name = "carType_id"),
		inverseJoinColumns = @JoinColumn(name = "serviceType_id"))
	@JsonIgnore
	private List<ServiceType> serviceTypes = new ArrayList<>();

	public void addServiceType(ServiceType serviceType) {
		serviceTypes.add(serviceType);
		// serviceType.getCarTypes().add(this);
	}

	public void removeServiceType(ServiceType serviceType) {
		serviceTypes.remove(serviceType);
		// serviceType.getCarTypes().remove(this);
	}

	public CarType() {
	}

	public CarType(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public Long getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(Long carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public List<ServiceType> getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carTypeId == null) ? 0 : carTypeId.hashCode());
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
		CarType other = (CarType) obj;
		if (carTypeId == null) {
			if (other.carTypeId != null)
				return false;
		} else if (!carTypeId.equals(other.carTypeId))
			return false;
		return true;
	}

}

