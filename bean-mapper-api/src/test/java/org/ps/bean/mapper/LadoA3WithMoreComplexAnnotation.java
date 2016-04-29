package org.ps.bean.mapper;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoA3WithMoreComplexAnnotation {
	@DataMapperWrapper
	LadoA2WithMoreComplexAnnotation a2;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

