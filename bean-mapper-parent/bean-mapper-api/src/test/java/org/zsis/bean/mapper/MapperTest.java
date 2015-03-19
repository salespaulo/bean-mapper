package org.zsis.bean.mapper;

import static org.junit.Assert.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

public class MapperTest {

	class LadoA {
		private Integer A1;
		private Long A2;
		private Double A3;
		private Short A4;
		private Byte A5;
		private Boolean A6;
		private Character A7;
		private String A8;
		private LadoA1 A9;
		private LadoA2 A10;
		private LadoA3 A11;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoA1 {
		private String a;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoA2 {
		private LadoA1 a1;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoA3 {
		private LadoA1 a1;
		private LadoA2 a2;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoB {
		private Integer A1;
		private Long A2;
		private Double A3;
		private Short A4;
		private Byte A5;
		private Boolean A6;
		private Character A7;
		private String A8;
		private LadoA1 A9;
		private LadoA2 A10;
		private LadoA3 A11;
		
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoB1 {
		private String a;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoB2 {
		private LadoA1 a1;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	class LadoB3 {
		private LadoA1 a1;
		private LadoA2 a2;
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
	}
	
	@Test
	public void test() {
		LadoA ladoA = new LadoA();
		LadoA1 ladoA1 = new LadoA1();
		LadoA2 ladoA2 = new LadoA2();
		LadoA3 ladoA3 = new LadoA3();

		ladoA1.a = "Teste";
		ladoA2.a1 = ladoA1;
		ladoA3.a1 = ladoA1;
		ladoA3.a2 = ladoA2;
		
		ladoA.A1 = 1;
		ladoA.A2 = 2l;
		ladoA.A3 = 3.0;
		ladoA.A4 = 4;
		ladoA.A5 = 5;
		ladoA.A6 = true;
		ladoA.A7 = '6';
		ladoA.A8 = "7";
		ladoA.A9 = ladoA1;
		ladoA.A10 = ladoA2;
		ladoA.A11 = ladoA3;
		
		LadoB ladoB = new LadoB();
		ReflectionMapper.of(ladoA, ladoB);
		
		System.out.println(ladoB);
	}

}
