package com.ziemo.algo.divideAndConquer.efficient;

import java.util.*;

public class QuickSort {

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
		if (toSort.get(pivot) < toSort.get(line)) {
			Collections.swap(toSort, pivot, line);
		}

		if (start < line) {
			quickSort(toSort, start, line - 1);
		}
		if (line + 1 < end) {
			quickSort(toSort, line + 1, end);
		}
	}

//	public static void main(String[] args) {
//		int[] ints = new Random().ints(6, 1, 100).toArray();
//		List<Integer> data = new LinkedList<>();
//		Arrays.stream(ints).forEach(data::add);
//
//		data.forEach(e -> System.out.print(e + " "));
//		System.out.println();
//
//		QuickSort sort = new QuickSort();
//		sort.sort(data);
//
//		data.forEach(e -> System.out.print(e + " "));
//	}
}
