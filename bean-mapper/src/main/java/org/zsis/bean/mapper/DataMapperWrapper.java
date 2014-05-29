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
@Target({ ElementType.FIELD })
public @interface DataMapperWrapper {

	/**
	 *
	 * @author salespaulo
	 */
	public enum DataMapperType {
		FIELD, CLASS;
	}

	/**
	 * TODO javadoc
	 * @return
	 */
	public String value() default "";

	/**
	 * TODO javadoc
	 * @return
	 */
	public DataMapperType type() default DataMapperType.CLASS;
}
