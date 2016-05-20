

import org.apache.commons.lang3.builder.ToStringBuilder;

public class LadoA3 {
	LadoA1 a1;
	LadoA2 a2;
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

