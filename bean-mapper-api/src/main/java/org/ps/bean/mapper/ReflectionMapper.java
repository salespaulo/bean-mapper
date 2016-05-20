package org.ps.bean.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

import org.ps.bean.mapper.DataMapperWrapper.DataMapperType;

/**
 *
 * @author salespaulo
 * @param <T>
 */
@SuppressWarnings("restriction")
class ReflectionMapper implements Mapper {

	class SetMapperContext implements MapperContext {

		private final Set<Object> listTo = new HashSet<Object>();
		private final Set<Object> listFrom = new HashSet<Object>();

		public void addTo(Object to) {
			listTo.add(to);
		}

		public void addFrom(Object from) {
			listFrom.add(from);
		}
	}

	private SetMapperContext context = new SetMapperContext();

	/**
	 * TODO javadoc
	 */
	public ReflectionMapper() {
        super();
	}

	/* (non-Javadoc)
	 * @see Mapper#getContext()
	 */
	public MapperContext getContext() {
		return context;
	}

	/* (non-Javadoc)
	 * @see Mapper#mapData()
	 */
	public void mapData() {
		final Object source = context.listFrom.iterator().next();
		final Object target = context.listTo.iterator().next();

		mapData(source, target);
	}

	private void mapData(final Object source, final Object target) {
		try {
			final Field[] sourceFields =  source.getClass().getDeclaredFields();

			for (Field field: sourceFields) {

				if (field.isAnnotationPresent(DataMapperTo.class)) {
					dataMapperTo(source, target, field);

				} else if (field.isAnnotationPresent(DataMapperWrapper.class)) {
					dataMapperWrapper(source, target, field);

				} else {
					withoutAnnotation(source, target, field);
				}
			}
		} catch (InstantiationException e) {
			throw new MapperException("N\u00e3o foi poss\u00edvel inst\u00e2nciar target class", e);
		} catch (IllegalAccessException e) {
			throw new MapperException("Acesso ilegal à propriedade para mapear.", e);
		} catch (IllegalArgumentException e) {
			throw new MapperException("Argumento ilegal utilizado para recuperar valor da propriedade para mapear.", e);
		} catch (NoSuchFieldException e) {
			throw new MapperException("Propriedade n\u00e3o existente na classe destino para mapear.", e);
		} catch (SecurityException e) {
			throw new MapperException("Erro de segurança em acesso \u00e0 classe de origem.", e);
		} catch (Exception e) {
			throw new MapperException("Erro:" + e.getMessage(), e);
		}
	}

	/**  */
	private void dataMapperWrapper(final Object source, final Object targetObject,
			Field field) throws IllegalAccessException, NoSuchFieldException,
			InstantiationException {

		final DataMapperWrapper wrapper = field.getAnnotation(DataMapperWrapper.class);
		field.setAccessible(true);
		final Object sourceWrapperObject = field.get(source);

		if (wrapper.type().equals(DataMapperType.FIELD)) {
			dataMapperWrapperField(targetObject, sourceWrapperObject);

		} else if (wrapper.type().equals(DataMapperType.CLASS)) {
			dataMapperWrapperClass(targetObject, field, wrapper, sourceWrapperObject);
		}
	}

	/**  */
	private void dataMapperWrapperField(final Object targetObject,
			final Object sourceWrapperObject) throws IllegalAccessException,
			NoSuchFieldException, InstantiationException {

		final Field[] sourceWrapperFields =  sourceWrapperObject.getClass().getDeclaredFields();

		for (Field fieldWrapper: sourceWrapperFields) {
			if (fieldWrapper.isAnnotationPresent(DataMapperTo.class)) {
				dataMapperTo(sourceWrapperObject, targetObject, fieldWrapper);

			} else if (fieldWrapper.isAnnotationPresent(DataMapperWrapper.class)) {
				dataMapperWrapper(sourceWrapperObject, targetObject, fieldWrapper);

			} else {
				withoutAnnotation(sourceWrapperObject, targetObject, fieldWrapper);
			}
		}

	}

	/**  */
	private void dataMapperWrapperClass(final Object targetObject, Field field,
			final DataMapperWrapper wrapper, final Object sourceWrapperObject)
			throws NoSuchFieldException, InstantiationException,
			IllegalAccessException {

		String targetFieldName = wrapper.value();

		if (targetFieldName == null || "".equals(targetFieldName)) {
			targetFieldName = field.getName();
		}

		final Field targetField = targetObject.getClass().getDeclaredField(targetFieldName);
		final Object targetWrapperObject = targetField.getType().newInstance();

		this.mapData(sourceWrapperObject, targetWrapperObject);

		targetField.setAccessible(true);
		targetField.set(targetObject, targetWrapperObject);

	}

	/**  */
	private void dataMapperTo(final Object source, final Object targetObject,
			Field field) throws IllegalAccessException, NoSuchFieldException, InstantiationException {

		final DataMapperTo dataMapperTo = field.getAnnotation(DataMapperTo.class);
		final String targetFieldName = dataMapperTo.value();

		setFieldValue(source, targetObject, field, targetFieldName);
	}

	/**  */
	private void withoutAnnotation(final Object source, final Object targetObject,
			Field field) throws IllegalAccessException, NoSuchFieldException,
			IllegalArgumentException, SecurityException, InstantiationException {

		if (! (field.isAnnotationPresent(XmlTransient.class) ||
				field.isAnnotationPresent(DataMapperTransient.class) ||
				Modifier.isStatic(field.getModifiers()) ||
				Modifier.isTransient(field.getModifiers()) ||
				Modifier.isPublic(field.getModifiers())) ) {
			final String value = field.getName();
			setFieldValue(source, targetObject, field, value);
		}

	}

	/**	 */
	private void setFieldValue(final Object source, final Object targetObject,
			final Field sourceField, final String targetFieldName) throws IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException {

		sourceField.setAccessible(true);

		final Object sourceFieldValue = sourceField.get(source);
		final Field targetField = targetObject.getClass().getDeclaredField(targetFieldName);

		targetField.setAccessible(true);

		if (sourceField.isAnnotationPresent(DataMapperConvert.class)) {
			final DataMapperConvert dataMapperConvert = sourceField.getAnnotation(DataMapperConvert.class);
			final Class<? extends DataConverter<?>> converterClass = dataMapperConvert.value();
			final DataConverter<?> converter = converterClass.newInstance();
			targetField.set(targetObject, converter.convert(sourceFieldValue));
		} else {
			targetField.set(targetObject, sourceFieldValue);
		}
	}

}
