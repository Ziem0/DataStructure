package com.ziemo.algo.sets;

import java.util.*;

public class CustomSet {

	public static void main(String[] args) {
		Comparator<String> c = String::compareTo;
		Set<String> s = new TreeSet<>(c.reversed());
		s.add("ania");
		s.add("ziemo");
		s.add("nina");
		s.forEach(System.out::println);


		Set<String> s2 = new LinkedHashSet<>();
		s2.add("tata");
		s2.add("babcia");
		s2.add("mama");
		s2.forEach(System.out::println);

		Comparator<Person> c2 = Comparator.comparing(a -> a.name);
		Set<Person> s3 = new TreeSet<>(c2.reversed());
		s3.add(new Person("iwona"));
		s3.add(new Person("ryszard"));
		s3.add(new Person("gabi"));
		s3.forEach(i -> System.out.println(i.name));

	}

	public static class Person {
		String name;
		public Person(String name) {
			this.name = name;
		}

	}

}
