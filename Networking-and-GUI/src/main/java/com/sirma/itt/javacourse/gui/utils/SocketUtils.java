package com.sirma.itt.javacourse.gui.utils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Holds utility methods for opening a sockets for a client and a server.
 * 
 * @author Sinan
 */
public final class SocketUtils {
	public static final int PORTS_START_RANGE = 7000;
	public static final int PORTS_END_RANGE = 7020;
	public static final String HOST = "localhost";

	/**
	 * Protects from instantiation.
	 */
	private SocketUtils() {
	}

	/**
	 * Opens a client socket between 7000-7020.
	 * 
	 * @return - the socket at the first available port
	 * @throws IOException
	 *             - thrown
	 */
	public static Socket openSocket() throws IOException {
		for (int port = PORTS_START_RANGE; port <= PORTS_END_RANGE; port++) {
			try {
				return new Socket(HOST, port);
			} catch (IOException e) {
				// try the next port
			}
		}

		throw new IOException(String.format("No running server sockets in ports range [%s...%s]",
				PORTS_START_RANGE, PORTS_END_RANGE));
	}

	/**
	 * Opens a server socket between 7000-7020.
	 * 
	 * @return - the server socket at the first available port
	 * @throws IOException
	 *             - thrown
	 */
	public static ServerSocket openServerSocket() throws IOException {
		for (int port = PORTS_START_RANGE; port <= PORTS_END_RANGE; port++) {
			try {
				return new ServerSocket(port);
			} catch (IOException e) {
				// try the next port
			}
		}

		throw new IOException(String.format("No available ports in the range [%s...%s]",
				PORTS_START_RANGE, PORTS_END_RANGE));
	}
}
