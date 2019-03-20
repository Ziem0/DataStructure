package com.ziemo.algo.hash;

import java.util.LinkedList;

public class CustomHashMap<K, V> {

	private int size;
	private LinkedList<KeyValue>[] elements;


	public CustomHashMap(int size) {
		this.size = size;
		this.elements = new LinkedList[size];
	}

	public void add(K key, V value) {
		int position = getHash(key);
		LinkedList<KeyValue> list = elements[position];

		if (list == null) {
			list = new LinkedList<>();
		}

		for (KeyValue kv : list) {
			if (kv.key == key) {
				kv.value = value;
				return;
			}
		}

		list.add(new KeyValue(key, value));
		elements[position] = list;
		//resize if needed

	}

	public V getValue(K key) {
		int position = getHash(key);
		return (V) elements[position].get(0).value;
	}

	public void remove(K key) {
		int position = getHash(key);
		elements[position].remove();
	}

	public void clearAll() {
		for (LinkedList<KeyValue> element : elements) {
			if (element != null) {
				element.remove();
			}
		}
	}

	private int getHash(K key) {
		return key.hashCode() % size;
	}

//	private void resizeIfNeeded() {
//
//	}






	public static void main(String[] args) {
		CustomHashMap<String, Integer> c = new CustomHashMap<>(16);
		c.add("ziemo", 32);
		c.add("ania", 30);
		c.add("nina", 30);
		c.add("omeiz", 32);

		System.out.println("++++++");

//		System.out.println(c.getValue("ania"));

//		c.remove("ziemo");
//		c.remove("ania");

//		c.clearAll();

		for (LinkedList<KeyValue> element : c.elements) {
			if (element != null) {
				for (KeyValue keyValue : element) {
					System.out.println("------");
					System.out.println(keyValue.key);
					System.out.println(keyValue.value);
					System.out.println(element.size());
				}
			}
		}

	}

}
