/**
 * alelo-integration-domain
 */
package org.zsis.bean.mapper;

/**
 *
 * @author salespaulo
 */
public class IntegerDataMapperConverter implements DataConverter<Integer> {

	/** TODO javadoc */
	private static final long serialVersionUID = -1520788984944557516L;

	/* (non-Javadoc)
	 * @see br.com.alelo.integrador.service.adapter.mapper.DataMapperConverter#convert(java.lang.Object)
	 */
	public Integer convert(final Object value) {
		return Integer.valueOf(value.toString());
	}

}
