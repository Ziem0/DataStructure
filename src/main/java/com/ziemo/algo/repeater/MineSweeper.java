package com.ziemo.algo.repeater;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MineSweeper {
	/*
		1. Dynamic array
		2. LinkedList
		3. Stack
		4. Queue
		5. Binary Tree
		6. HashMap
		7. Graph
		8. Breath-First Search
		9. Depth-First Search
		10. Flattening
		11. Tinker
		12. Bubble Sort
		13. Insertion Sort
		14. Selection Sort
		15. Binary Search
		16. Merge Sort
		17. Quick Sort
		18. 3 more
	 */

	int height;
	int width;
	String[][] board;

	public MineSweeper(int height, int width) {
		this.height = height;
		this.width = width;
		this.board = new String[height][width];
	}

	public void fillUpBoard() {
		Random random = new Random();
		List<Integer> rHeights = random.ints((height * width) / 3, 0, height).boxed().collect(Collectors.toList());
		List<Integer> rWidth= random.ints((height * width) / 3, 0, width).boxed().collect(Collectors.toList());

		AtomicInteger counter = new AtomicInteger();
		rHeights.forEach(e -> {
			board[e][rWidth.get(counter.getAndIncrement())] = "*";
		});

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == null) {
					board[i][j] = ".";
				}
			}
		}
	}

	public void fillWithNum() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!board[i][j].equals("*")) {
					board[i][j] = calculateDistance(i,j);
				}
			}
		}
	}

	public String calculateDistance(int y,int x) {
		int[] scope = new int[]{-1, 0, 1};
		int counter = 0;
		for (int h : scope) {
			for (int w : scope) {
				if (getV(y + h, x + w).isPresent() && getV(y + h, x + w).get().equals("*")) {
					counter++;
				}
			}
		}
		return counter+"";
	}

	private Optional<String> getV(int y, int x) {
		String v = null;
		try {
			v = board[y][x];
		} catch (IndexOutOfBoundsException e) {
		}
		return Optional.ofNullable(v);
	}


	public void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		MineSweeper a = new MineSweeper(5, 5);
		a.fillUpBoard();
		a.fillWithNum();
		a.print();
	}
}
