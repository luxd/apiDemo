package com.curveDental.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "ServiceType")
@Table(name = "service_type")
public class ServiceType implements Serializable {

	private static final long serialVersionUID = -4481164987604102856L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_type_id", nullable = false)
	private Long serviceTypeId;

	@Column(name = "name", nullable = false, length = 30)
	private String serviceTypeName;

	// @ManyToMany(mappedBy = "serviceTypes")
	// private List<CarType> carTypes = new ArrayList<>();

	public ServiceType() {
	}

	public ServiceType(String name) {
		this.serviceTypeName = name;
	}

	public Long getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

	public String getServiceTypeName() {
		return serviceTypeName;
	}

	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceTypeId == null) ? 0 : serviceTypeId.hashCode());
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
		ServiceType other = (ServiceType) obj;
		if (serviceTypeId == null) {
			if (other.serviceTypeId != null)
				return false;
		} else if (!serviceTypeId.equals(other.serviceTypeId))
			return false;
		return true;
	}

}

