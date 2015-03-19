

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoB2 {
	LadoA1 a1;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

