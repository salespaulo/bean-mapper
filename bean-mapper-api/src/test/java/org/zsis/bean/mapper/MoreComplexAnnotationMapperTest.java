package org.zsis.bean.mapper;

import org.junit.Test;

public class MoreComplexAnnotationMapperTest {

	@Test
	public void test() {
		LadoAWithMoreComplexAnnotation ladoA = new LadoAWithMoreComplexAnnotation();
		LadoA1WithMoreComplexAnnotation ladoA1 = new LadoA1WithMoreComplexAnnotation();
		LadoA2WithMoreComplexAnnotation ladoA2 = new LadoA2WithMoreComplexAnnotation();
		LadoA3WithMoreComplexAnnotation ladoA3 = new LadoA3WithMoreComplexAnnotation();

		ladoA1.a = "Teste";
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

		LadoBWithPropsLadoB1 ladoB = new LadoBWithPropsLadoB1();
		Map.of(ladoA, ladoB);

		// Example of custom mapper
		Map.use(new Mapper() {
			public void mapData() {
				// Implement here!!!!
			}

			public MapperContext getContext() {
				// TODO Auto-generated method stub
				return new MapperContext() {
					public void addTo(Object to) {
						// TODO Auto-generated method stub
					}

					public void addFrom(Object from) {
						// TODO Auto-generated method stub
					}
				};
			}
		}).from(ladoA).to(ladoB).apply();;
		// Example of custom mapper

		System.out.println(ladoB);
	}

}
