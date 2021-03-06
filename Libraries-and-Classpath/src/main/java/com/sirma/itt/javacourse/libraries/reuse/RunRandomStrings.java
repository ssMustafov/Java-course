package com.sirma.itt.javacourse.libraries.reuse;

import com.sirma.itt.javacourse.intro.strings.RandomString;

/**
 * Uses the code from Intro-Java project as jar library.
 * 
 * @author smustafov
 */
public final class RunRandomStrings {

	/**
	 * Default constructor.
	 */
	private RunRandomStrings() {

	}

	/**
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		RandomString randomString = new RandomString();
		System.out.println(randomString.generateString(25));
		System.out.println(randomString.generateStringAscii(25));
		System.out.println(randomString.generateStringAsciiCode(25));

	}

}
