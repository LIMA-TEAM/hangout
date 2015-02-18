/*package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.google.gson.Gson;

public class Serializer {

	public static String serializeCSVToJSON(Class<?> type, String csv, String attributeOrderCSV) {
		Class<?> clazz;
		Object object = null;
		Method[] methods = type.getMethods();
		String[] attributes = csv.split(",");
		String[] attributeOrder = attributeOrderCSV.split(",");
		boolean stringParam = false;
		try {
			clazz = Class.forName(type.getCanonicalName());
			Constructor<?> ctor = clazz.getConstructor();
			object = ctor.newInstance(new Object[] { });
			
			int i = 0;
			for (String attributeType : attributeOrder) {
				for (Method method : methods) {
					stringParam = true;
					if (method != null) {
						method.getP
						if (method.getParameterCount() > 0) {
							Parameter[] parameters = method.getParameters();
							for (Parameter param : parameters) {
								if (param.getType().getCanonicalName().toLowerCase().contains("string")) {
									stringParam = true;
								}
							}
							if (method.getName().toLowerCase().contains(attributeType.toLowerCase()) && stringParam && method.getName().toLowerCase().contains("set")) {
								try {
									method.invoke(object, attributes[i]);
	//								System.out.println("Invoking: " + method.getName() + "\n\tArgument: " + attributes[i]);
								} catch(IllegalArgumentException e) {}
								
							}
						}
					}
				}
				i++;
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return (new Gson()).toJson(object);
	}
	
	public static Object serializeConstructor(Class<?> type, String csv, String attributeOrderCSV) {
		Class<?> clazz;
		Object object = null;
		Method[] methods = type.getMethods();
		String[] attributes = csv.split(",");
		String[] attributeOrder = attributeOrderCSV.split(",");
		boolean stringParam = false;
		try {
			clazz = Class.forName(type.getCanonicalName());
			Constructor<?> ctor = clazz.getConstructor();
			object = ctor.newInstance(new Object[] { });
			Constructor<?> constructor = getConstructor(type);
			constructor.newInstance(initargs)
			// below likely not needed
			int i = 0;
			for (String attributeType : attributeOrder) {
				for (Method method : methods) {
					stringParam = true;
					Parameter[] parameters = method.getParameters();
					for (Parameter param : parameters) {
						if (param.getType().getCanonicalName().toLowerCase().contains("string")) {
							stringParam = true;
						}
					}
					if (method.getName().toLowerCase().contains(attributeType.toLowerCase()) && stringParam && method.getName().toLowerCase().contains("set")) {
						try {
							method.invoke(object, attributes[i]);
							System.out.println("Invoking: " + method.getName() + "\n\tArgument: " + attributes[i]);
						} catch(IllegalArgumentException e) {}
						
					}
				}
				i++;
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return (new Gson()).toJson(object);
	}
	
	private static Constructor<?> getConstructor(Class<?> type) {
		Constructor<?>[] constructors = type.getConstructors();
		for (Constructor<?> construct : constructors) {
			Parameter[] params = construct.getParameters();
			int count = 0;
			for (Parameter param : params) {
				if (param.getType().getCanonicalName().toLowerCase().contains("string")) {
					count++;
				}
			}
			if (count == params.length) {
				return construct;
			}
		}
		
		return null;
	}
}
*/