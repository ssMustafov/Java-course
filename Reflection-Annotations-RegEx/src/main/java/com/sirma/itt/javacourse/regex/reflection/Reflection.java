package com.sirma.itt.javacourse.regex.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Holds methods for reflection.
 * 
 * @author smustafov
 */
public class Reflection {

	/**
	 * Creates an instance of class by given full class name.
	 * 
	 * @param className
	 *            - the class name of which class to be created
	 * @return instance of the created class
	 */
	public Object instantiateClassByName(String className) {
		Object object = null;
		try {
			Class<?> c = Class.forName(className);
			object = c.newInstance();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (InstantiationException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		}
		return object;
	}

	/**
	 * Prints on the console the parent class of the given class.
	 * 
	 * @param obj
	 *            - the class whom parent class to be printed
	 */
	public void printParentClass(Object obj) {
		Class<?> someClass = obj.getClass();
		System.out.println("Parent class of '" + someClass.getSimpleName() + "' class");
		System.out.printf("\t%s", someClass.getSuperclass().getSimpleName());
		System.out.println();
	}

	/**
	 * Prints on the console all interfaces the given class implements.
	 * 
	 * @param obj
	 *            - the class whom interfaces to be printed
	 */
	public void printInterfaces(Object obj) {
		Class<?> someClass = obj.getClass();
		Class<?>[] interfaces = someClass.getInterfaces();

		System.out.println("Interfaces implemented by '" + someClass.getSimpleName() + "' class");
		if (interfaces.length != 0) {
			for (Class<?> class1 : interfaces) {
				System.out.printf("\t%s", class1.getSimpleName());
				System.out.println();
			}
		} else {
			System.out.println("\t-- No interfaces --");
		}
	}

	/**
	 * Prints on the console all methods signature in given class.
	 * 
	 * @param obj
	 *            - the class whom methods signature to be printed
	 */
	public void printMethods(Object obj) {
		Class<?> someClass = obj.getClass();
		Method[] methods = someClass.getDeclaredMethods();

		System.out.println("Methods in '" + someClass.getSimpleName() + "' class:");
		if (methods.length != 0) {
			for (Method method : methods) {
				method.setAccessible(true);
				System.out.printf("\t%s", method.toGenericString());
				System.out.println();
			}
		} else {
			System.out.println("\t-- No methods --");
		}
	}

	/**
	 * Prints on the console all fields in given class.
	 * 
	 * @param obj
	 *            - the class whom fields to be printed
	 */
	public void printAllFields(Object obj) {
		Class<?> someClass = obj.getClass();
		Field[] fields = someClass.getDeclaredFields();

		System.out.println("Fields in '" + someClass.getSimpleName() + "' class:");
		if (fields.length != 0) {
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					System.out.printf("\tName: %s  Type: %s  Value: %s", field.getName(),
							field.getType(), field.get(obj));
					System.out.println();
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
				} catch (IllegalAccessException e) {
					System.err.println(e.getMessage());
				}
			}
		} else {
			System.out.println("\t-- No fields --");
		}
	}

	/**
	 * Prints on the console all private fields in given class.
	 * 
	 * @param obj
	 *            - the class whom private fields to be printed
	 */
	public void printPrivateFields(Object obj) {
		Class<?> someClass = obj.getClass();
		Field[] fields = someClass.getDeclaredFields();

		System.out.println("Private fields in '" + someClass.getSimpleName() + "' class:");
		if (fields.length != 0) {
			for (Field field : fields) {
				if (Modifier.isPrivate(field.getModifiers())) {
					try {
						field.setAccessible(true);
						System.out.printf("\tName: %s  Type: %s  Value: %s", field.getName(),
								field.getType(), field.get(obj));
					} catch (IllegalArgumentException e) {
						System.err.println(e.getMessage());
					} catch (IllegalAccessException e) {
						System.err.println(e.getMessage());
					}
					System.out.println();
				}
			}
		} else {
			System.out.println("\t-- No private fields --");
		}
	}

	/**
	 * Invokes all private methods of given class.
	 * 
	 * @param obj
	 *            - the class whom private methods will be invoked
	 */
	public void invokeAllPrivateMethods(Object obj) {
		final String stringParameter = "Test";
		int intParameter = 10;
		final long longParameter = 20L;
		final float floatParameter = 3.14f;
		final double doubleParameter = 2.71;

		Class<?> someClass = obj.getClass();

		Method[] methods = someClass.getDeclaredMethods();
		if (methods.length != 0) {
			for (Method method : methods) {
				if (Modifier.isPrivate(method.getModifiers())) {

					System.out.printf("Invoking method '" + method.getName() + "':");
					Class<?>[] paramsTypes = method.getParameterTypes();
					ArrayList<Object> params = new ArrayList<>();

					if (paramsTypes.length != 0) {
						for (int i = 0; i < paramsTypes.length; i++) {
							if ("int".equals(paramsTypes[i].getName())) {
								params.add(intParameter);
								intParameter += 20;
							} else if ("long".equals(paramsTypes[i].getName())) {
								params.add(longParameter);
							} else if ("float".equals(paramsTypes[i].getName())) {
								params.add(floatParameter);
							} else if ("double".equals(paramsTypes[i].getName())) {
								params.add(doubleParameter);
							} else if ("String".equals(paramsTypes[i].getName())) {
								params.add(stringParameter);
							}
						}
					}

					try {
						invokeMethod(obj, method.getName(), params.toArray(), paramsTypes);
					} catch (IllegalArgumentException e) {
						System.err.println(e.getMessage());
					}
				}
			}
		} else {
			System.out.println("\t-- No private methods --");
		}
	}

	/**
	 * Invokes a given method from given class with given parameters.
	 * 
	 * @param obj
	 *            - the class whom method to be invoked
	 * @param methodName
	 *            - the method which to be invoked
	 * @param params
	 *            - the parameters of the method
	 */
	public void invokeMethod(Object obj, String methodName, Object[] params, Class<?>[] paramsType) {
		Class<?> someClass = obj.getClass();
		try {
			Method method = someClass.getDeclaredMethod(methodName, paramsType);
			method.setAccessible(true);
			System.out.println(method.invoke(obj, params));
		} catch (NoSuchMethodException e) {
			System.err.println(e.getMessage());
		} catch (SecurityException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		} catch (InvocationTargetException e) {
			System.err.println(e.getMessage());
		}
	}
}
