package com.sirma.itt.javacourse.objects.supermarket;

/**
 * Represents person.
 * 
 * @author smustafov
 */
public class Person {

	private String name;
	private int age;

	/**
	 * Creates new person.
	 * 
	 * @param name
	 *            - the person's name to be set
	 * @param age
	 *            - the person's age to be set
	 */
	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	/**
	 * Gets person name.
	 *
	 * @return - the person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets person name.
	 *
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("The person's name cannot be empty");
		}

		this.name = name;
	}

	/**
	 * Gets person age.
	 *
	 * @return - the person's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets person age.
	 *
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("The person's age cannot be under zero");
		}

		this.age = age;
	}

}
