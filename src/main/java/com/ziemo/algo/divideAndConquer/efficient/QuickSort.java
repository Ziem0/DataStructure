package com.ziemo.algo.divideAndConquer.efficient;

import java.util.*;

public class QuickSort {

	public void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}

	private void quickSort(int[] A, int low, int high) {
		if (low < high+1) {
			int p = partition(A, low, high);
			quickSort(A, low, p-1);
			quickSort(A, p+1, high);
		}
	}

	private void swap(int[] A, int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}

	// returns random pivot index between low and high inclusive.
	private int getPivot(int low, int high) {
		Random rand = new Random();
		return rand.nextInt((high - low) + 1) + low;
	}

	// moves all n < pivot to left of pivot and all n > pivot
	// to right of pivot, then returns pivot index.
	private int partition(int[] A, int low, int high) {
		swap(A, low, getPivot(low, high));
		int border = low + 1;
		for (int i = border; i <= high; i++) {
			if (A[i] < A[low]) {
				swap(A, i, border++);
			}
		}
		swap(A, low, border-1);
		return border-1;
	}




////////////////////////////////////////////////////////////////////////////// second approach
	public void sort(List<Integer> data) {

		if (data == null) {
			throw new IllegalArgumentException("Data is empty");
		}
		quickSort(data, 0, data.size() - 1);
	}

	private void quickSort(List<Integer> toSort, int start, int end) {
		int pivot = end;
		int line = start;

		for (int i = 0; i < end-start; i++) {
			if (toSort.get(i+start) < toSort.get(pivot)) {
				Collections.swap(toSort, i+start, line++);
			}
		}
			Collections.swap(toSort, pivot, line);

		if (start < line) {
			quickSort(toSort, start, line - 1);
		}
		if (line + 1 < end) {
			quickSort(toSort, line + 1, end);
		}
	}
	////////////////////////////////////////////////////////////////////////////// best approach with random pivot

	public void sortFinal(List<Integer> data) {
		if (data == null) {
			throw new IllegalArgumentException("Empty data");
		}
		quickFinal(data, 0, data.size() - 1);
	}

	private void quickFinal(List<Integer> data, int start, int end) {
		if (start < end + 1) {
			int p = this.partitionFinal(data, start, end);  // returns sorted pivot responsible for division
			quickFinal(data, start, p - 1);
			quickFinal(data, p + 1, end);
		}
	}

	private int getPivotRandom(int start, int end) {
		Random rand = new Random();
		return rand.nextInt((end - start) + 1) + start;
	}

	private int partitionFinal(List<Integer> data, int start, int end) {
		int pivot = getPivotRandom(start, end);
		Collections.swap(data, start, pivot);
		int border = start;

		for (int i = border+1; i <= end; i++) {
			if (data.get(i) < data.get(start)) {
				Collections.swap(data,i,++border);
			}
		}
		Collections.swap(data, start, border);
		return border;
	}

	//////////////////////////////////////////////////////////////////////////////



	public static void main(String[] args) {
		int[] ints = new Random().ints(6, 1, 100).toArray();
		List<Integer> data = new LinkedList<>();
		Arrays.stream(ints).forEach(data::add);

		data.forEach(e -> System.out.print(e + " "));
		System.out.println();

		QuickSort sort = new QuickSort();

		sort.sortFinal(data);
		data.forEach(e -> System.out.print(e + " "));

//		sort.quickSort(ints);
//		Arrays.stream(ints).forEach(e -> System.out.print(e + " "));


	}
}
