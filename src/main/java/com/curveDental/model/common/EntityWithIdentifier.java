package com.curveDental.model.common;

import java.io.Serializable;

public interface EntityWithIdentifier {
    /**
     * Get entity identifier.
     * @return
     */
    long getId();

    /**
     * Set entity identifier.
     * @param id
     */
    void setId(final long id);

    /**
     *
     * @return
     * @deprecated will be replaced with {@link #getId() getId}
     */
    long getLongId();



    /**
     *
     * @return
     * @deprecated will be replaced with {@link #getId() getId}
     */
    int getIntegerId();



    /**
     *
     * @return
     * @deprecated will be replaced with {@link #getId() getId}
     */
    String getStringId();



	/**
	 *
	 * @return
	 * @deprecated will be replaced with {@link #getId() getId}
	 */
	Serializable getObjectId();

}
