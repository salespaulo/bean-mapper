/**
 * bean-mapper-api
 * &copy; 2013, todos os direitos reservados. Cleever Ideias Technology.
 */
package org.ps.bean.mapper;

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
		new Map().from(source).to(target).apply();
	}

	public Map from(final Object from) {
		mapper.getContext().addFrom(from);
		return this;
	}

	public Map to(final Object to) {
		mapper.getContext().addTo(to);
		return this;
	}

	public Map to(final Class<?> to) {
		try {
			mapper.getContext().addTo(to.newInstance());
			return this;
		} catch (InstantiationException e) {
			throw new MapperException("N\u00e3o foi poss\u00edvel inst\u00e2nciar target class", e);
		} catch (IllegalAccessException e) {
			throw new MapperException("Acesso ilegal à propriedade para mapear.", e);
		}
	}

	public void apply() {
		mapper.mapData();
	}

	private Map() {
		this(new ReflectionMapper());
	}

	private Map(Mapper mapper) {
		super();
		this.mapper = mapper;
	}

}
