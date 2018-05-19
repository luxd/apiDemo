package com.curveDental.dto;

public class ServiceTypeDTO {

	private Long serviceTypeId;

	private String serviceTypeName;

	private boolean isAllowed;

	public ServiceTypeDTO(Long serviceTypeId, String serviceTypeName, boolean isAllowed) {
		super();
		this.serviceTypeId = serviceTypeId;
		this.serviceTypeName = serviceTypeName;
		this.isAllowed = isAllowed;
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

	public boolean isAllowed() {
		return isAllowed;
	}

	public void setAllowed(boolean isAllowed) {
		this.isAllowed = isAllowed;
	}


}
