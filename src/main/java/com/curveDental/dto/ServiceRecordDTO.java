package com.curveDental.dto;

import java.sql.Date;

public class ServiceRecordDTO {

	private Long serviceId;
	private Long service_type_id;
	private Date serviceDate;
	private boolean isAllowed;
	private boolean isChecked;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getService_type_id() {
		return service_type_id;
	}

	public void setService_type_id(Long service_type_id) {
		this.service_type_id = service_type_id;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public boolean isAllowed() {
		return isAllowed;
	}

	public void setAllowed(boolean isAllowed) {
		this.isAllowed = isAllowed;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

}
