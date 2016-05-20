

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.ps.bean.mapper.DataMapperTo;
import org.ps.bean.mapper.DataMapperWrapper;

public class LadoAWithMoreAnnotation {
	@DataMapperTo("B1")
	Integer A1;
	@DataMapperTo("B2")
	Long A2;
	@DataMapperTo("B3")
	Double A3;
	@DataMapperTo("B4")
	Short A4;
	@DataMapperTo("B5")
	Byte A5;
	@DataMapperTo("B6")
	Boolean A6;
	@DataMapperTo("B7")
	Character A7;
	@DataMapperTo("B8")
	String A8;
	@DataMapperWrapper("B9")
	LadoA1 A9;
	@DataMapperWrapper("B10")
	LadoA2 A10;
	@DataMapperWrapper("B11")
	LadoA3 A11;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
