

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoBWithSameLadoAPropNames {
	Integer A1;
	Long A2;
	Double A3;
	Short A4;
	Byte A5;
	Boolean A6;
	Character A7;
	String A8;
	LadoB1 A9;
	LadoB2 A10;
	LadoB3 A11;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

