package com.ziemo.algo.tree;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
	/*
	1. Given an array sorted in increasing order with unique integer elements write an algorithm to create a
	binary search tree with minimal height. Hint: The middle element of the array should be the root.
	2. Write a function to find if an element is in the tree or not.
	3. Write functions to add and remove elements from the tree. Its OK if the tree will not have a minimal
	depth after calling these. Also remove can be implemented by removing the element
	and all it'schildren but you may think about the possibility to make a version of remove what only removes the
	requested node and re-orders it's descendants.
	 */
	TNode root;

	// init based on recurrency
	public static BinarySearchTree build(List<Integer> elements) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = buildTree(elements);
		return tree;
	}

	private static TNode buildTree(List<Integer> elements) {
		if (elements.size() > 0) {
			int middle = (int) Math.floor(elements.size() / 2);
			TNode newNode = new TNode(elements.get(middle));
			newNode.left = buildTree(elements.subList(0, middle));
			if (elements.size() > 2) {
				newNode.right = buildTree(elements.subList(middle + 1,elements.size()));
			}
			return newNode;
		}
		return null;
	}

	public Boolean contains(int value) {
		TNode current = root;
		while (current != null) {
			if (current.data == value) {
				return true;
			} else if (value < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void add(int element) {
		TNode current = root;

		while (current != null) {
			if (current.data == element) {
				throw new IllegalArgumentException("Element is already in use!");

			} else if (element < current.data) {
				if (current.left == null) {
					current.left = new TNode(element);
					break;
				} else {
					current = current.left;
				}

			} else {
				if (current.right == null) {
					current.right = new TNode(element);
					break;
				} else {
					current = current.right;
				}
			}
		}
	}

	public void remove(Integer element) {
		if (root.data == element) {
			root = null;
			return;
		}

		TNode current = root;
		TNode parent = root;
		while (current != null) {
			if (current.data == element) {
				parent.remove(current);
				return;
			} else if (element < current.data) {
				parent = current;
				current = current.left;
			} else {
				parent = current;
				current = current.right;
			}
		}
		throw new IllegalArgumentException("Selected element doesn't exist");
	}

	public static void main(String[] args) {
		BinarySearchTree b = BinarySearchTree.build(Arrays.asList(1, 2, 3, 4, 5, 6));
		b.add(100);
		System.out.println(b.contains(100));
		b.remove(99);
		System.out.println(b.contains(100));

	}



	/*
				4
			2       6
		  1  3     5
	 */

}
