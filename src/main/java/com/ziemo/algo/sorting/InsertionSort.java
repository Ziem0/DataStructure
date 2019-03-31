package com.ziemo.algo.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {

		LinkedList<Integer> data = new LinkedList<>();
		int[] random = new Random().ints(10, 1, 100).toArray();
		Arrays.stream(random).forEach(data::add);

		//3 4 1 2 7

		for (int i = 1; i < data.size(); i++) {
			int j = i-1;
			while (j >= 0) {
				if (data.get(i) > data.get(j)) {
					data.add(j + 1, data.remove(i));
					break;
				} else {
					j--;
					if (j == -1) {
						data.add(0, data.remove(i));
					}
				}
			}
		}

		data.forEach(e -> System.out.print(e+" "));
	}
}
