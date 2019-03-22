package com.ziemo.algo.divideAndConquer;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Flatten {

	public List<Object> filter(List<Object> list) {
		List<Object> result = new LinkedList<>();

		for (Object o : list) {
			if (o.getClass().isArray()) {
				result.addAll(filter(Arrays.asList((Object[]) o)));
			} else if (o instanceof Collection) {
				result.addAll(filter((List<Object>)o));
			} else {
				result.add(o);
			}
		}
		return result;
	}


	public static void main(String[] args) {
		Flatten f = new Flatten();
		List<String> l0 = Arrays.asList("zero0", "zero1");
		Object[] s = {"ziemo", "ania", l0};
		Object[] lista = {"heja", s, "koniec"};
		List<Object> listaFinal = Arrays.asList((Object) lista);
		System.out.println(f.filter(listaFinal));

	}

}
