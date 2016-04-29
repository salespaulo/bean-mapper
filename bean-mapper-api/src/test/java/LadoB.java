

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoB {
	Integer B1;
	Long B2;
	Double B3;
	Short B4;
	Byte B5;
	Boolean B6;
	Character B7;
	String B8;
	LadoB1 B9;
	LadoB2 B10;
	LadoB3 B11;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

