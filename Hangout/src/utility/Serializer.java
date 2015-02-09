package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import event.Model;

public class Serializer {

	public Serializer(Class<Model> type, String csv, List<String> attributeOrder) {
		Class<?> clazz;
		Object object = null;
		Method[] methods = type.getMethods();
		String[] attributes = csv.split(",");
		try {
			clazz = Class.forName(type.getCanonicalName());
			Constructor<?> ctor = clazz.getConstructor(String.class);
			object = ctor.newInstance(new Object[] { });
			
			int i = 0;
			for (String attributeType : attributeOrder) {
				for (Method method : methods) {
					if (method.getName().toLowerCase().contains(attributeType.toLowerCase())) {
						method.invoke(object, attributes[i]);
					}
				}
				i++;
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
	}
}
