package temp;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Sieve newSieve = new Sieve();
		System.out.println("Calculate primes up until which number?: ");
		Scanner input = new Scanner(System.in);
		Integer n = input.nextInt();
		newSieve.primesTo(n);
//		ArrayUnbndQueue h = new ArrayUnbndQueue<Integer>();
//		for (int i = 2; i <= 10; i++) h.enqueue(i);
//		ArrayUnbndQueue bye = new ArrayUnbndQueue<Integer>();
//		bye = h;
//		for (int i = 2; i <= 10; i++) System.out.println(bye.dequeue());
//		System.out.println(bye.isEmpty());
	}

}
