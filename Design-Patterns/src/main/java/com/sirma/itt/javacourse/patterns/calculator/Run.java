package com.sirma.itt.javacourse.patterns.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Shows how the calculator can be used.
 * 
 * @author smustafov
 */
public final class Run {
	private static final Logger LOGGER = LogManager.getLogger(Run.class);

	/**
	 * Protects from instantiation.
	 */
	private Run() {

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            - arguments
	 */
	public static void main(String[] args) {
		try {
			CalculatorReader r = new ConsoleReader();
			ConsoleCalculator c = new ConsoleCalculator(r);
			c.run();
		} catch (ArithmeticException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (NumberFormatException e) {
			LOGGER.error("Invalid input. Allowed input is: a number, +, -, *, /, ^, 'end'", e);
		}
	}
}
