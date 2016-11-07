/**
  * Graders     : Shuang Zhou, Navneet Saini 
+ * Author      : Lou (Louise) Lai
  * Professor   : Evan Korth
+ * Date        : Monday March 2nd, 2015
+ * Description : Sieve class filters out primes from 2 until the user's upper bound (n), using the Sieve of Eratosthenes method
+ **/

package temp;
import java.util.Scanner;
import java.math.*;
public class Sieve {

	public static void main(String[] args) {
		System.out.println("Please enter upper bound: ");
		Scanner input = new Scanner(System.in);
		int n = (Integer) input.nextInt();
		primesTo(n);
	}
	
	/** method outputs all primes number up until the upper bound (inclusive)
	 * @param n                         Upper bound, which is input by user    
	 * @throws IllegalArgumentException Error thrown if upper bound is less than 2
	 */
	public static void primesTo(Integer n) throws IllegalArgumentException{
		if (n < 2) throw new IllegalArgumentException("Upper bound must be greater than 2, try again");
		ArrayUnbndQueue numbers = new ArrayUnbndQueue();
		ArrayUnbndQueue primes = new ArrayUnbndQueue();
		ArrayUnbndQueue aside = new ArrayUnbndQueue(); //used to hold the prime numbers that are also divisors, and is output at the end of method
		Integer p;
		Integer p2;
		
		for (Integer i = 2; i <= n; i++) {
			numbers.enqueue(i); //filling up 'numbers' queue from 2 to n
		}
		
		p = (Integer) numbers.dequeue(); //obtaining first divisor
		aside.enqueue(p); //putting it in 'aside' queue
		
		while(p <= Math.sqrt(n)){
			do { 
				p2 = (Integer) numbers.dequeue();
				if( p2 % p != 0){
					primes.enqueue(p2); //falls through to 'primes' queue if mod is not 0
				}
			} while(!numbers.isEmpty());
			
			p = (Integer) primes.dequeue(); //preparing for next round, same logic as obtaining first divisor (p) before the while loop
			aside.enqueue(p);
			
			while(!primes.isEmpty()) numbers.enqueue(primes.dequeue()); //filling 'numbers' queue with numbers from 'primes', in preparation for next outer while loop 
		}
		
		/* output */
		System.out.printf("Primes up to %d are: ", n);
		while(!aside.isEmpty()) System.out.print(" " + aside.dequeue() + " "); //printing out all the primes that are divisors
		while(!numbers.isEmpty()) System.out.print(" " + numbers.dequeue() + " "); //printing out all the remaining primes
	}

}
