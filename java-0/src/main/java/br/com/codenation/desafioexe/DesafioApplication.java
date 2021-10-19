package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> FibonacciList = new ArrayList<>();

		int number = 0;
		int max = 350;
		int index = 2;

		FibonacciList.add(0);
		FibonacciList.add(1);

		while(number <= max) {
			number = (FibonacciList.get(index - 1) + FibonacciList.get(index - 2));
			FibonacciList.add(number);
			index++;
		}
		return FibonacciList;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}