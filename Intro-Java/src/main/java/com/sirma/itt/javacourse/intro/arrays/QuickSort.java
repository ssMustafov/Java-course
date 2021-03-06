package com.sirma.itt.javacourse.intro.arrays;

/**
 * Sorts array by Quicksort method.
 * 
 * @author smustafov
 */
public final class QuickSort {

	/**
	 * Protection from instantiation.
	 */
	private QuickSort() {

	}

	/**
	 * Sorts array of integers. Invokes the sorting algorithm. The main method for sorting.
	 * 
	 * @param array
	 *            the array to be sorted
	 */
	public static void sort(int[] array) {
		if (array.length <= 0) {
			throw new IllegalArgumentException("The array's size is equal or under zero");
		}

		quicksort(array, 0, array.length - 1);
	}

	/**
	 * Sorts array of integers.
	 * 
	 * @param array
	 *            the array to be sorted
	 * @param low
	 *            the start index of the array
	 * @param high
	 *            the last index of the array
	 */
	private static void quicksort(int[] array, int low, int high) {
		int i = low;
		int j = high;

		// Get the pivot element from the middle of the list
		int pivot = array[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			while (array[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			while (array[j] > pivot) {
				j--;
			}

			// If we have found values in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			// As we are done we can increase i and decrease j
			if (i <= j) {
				swapTwoElements(array, i, j);
				i++;
				j--;
			}
		}

		// Call the sort recursively for the other elements
		if (low < j) {
			quicksort(array, low, j);
		}
		if (i < high) {
			quicksort(array, i, high);
		}
	}

	/**
	 * Exchanges two values in given array.
	 * 
	 * @param array
	 *            the array in which exchanging to be done
	 * @param i
	 *            the index of the first value to be exchanged
	 * @param j
	 *            the index of the second value to be exchanged
	 */
	private static void swapTwoElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
