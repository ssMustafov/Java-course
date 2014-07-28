package com.sirma.itt.javacourse.exceptions.list;

/**
 * @author smustafov
 */
public class ListEmptyException extends RuntimeException {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new ListEmptyException.
	 */
	public ListEmptyException() {
		super("The list is empty");
	}

	/**
	 * Creates a new ListEmptyException with given message.
	 * 
	 * @param message
	 *            - the message of the exception to be set
	 */
	public ListEmptyException(String message) {
		super(message);
	}

}
