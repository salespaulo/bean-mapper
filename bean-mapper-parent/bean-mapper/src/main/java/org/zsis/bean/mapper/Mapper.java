package org.zsis.bean.mapper;

import java.io.Serializable;


/**
 *
 * @author salespaulo
 * @param <T>
 */
public interface Mapper extends Serializable {

	/**
	 * TODO javadoc
	 * @param source
	 * @return
	 */
	void mapData(Object source, Object target);

}
