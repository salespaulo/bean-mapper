/**
 * alelo-integration-service-impl
 */
package org.zsis.bean.mapper;

/**
 *
 * @author salespaulo
 */
public class MapperException extends RuntimeException {

	/** TODO javadoc */
	private static final long serialVersionUID = -6470509154681599983L;

	/**
	 * TODO javadoc
	 * @param msg
	 * @param cause
	 */
	public MapperException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

}
