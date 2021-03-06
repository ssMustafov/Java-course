package com.sirma.itt.javacourse.threads.producerconsumer;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents a producer.
 * 
 * @author Sinan
 */
public class Producer extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(Producer.class);
	private static final int TIME_TO_WAIT = 700;
	private StoreHouse storeHouse;
	private int time;

	/**
	 * Creates a new producer with default time to wait 700ms.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 */
	public Producer(StoreHouse storeHouse) {
		this(storeHouse, TIME_TO_WAIT);
	}

	/**
	 * Creates a new producer with given time to wait.
	 * 
	 * @param storeHouse
	 *            - the storehouse in which the producer will add production
	 * @param time
	 *            - time the producer to wait
	 */
	public Producer(StoreHouse storeHouse, int time) {
		this.storeHouse = storeHouse;
		this.time = time;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void run() {
		try {
			while (true) {
				String message = new Date().toString();
				LOGGER.info("Producer : put -> " + message);
				storeHouse.put(message);
				wait(time);
			}
		} catch (InterruptedException e) {
			LOGGER.error("Sleep interrupted", e);
		}
	}
}
