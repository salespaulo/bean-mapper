/**
 * alelo-integration-domain
 */
package org.ps.bean.mapper;

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
public @interface DataMapperTransient {

}
