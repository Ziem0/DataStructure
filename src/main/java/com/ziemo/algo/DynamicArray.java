package com.ziemo.algo;

import java.util.Arrays;

public class DynamicArray {

	private int size;
	private int[] staticArray;

	public int[] getStaticArray() {
		return staticArray;
	}

	public DynamicArray() {
		this.size = 0;
		staticArray = new int[size];
	}

	public DynamicArray(int size) {
		this.size = size;
		staticArray = new int[size];
	}

	public void add(int item) {
		this.size++;
		int[] tempArray = new int[size];
		System.arraycopy(staticArray, 0, tempArray, 0, size-1);
		staticArray = tempArray;
		staticArray[size - 1] = item;
	}

	public void insert(int index, int item) {
		if (index >= size) {
			add(item);
		} else {
			this.size++;
			int[] tempArray = new int[size];
			System.arraycopy(staticArray, 0, tempArray, 0, index);
			System.arraycopy(staticArray, index, tempArray, index + 1, size - 1 - index);
			staticArray = tempArray;
			staticArray[index] = item;
		}
	}

	public void remove(int index) {
		size--;
		int[] tempArray = new int[size];
		System.arraycopy(staticArray, 0, tempArray, 0, index);
		System.arraycopy(staticArray, index+1, tempArray, index, size-index);
		staticArray = tempArray;
	}

	@Override
	public String toString() {
		return Arrays.toString(staticArray).replaceAll("(^\\[|]$|,)","");
	}


	public static void main(String[] args) {
		DynamicArray da = new DynamicArray();
		da.add(1);
		da.add(2);
		da.insert(2, 3);
		da.remove(0);

		System.out.println(da);

	}
}
