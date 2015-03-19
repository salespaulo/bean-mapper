/**
 * alelo-integration-domain
 */
package org.zsis.bean.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author salespaulo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD } )
public @interface DataMapperConvert {

	/**
	 * TODO javadoc
	 * @return
	 */
	public Class<? extends DataConverter<?>> value();

}
