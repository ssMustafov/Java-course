package com.sirma.itt.javacourse.collections.dice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.collections.dice.HashDice} class.
 * 
 * @author smustafov
 */
public class HashDiceTest {

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with normal case of two different combinations.
	 */
	@Test
	public void testHashDiceNormalCase() {
		String[] dices = { "1", "2", "6", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(reader, 2);
		h.generateStatistics();
		String actual = h.getStatistics();
		String expected = "{1,2}: [0]" + System.lineSeparator() + "{6,6}: [1]"
				+ System.lineSeparator();

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with zero counter.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHashDiceWithZeroCounter() {
		String[] dices = { "1", "2", "6", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		new HashDice(reader, 0);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with repeated dices only.
	 */
	@Test
	public void testHashDiceWithRepeatableDicesOnly() {
		String[] dices = { "3", "5", "3", "5", "3", "5" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(reader, 3);
		h.generateStatistics();
		String actual = h.getStatistics();
		String expected = "{3,5}: [0, 1, 2]" + System.lineSeparator();

		assertEquals(expected, actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with three repeated dices and three unique.
	 */
	@Test
	public void testHashDiceWithRepeatableDices() {
		String[] dices = { "3", "5", "2", "1", "3", "5", "6", "6", "3", "5", "1", "6" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(reader, 6);
		h.generateStatistics();
		String actual = h.getStatistics();

		StringBuilder expected = new StringBuilder();
		expected.append("{3,5}: [0, 2, 4]");
		expected.append(System.lineSeparator());
		expected.append("{2,1}: [1]");
		expected.append(System.lineSeparator());
		expected.append("{6,6}: [3]");
		expected.append(System.lineSeparator());
		expected.append("{1,6}: [5]");
		expected.append(System.lineSeparator());

		assertEquals(expected.toString(), actual);
	}

	/**
	 * Tests
	 * {@link com.sirma.itt.javacourse.collections.dice.HashDice#HashDice(com.sirma.itt.javacourse.collections.dice.DiceReader, int, int)}
	 * with one double dice.
	 */
	@Test
	public void testHashDiceWithOneDiceCombinaton() {
		String[] dices = { "4", "4" };
		UnitTestDiceReader reader = new UnitTestDiceReader(dices);
		HashDice h = new HashDice(reader, 1);
		h.generateStatistics();
		String actual = h.getStatistics();

		StringBuilder expected = new StringBuilder();
		expected.append("{4,4}: [0]");
		expected.append(System.lineSeparator());

		assertEquals(expected.toString(), actual);
	}

}
