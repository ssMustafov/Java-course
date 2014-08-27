package com.sirma.itt.javacourse.collections.manager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds a functionality for ordering combination of messages with predefined combination of
 * messages in one string.
 * 
 * @author smustafov
 */
public class ExceptionsMessageManager {

	private static final String SEPARATOR = "|";
	private static Map<String, String> exceptions = new HashMap<>();
	private StringBuilder message;

	/**
	 * Creates a new exceptions message manager with given predefined messages.
	 * 
	 * @param exceptionMessages
	 *            - predefined messages
	 */
	public ExceptionsMessageManager(ExceptionMessages... exceptionMessages) {
		for (int i = 0; i < exceptionMessages.length; i++) {
			exceptions.put(exceptionMessages[i].name(), exceptionMessages[i].getMessage());
		}
		message = new StringBuilder();
	}

	/**
	 * Adds the given message to the combination of messages.
	 * 
	 * @param message
	 *            - the message to be added
	 */
	private void addMessage(String message) {
		if (this.message.length() > 0) {
			this.message.append(SEPARATOR);
		}

		this.message.append(message);
	}

	/**
	 * Adds given message to the combination of messages.
	 * 
	 * @param message
	 *            - the message to be added to the combination of messages
	 */
	public void addExceptionMessage(String message) {
		if (!exceptions.containsValue(message)) {
			throw new IllegalArgumentException("There is no such message");
		}

		addMessage(message);
	}

	/**
	 * Adds message by given code into the combination of messages.
	 * 
	 * @param messageCode
	 *            - the code of the message
	 */
	public void addExceptionMessageUsingCode(String messageCode) {
		if (!exceptions.containsKey(messageCode)) {
			throw new IllegalArgumentException("There is no such message code");
		}

		String message = exceptions.get(messageCode);
		addMessage(message);
	}

	/**
	 * Returns the combination of messages.
	 * 
	 * @return - the combination of messages
	 */
	public String getMessage() {
		return message.toString();
	}

	/**
	 * Splits the given combination of messages and returns them as <code>Collection</code>.
	 * 
	 * @param messagesCombination
	 *            - combination of messages
	 * @return - collection of messages
	 */
	public static Collection<String> getMessages(String messagesCombination) {
		String regex = "\\" + SEPARATOR;
		String[] separatedMessages = messagesCombination.split(regex);
		Collection<String> collection = Arrays.asList(separatedMessages);

		return collection;
	}
}
