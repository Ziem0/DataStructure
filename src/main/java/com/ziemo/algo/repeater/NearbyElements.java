package com.ziemo.algo.repeater;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class NearbyElements {

	int[][] multi = new int[][]{
			{2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
			{1, 3, 5, 7},
			{321, 320, 32, 3, 41241, -11, -12, -13, -66, -688}
	};

	public List<Integer> getNearby(Integer row, Integer column, Integer range) {
		List<Integer> result = new LinkedList<>();
		int counter = -range;
		while (counter <= range) {
			if (check(row, column, counter).isPresent() && counter!=0) {
				result.add(check(row, column, counter).get());
			}
			counter++;
		}
		return result;
	}

	private Optional<Integer> check(Integer row, Integer column, Integer range) {
		Integer i = null;
		try {
			i = multi[row][column + range];
		} catch (IndexOutOfBoundsException e) {
		}
		return Optional.ofNullable(i);
	}


	public static void main(String[] args) {
		NearbyElements n = new NearbyElements();
		n.getNearby(0, 1, 2).forEach(System.out::println);
	}
}
