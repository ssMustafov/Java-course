package com.sirma.itt.javacourse.patterns.pool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool} class.
 * 
 * @author smustafov
 */
public class ObjectPoolTest {

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#acquire()} when there is no
	 * available objects in the pool.
	 */
	@Test(expected = IllegalAccessError.class)
	public void testAcquireWhenNoAvailableObjects() {
		ObjectPool pool = new ObjectPool(4);
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
		pool.acquire();
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#release(VeryHeavyClass)} with
	 * acquired objects and unregistered object.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReleaseWithUnregisteredObject() {
		ObjectPool pool = new ObjectPool(5);
		pool.acquire();
		pool.acquire();
		pool.acquire();
		VeryHeavyClass a = new VeryHeavyClass();
		pool.release(a);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#release(VeryHeavyClass)} with
	 * no acquired objects and unregistered object.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testReleaseWithoutAcquireing() {
		ObjectPool pool = new ObjectPool(5);
		VeryHeavyClass a = new VeryHeavyClass();
		pool.release(a);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#acquire()} by acquiring only
	 * one object from the pool.
	 */
	@Test
	public void testAcquireOneObject() {
		ObjectPool pool = new ObjectPool(3);
		pool.acquire();

		int actualAvailabale = pool.getNumberOfAvailableObjects();
		int expectedAvailable = 2;
		int actualInUse = pool.getNumberOfAcquiredObjects();
		int expectedInUse = 1;

		assertEquals(expectedAvailable, actualAvailabale);
		assertEquals(expectedInUse, actualInUse);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#ObjectPool(int)} with negative
	 * size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNegativePoolSize() {
		new ObjectPool(-3);
	}

	/**
	 * Tests {@link com.sirma.itt.javacourse.patterns.pool.ObjectPool#ObjectPool(int)} with zero
	 * size.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testZeroPoolSize() {
		new ObjectPool(0);
	}

}
