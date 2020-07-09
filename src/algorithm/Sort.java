package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {

	long executionTime = 0;

	/*
	 * Please implement all the sorting algorithm. Feel free to add helper methods.
	 * Store all the sorted data into one of the databases.
	 */
	public int[] selectionSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;

		for (int j = 0; j < array.length - 1; j++) {
			int min = j;
			for (int i = j + 1; i < array.length; i++) {
				if (array[i] < array[min])
					min = i;
			}

			int temp = array[min];
			array[min] = array[j];
			array[j] = temp;
		}

		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public int[] insertionSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		for (int i = 1; i < list.length; i++) {
			int temp = list[i];
			int k;
			for (k = i - 1; k >= 0 && list[k] > temp; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = temp;
		}

		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public int[] bubbleSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		boolean isSorted = false;
		for (int i = 1; i < list.length && !isSorted; i++) {
			isSorted = true;
			for (int k = 0; k < list.length - i; k++) {
				if (list[k] > list[k + 1]) {
					int temp = list[k];
					list[k] = list[k + 1];
					list[k + 1] = temp;
					isSorted = false;
				}
			}
		}
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public int[] mergeSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		if (list.length > 1) {
			int midpoint = list.length / 2;
			int[] leftHalf = new int[midpoint];
			System.arraycopy(list, 0, leftHalf, 0, midpoint);
			mergeSort(leftHalf);

			int rightHalfLength = list.length - midpoint;
			int[] rightHalf = new int[rightHalfLength];
			System.arraycopy(list, midpoint, rightHalf, 0, rightHalfLength);
			mergeSort(rightHalf);

			merge(leftHalf, rightHalf, list);

		}
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public void merge(int[] left, int[] right, int[] fullList) {
		int l = 0;
		int r = 0;
		int f = 0;

		while (l < left.length && r < right.length) {
			if (left[l] < right[r])
				fullList[f++] = left[l++];
			else
				fullList[f++] = right[r++];
		}
		while (l < left.length)
			fullList[f++] = left[l++];

		while (r < right.length)
			fullList[f++] = right[r++];
	}

	public int[] quickSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		quickSort(list, 0, list.length - 1);
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);

		}
	}

	public int partition(int[] list, int first, int last) {
		int pivot = list[(first + last) / 2];
		int left = first;
		int right = last;

		while (right > left) {
			while (left <= right && list[left] <= pivot)
				left++;
			while (left <= right && list[right] > pivot)
				right--;
			if (right > left) {
				int temp = list[right];
				list[right] = list[left];
				list[left] = temp;
			}
		}
		while (right > left && list[right] >= pivot)
			right--;
		if (pivot > list[right]) {
			list[left] = list[right];
			list[right] = pivot;
			return right;
		} else {
			return first;
		}
	}

	List<Integer> list1 = new ArrayList<Integer>();

	public int[] heapSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		int i;
		for (i = 0; i < list.length; i++)
			add(list[i]);
		for (i = list.length - 1; i >= 0; i--)
			list[i] = remove();
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public void add(int i) {

		list1.add(i);
		int currentIndex = list1.size() - 1;

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (list1.get(currentIndex).compareTo(list1.get(parentIndex)) > 0) {
				int temp = list1.get(currentIndex);
				list1.set(currentIndex, list1.get(parentIndex));
				list1.set(parentIndex, temp);
			} else
				break;
			currentIndex = parentIndex;
		}

	}

	public Integer remove() {
		if (list1.size() == 0)
			return null;
		Integer removed = list1.get(0);
		list1.set(0, list1.get(list1.size() - 1));
		list1.remove(list1.size() - 1);

		int currentIndex = 0;
		while (currentIndex < list1.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			if (leftChildIndex >= list1.size())
				break;
			int maxIndex = leftChildIndex;
			if (rightChildIndex < list1.size()) {
				if (list1.get(maxIndex).compareTo(list1.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}
			if (list1.get(currentIndex).compareTo(list1.get(maxIndex)) < 0) {
				Integer temp = list1.get(maxIndex);
				list1.set(maxIndex, list1.get(currentIndex));
				list1.set(currentIndex, temp);
				currentIndex = maxIndex;
			} else
				break;
		}
		return removed;
	}

	public int[] bucketSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		List<Integer> list1 = new ArrayList<>();
		List<List<Integer>> bucket = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			bucket.add(new ArrayList<>());
		}
		for (int value : list) {
			int key = hash(value);
			bucket.get(key).add(value);
		}
		for (int i = 0; i < bucket.size(); i++) {
			if (bucket.get(i) != null) {
				Collections.sort(bucket.get(i));
				list1.addAll(bucket.get(i));
			}
		}
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public int hash(int value) {
		return value / 10;
	}

	public int[] shellSort(int[] array) {
		final long startTime = System.currentTimeMillis();
		int[] list = array;
		// implement here
		for (int spacing = list.length / 2; spacing > 0; spacing /= 2) {
			for (int j = spacing; j < list.length; j++) {
				int key = list[j];
				int k = j;
				while (k >= spacing && list[k - spacing] > key) {
					list[k] = list[k - spacing];
					k -= spacing;
				}
				list[k] = key;
			}
		}
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		this.executionTime = executionTime;
		return list;
	}

	public static void printSortedArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
