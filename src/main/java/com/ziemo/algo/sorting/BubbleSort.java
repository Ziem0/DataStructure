package com.ziemo.algo.sorting;

import java.util.Arrays;

public class BubbleSort {


	public static void main(String[] args) {


		Integer[] data = {2, 5, 3, 6, 68, 4, 3, 7, 7, 86, 97, 3, 2, 2};

		boolean done;
		int size = data.length;

		do {
			done = false;

			for (int i = 1; i < size; i++) {
				if (data[i] < data[i - 1]) {
					int temp = data[i];
					data[i] = data[i - 1];
					data[i - 1] = temp;
					done = true;
				}
			}

			size--;

		} while (done);

		Arrays.stream(data).forEach(e-> System.out.printf("%s ",e.toString()));

	}

}
