package com.ziemo.algo.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {

		LinkedList<Integer> data = new LinkedList<>();
		int[] random = new Random().ints(20, 1, 100).toArray();
		Arrays.stream(random).forEach(data::add);

		for (int i = 0; i < data.size(); i++) {
			int currentMin = i;

			for (int j = i+1; j < data.size(); j++) {
				if (data.get(currentMin) > data.get(j)) {
					currentMin = j;
				}
			}

			int lowestValue = data.get(currentMin);
			data.set(currentMin, data.get(i));
			data.set(i, lowestValue);
		}

		data.forEach(e -> System.out.print(e+" "));
	}
}
