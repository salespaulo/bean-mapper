package org.zsis.bean.mapper;

import org.junit.Test;

public class BasicAnnotationMapperTest {

	@Test
	public void test() {
		LadoAWithBasicAnnotation ladoA = new LadoAWithBasicAnnotation();
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

		LadoBWithLadoAAndOtherPropNames ladoB = new LadoBWithLadoAAndOtherPropNames();
		Map.of(ladoA, ladoB);

		// Example of custom mapper
		Map.use(new Mapper() {
			public void mapData(Object source, Object target) {
				// Implement here!!!!
			}
		}).map(ladoA, ladoB);
		// Example of custom mapper

		System.out.println(ladoB);
	}

}
