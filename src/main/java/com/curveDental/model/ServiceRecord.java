package com.curveDental.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "ServiceRecord")
@Table(name = "service_record")
public class ServiceRecord  implements Serializable {

	private static final long serialVersionUID = -3941260546814893005L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long serviceId;

	@Column(name = "service_date", nullable = false)
	private Date serviceDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", referencedColumnName = "car_id", insertable = false,
		updatable = false)
	private Car car;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id",
		insertable = false,
		updatable = false)
	@JsonIgnore
	private ServiceType serviceType;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
		ServiceRecord other = (ServiceRecord) obj;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}

}

