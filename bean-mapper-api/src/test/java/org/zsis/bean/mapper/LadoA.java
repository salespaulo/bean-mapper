package org.zsis.bean.mapper;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoA {
	Integer A1;
	Long A2;
	Double A3;
	Short A4;
	Byte A5;
	Boolean A6;
	Character A7;
	String A8;
	LadoA1 A9;
	LadoA2 A10;
	LadoA3 A11;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
