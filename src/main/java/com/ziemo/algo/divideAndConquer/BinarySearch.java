package com.ziemo.algo.divideAndConquer;



public class BinarySearch {

	private Integer[] in;

	public BinarySearch(Integer... in) {
		this.in = in;
	}

	public boolean search(Integer[] input, int wanted) {
		boolean result = false;
		if (input.length == 0) {
			return false;
		}
		int middle = (int) Math.floor(input.length / 2);
		if (input[middle] == wanted) {
			result = true;
		} else if (input[middle] > wanted) {
			Integer[] temp = new Integer[middle];
			System.arraycopy(input, 0, temp, 0, middle);
			result = search(temp, wanted);
		} else if (input[middle] < wanted) {
			Integer[] temp = new Integer[input.length - middle-1];
			System.arraycopy(input, middle + 1, temp, 0, input.length - 1 - middle);
			result = search(temp, wanted);
		}
		return result;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch(1, 2, 3, 4, 5, 6);
		System.out.println(bs.search(bs.in, 6));
	}
}
