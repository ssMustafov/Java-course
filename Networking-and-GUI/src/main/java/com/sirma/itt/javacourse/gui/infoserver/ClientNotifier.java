package com.sirma.itt.javacourse.gui.infoserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * Holds a list of connected clients to the server in a client/server application. In a thread it
 * notifies all the clients, except the newly connected client.
 * 
 * @author Sinan
 */
public class ClientNotifier implements Runnable {
	private List<Socket> clients;

	/**
	 * Creates a new client notifier with a given list of connected clients.
	 * 
	 * @param clients
	 *            - list of the connected clients
	 */
	public ClientNotifier(List<Socket> clients) {
		this.clients = clients;
		new Thread(this).start();
	}

	/**
	 * Notifies all the clients, except the newly connected client. {@inheritDoc}
	 */
	@Override
	public void run() {
		synchronized (clients) {
			PrintWriter writer = null;

			try {
				for (int i = 0; i < clients.size() - 1; i++) {
					writer = new PrintWriter(clients.get(i).getOutputStream(), true);
					writer.println("A new client connected - #" + clients.size());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
