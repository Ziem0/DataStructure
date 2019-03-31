package com.ziemo.algo.repeater;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class PrimeFactorization {

	Integer[] input;

	Predicate<Integer> isPrimary = (n) -> {
		for (Integer i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	};


	public PrimeFactorization(Integer[] input) {
		this.input = input;
	}

	public List<List<Integer>> calculate() {
		List<List<Integer>> out = new LinkedList<>();

		for (int i = 0; i < input.length; i++) {
			out.add(new LinkedList<>());
			int num = input[i];
			while (num != 1) {
				for (int j = 2; j <= num; j++) {
					if (isPrimary.test(j) && num % j == 0) {
						out.get(i).add(j);
						num /= j;
						break;
					}
				}
			}
		}
		return out;
	}



	public static void main(String[] args) {
		PrimeFactorization primeFactorization = new PrimeFactorization(new Integer[]{49, 32, 123});
		primeFactorization.calculate().forEach(e-> {
			e.forEach(x -> System.out.print(x +" "));
			System.out.println();
		});

	}
}
