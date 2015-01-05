package com.sirma.itt.javacourse.chatserver.main;

import com.sirma.itt.javacourse.chatserver.view.ServerView;
import com.sirma.itt.javacourse.chatserver.view.ViewObserver;

/**
 * Runs the server of the chat application.
 * 
 * @author Sinan
 */
public final class Run {

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
		ServerView view = new ServerView();
		ViewObserver viewObserver = new ViewObserver();
		view.addObserver(viewObserver);
	}

}
