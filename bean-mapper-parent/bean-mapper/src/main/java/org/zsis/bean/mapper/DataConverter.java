/**
 * alelo-integration-domain
 */
package org.zsis.bean.mapper;

import java.io.Serializable;

/**
 *
 * @author salespaulo
 */
interface DataConverter <T> extends Serializable {

	/**
	 * TODO javadoc
	 * @param value
	 * @return
	 */
	T convert(Object value);

}
