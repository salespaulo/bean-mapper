

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoBWithLadoAAndOtherPropNames {
	Integer B1;
	Long B2;
	Double B3;
	Short B4;
	Byte B5;
	Boolean B6;
	Character B7;
	String B8;
	LadoA1 B9;
	LadoA2 B10;
	LadoA3 B11;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

