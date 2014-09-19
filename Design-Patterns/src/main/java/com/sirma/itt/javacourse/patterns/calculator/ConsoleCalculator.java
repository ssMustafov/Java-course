package com.sirma.itt.javacourse.patterns.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Executes commands given from some stream to work with the Calculator.
 * 
 * @author smustafov
 */
public class ConsoleCalculator {

	private static final String END_READING = "end";
	private static final String ADDITION_OPERATION = "+";
	private static final String SUBTRACTION_OPERATION = "-";
	private static final String MULTIPLICATION_OPERATION = "*";
	private static final String DIVISION_OPERATION = "/";
	private static final String POWERING_OPERATION = "^";
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private CalculatorManager manager = new CalculatorManager();

	/**
	 * Launches the calculator. The reading always must start with number and every line must
	 * contain only one command (an integer number, operation or end of reading).
	 * 
	 * @throws IOException
	 *             - thrown when I/O exception occurs
	 */
	public void run() throws IOException {
		Operations operation = null;
		String firstLine = reader.readLine();
		long number = Long.parseLong(firstLine);
		manager.setResult(number);

		while (true) {
			String line = reader.readLine();
			line = line.trim();
			line = line.toLowerCase();

			if (END_READING.equals(line)) {
				break;
			} else if (ADDITION_OPERATION.equals(line)) {
				operation = Operations.Add;
			} else if (SUBTRACTION_OPERATION.equals(line)) {
				operation = Operations.Subtract;
			} else if (DIVISION_OPERATION.equals(line)) {
				operation = Operations.Divide;
			} else if (MULTIPLICATION_OPERATION.equals(line)) {
				operation = Operations.Multiply;
			} else if (POWERING_OPERATION.equals(line)) {
				operation = Operations.Power;
			} else {
				number = Long.parseLong(line);
				manager.compute(operation, number);
				System.out.println("Result: " + manager.getResult());
			}
		}
	}
}