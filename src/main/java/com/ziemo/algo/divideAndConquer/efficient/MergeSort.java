package com.ziemo.algo.divideAndConquer.efficient;

import java.util.*;

public class MergeSort {

	public void sort(List<Integer> toSort) {

		if (toSort == null) {
			throw new IllegalArgumentException("list is empty");
		}
		divide(toSort, 0, toSort.size()-1);
	}

	private void divide(List<Integer> toSort, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;   // floor default
			divide(toSort, start, middle);
			divide(toSort, middle + 1, end);   // finding depth
			merge(toSort, start, middle, end);
		}
	}

	private void merge(List<Integer> toSort, int start, int middle, int end) {
		List<Integer> temp = new LinkedList<>();
		int left = start;
		int right = middle + 1;


		while (left <= middle && right <= end) {
			if (toSort.get(left) <= toSort.get(right)) {
				temp.add(toSort.get(left++));
			} else {
				temp.add(toSort.get(right++));
			}
		}

		while (left <= middle) {
			temp.add(toSort.get(left++));
		}

		while (right <= end) {
			temp.add(toSort.get(right++));
		}


		for (int i = 0; i < temp.size(); i++) {
			toSort.set(start+i, temp.get(i));
		}

	}

	public static void main(String[] args) {

		LinkedList<Integer> data = new LinkedList<>();
		int[] random = new Random().ints(15, 1, 100).toArray();
		Arrays.stream(random).forEach(data::add);

		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(data);

		data.forEach(e -> System.out.print(e + " "));
	}
}
