import java.util.Scanner;

/*Author     : Louise (Lou) Lai
 *Created on : September 16th 2014
 *Description: Program takes integer input from user, and generates a sequence according to certain rules.
 */

public class Sequence{

	public static void main(String[] args) {
		
		// prompting the user for input, and extracting double value n from input
		System.out.println("Please input a number and press enter: ");
		Scanner input = new Scanner(System.in);
		double n = input.nextInt();
		
		// the loop uses the modulus (%) operator to determine if n is even or odd
		if (n % 2 == 0) {
			
			// first, prints out n as the first item of the sequence without doing any math to it.
			System.out.println("even");
			System.out.print(n + ", ");
			
			// for loop runs only 99 times (not 100), because the first value has already been printed
			for (int i = 0; i < 99; i++) {
				
				// n is divide by two
				n = n/2.0;
				
				// nested if loop checks if it's the last value. If so, the value
				// is printed without a comma.
				if (i == 98) {
					System.out.print(n);
				} else {
					System.out.print(n + ", ");
				}
				
			}
				
		// This else statement is the first layer one. It runs if the input is anything but even (therefore, 
		//  assuming perfect users, should be odd). The exact same thing as above is replicated, except with 
		// different mathematical rule.
		} else {
			System.out.println("odd");
			System.out.print(n + ", ");
			
			for (int i = 0; i < 99; i++) {
			
				// here is the different mathematical rule.
				n = (n * 3.0) + 1;
				
				if (i == 98) {
					System.out.print(n);
				} else {
					System.out.print(n + ", ");
				}
				
			}
			
		}

	}

}
