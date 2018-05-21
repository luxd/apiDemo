package com.curveDental.model.common;

import java.io.Serializable;

public class AbstractEntity implements EntityWithIdentifier {

    private long id;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getLongId() {
		return 0l;
    }


    @Override
    public int getIntegerId() {
		return 0;
    }


    @Override
    public String getStringId() {
		return null;
    }

    @Override
	public Serializable getObjectId() {
		return null;
	}
}
