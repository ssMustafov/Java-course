package com.sirma.itt.javacourse.chatclient.commands;

import com.sirma.itt.javacourse.chatclient.views.View;
import com.sirma.itt.javacourse.chathelper.utils.Query;

/**
 * @author smustafov
 */
public class ClientDisconnectedCommand extends ClientCommand {

	private Query query;

	/**
	 * @param view
	 */
	public ClientDisconnectedCommand(View view, Query query) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() {
		getClientView().removeOnlineClient(query.getMessage());
		getClientView().appendMessageToChatArea("@" + query.getMessage() + " left");
	}

}
