package com.ziemo.algo.divideAndConquer;

public class BinarySearch {

	public Integer[] in;

	public BinarySearch(Integer... in) {
		this.in = in;
	}

	public boolean search(Integer[] input, int wanted) {
		boolean result = false;

		if (input.length == 0) {return false;}

		int middle = (int) Math.floor(input.length / 2);

		if (input[middle] == wanted) {
			return true;
		} else if (input[middle] > wanted) {
			Integer[] temp = new Integer[middle];
			System.arraycopy(input, 0, temp, 0, middle);
			result = search(temp, wanted);
		} else if (input[middle] < wanted) {
			Integer[] temp = new Integer[input.length - middle - 1];
			System.arraycopy(input, middle + 1, temp, 0, input.length - 1 - middle);
			result = search(temp, wanted);
		}
		return result;

//		if (data.size() > 0) {
//			int middle = data.size() / 2;
//			if (v == data.get(middle)) {
//				return true;
//			}
//			if (data.get(middle) > v) {
//				return search(data.subList(0, middle), v);
//			} else {
//				return search(data.subList(middle + 1, data.size()), v);
//			}
//		}
//		return false;
	}
}
