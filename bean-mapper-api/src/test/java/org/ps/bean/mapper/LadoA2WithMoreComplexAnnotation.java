package org.ps.bean.mapper;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoA2WithMoreComplexAnnotation {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

