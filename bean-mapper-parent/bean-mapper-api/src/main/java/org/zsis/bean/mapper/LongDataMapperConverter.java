/**
 * alelo-integration-domain
 */
package org.zsis.bean.mapper;

/**
 *
 * @author salespaulo
 */
public class LongDataMapperConverter implements DataConverter<Long> {

	/** TODO javadoc */
	private static final long serialVersionUID = -6376611287219260506L;

	/* (non-Javadoc)
	 * @see br.com.alelo.integrador.service.adapter.mapper.DataMapperConverter#convert(java.lang.Object)
	 */
	public Long convert(final Object value) {
		return Long.valueOf(value.toString());
	}

}
