package com.curveDental.exception;

import java.io.Serializable;

import com.curveDental.model.common.EntityWithIdentifier;

public class ObjectNotFoundException extends ApplicationException {

	public static final String ERROR_CODE_DEFAULT = "resource-not-found";

	protected Class<? extends EntityWithIdentifier>  persistentClass;

	public ObjectNotFoundException(Class<? extends EntityWithIdentifier> persistentClass) {
		super(persistentClass.getName());
		this.persistentClass = persistentClass;
		setErrorCode(generateErrorCode());
	}

	public ObjectNotFoundException(Class<? extends EntityWithIdentifier> persistentClass, int id) {
		super(persistentClass.getName() +  "[id:" + id +"]");
		this.persistentClass = persistentClass;
		setErrorCode(generateErrorCode());
	}

	public ObjectNotFoundException(Class<? extends EntityWithIdentifier> persistentClass, long id) {
		super(persistentClass.getName() +  "[id:" + id +"]");
		this.persistentClass = persistentClass;
		setErrorCode(generateErrorCode());
	}

	public ObjectNotFoundException(Class<? extends EntityWithIdentifier> persistentClass, String id) {
		super(persistentClass.getName() +  "[id:" + id +"]");
		this.persistentClass = persistentClass;
		setErrorCode(generateErrorCode());
	}

	public ObjectNotFoundException(Class<? extends EntityWithIdentifier> persistentClass,
		Serializable id) {
		super(persistentClass.getName() + "[id:" + id + "]");
		this.persistentClass = persistentClass;
		setErrorCode(generateErrorCode());
	}

	public ObjectNotFoundException(String message, Throwable t) {
		super(message, t);
		setErrorCode(generateErrorCode());
	}

	private String generateErrorCode(){

		if( this.persistentClass != null ){
			String clzName = this.persistentClass.getSimpleName();
			return clzName.toLowerCase().charAt(0) + clzName.substring(1) + "-not-found";
		}

		return ERROR_CODE_DEFAULT;
	}
}
