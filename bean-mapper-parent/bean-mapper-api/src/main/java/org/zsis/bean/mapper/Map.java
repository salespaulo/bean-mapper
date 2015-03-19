/**
 * bean-mapper-api
 * &copy; 2013, todos os direitos reservados. Cleever Ideias Technology.
 */
package org.zsis.bean.mapper;

/**
 * TODO (salespaulo) - javadoc
 *
 * @author salespaulo
 *
 */
public final class Map {

	private Mapper mapper;

	public static Map use(Mapper mapper) {
		return new Map(mapper);
	}

	public static void of(final Object source, final Object target) {
		new Map().map(source, target);
	}

	public void map(Object source, Object target) {
		mapper.mapData(source, target);
	}

	private Map() {
		this(new ReflectionMapper());
	}

	private Map(Mapper mapper) {
		super();
		this.mapper = mapper;
	}

}
