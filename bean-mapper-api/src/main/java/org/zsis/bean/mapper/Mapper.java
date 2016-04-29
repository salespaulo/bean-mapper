package org.zsis.bean.mapper;

public interface Mapper {

	/**
	 * TODO javadoc
	 *
	 * @param source
	 * @return
	 */
	void mapData();

	/**
	 * TODO (salespaulo) - javadoc
	 * @return
	 */
	MapperContext getContext();
}