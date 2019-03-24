package com.ziemo.algo.divideAndConquer.tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TinkerTaylor<T> {

	private static final int FIRST_INDEX = 0;
	private static final int ONE_ELEMENT_LIST = 1;
	private static final int INDEX_CORRECTION = 1;

	public T countWinner(ArrayList<T> players, Integer k) throws IndexOutOfBoundsException {
		int indexToRemove = FIRST_INDEX;
		while (players.size() > ONE_ELEMENT_LIST) {
			indexToRemove = (indexToRemove + k - INDEX_CORRECTION) % players.size();
			players.remove(indexToRemove);
		}

		return players.get(FIRST_INDEX);
	}

	public List<T> filter(ArrayList<T> players, Integer k) {
		int start = 0;
		LinkedList<T> result = new LinkedList<>();
		while (players.size() > 1) {
			int toRemove = (start + k - 1) % players.size();
			result.add(players.remove(toRemove));
			start = toRemove;
		}
		result.addLast(players.remove(0));
		return result;
	}




	public static void main(String[] args) {
		TinkerTaylor<Integer> t = new TinkerTaylor<>();

		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		System.out.println(t.filter(a, 2));
	}
}
