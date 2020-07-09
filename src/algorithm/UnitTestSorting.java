package algorithm;

import org.testng.Assert;

public class UnitTestSorting {

	/*
	 * This class is about Unit testing for Sorting Algorithm.
	 */
	public static void main(String[] args) {
		int[] unSortedArray = { 6, 9, 2, 5, 1, 0, 4 };
		int[] sortedArray = { 0, 1, 2, 4, 5, 6, 9 };
		// Create Sort object
		Sort sort = new Sort();
		// apply unsorted array to selectionSort.
		sort.selectionSort(unSortedArray);
		// verify if the unsorted array is sorted by the selection sort algorithm.
		try {
			Assert.assertEquals(sortedArray, unSortedArray, "Array is not Sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}
		String value = "i am waiting";
		Assert.assertEquals("i am waiting", value);
		// Now implement Unit test for rest of the sorting
		// algorithm...................below
		int[] unSortedArray1 = { 6, 9, 2, 5, 1, 0, 4 };
		int[] sortedArray1 = { 0, 1, 2, 4, 5, 6, 9 };
		sort.insertionSort(unSortedArray1);
		try {
			Assert.assertEquals(sortedArray1, unSortedArray1, "Array is not sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}
		int[] unSortedArray2 = { 6, 9, 2, 5, 1, 0, 4 };
		int[] sortedArray2 = { 0, 1, 2, 4, 5, 6, 9 };
		sort.bubbleSort(unSortedArray2);
		try {
			Assert.assertEquals(sortedArray2, unSortedArray2, "Array is not sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}
		int[] unSortedArray3 = { 6, 9, 2, 5, 1, 0, 4 };
		int[] sortedArray3 = { 0, 1, 2, 4, 5, 6, 9 };
		sort.mergeSort(unSortedArray3);
		try {
			Assert.assertEquals(sortedArray3, unSortedArray3, "Array is not sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}
		int[] unSortedArray4 = { 10, 9, 8, 7, 6, 5, 4 };
		int[] sortedArray4 = { 4, 5, 6, 7, 8, 9, 10 };
		sort.quickSort(unSortedArray4);
		try {
			Assert.assertEquals(sortedArray4, unSortedArray4, "Array is not sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}

		int[] unSortedArray6 = { 6, 9, 2, 5, 1, 0, 4 };
		int[] sortedArray6 = { 0, 1, 2, 4, 5, 6, 9 };
		sort.shellSort(unSortedArray6);
		try {
			Assert.assertEquals(sortedArray6, unSortedArray6, "Array is not sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}
		int[] unSortedArray7 = { 10, 9, 8, 7, 6, 5, 4 };
		int[] sortedArray7 = { 4, 5, 6, 7, 8, 9, 10 };
		sort.bucketSort(unSortedArray7);
		try {
			Assert.assertEquals(sortedArray7, unSortedArray7, "Array is not sorted");
		} catch (Exception ex) {
			ex.getMessage();
		}

		// bucketSort has an error but it sort fine in Numbers.java

	}
}
