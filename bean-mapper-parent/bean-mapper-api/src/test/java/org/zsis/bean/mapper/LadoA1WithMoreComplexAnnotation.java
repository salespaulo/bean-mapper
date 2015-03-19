package org.zsis.bean.mapper;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoA1WithMoreComplexAnnotation {

	@DataMapperTo("b")
	String a;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

