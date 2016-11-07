/**
 *Created on : October 6th 2014
 *Description: Program finds the largest value from user input. It keeps a count of how many times the largest value occurs, and
 *			   also finds the second largest value (extra credit).
 *@author Lou Lai
 */

import java.util.Scanner;

public class FindingLargest {

	public static void main(String[] args) {
		System.out.print("Enter your integers (0 indicates end): ");
		Scanner input = new Scanner(System.in);
		int largest = input.nextInt();
		int num = 1;     // initial value can't be zero, because while loop will never run. It doesn't matter what this value is because
						 // it is changed immediately after entering the while loop.
		int counter = 1; // logically, the largest value must occur at least once, so this can be our initial value.
		int secondLargest = Integer.MIN_VALUE; //because nothing can be below this number

		while (num != 0) {
			num = input.nextInt();
			if (num > largest && num != 0){ //[!= 0] is crucial, otherwise if all were negative values, the largest would be 0
				secondLargest = largest;    //logically, the 2nd largest is the OLD largest number
				largest = num;				//new largest number is set if the input is greater than whatever was the previous 'largest'
				counter = 1;				//resets 'largest' counter to 1
			} else if (num == largest) {    //keeps count of largest numbers
				counter ++;
			} else if (num > secondLargest && num != 0) { // at this stage, the 2nd largest number is greater than num and can't be zero again
				secondLargest = num;
			}
		}
		
		System.out.println("\nThe largest number is     : " + largest);
		
		//handling pluralization
		if (counter == 1) {
			System.out.println("It occurs once.");
		} else {
			System.out.println("It occurs " + counter + " times");
		}
		
		if (secondLargest == Integer.MIN_VALUE){ //edge case for when there are not enough values for second largest value to be computed
			System.out.println("Cannot compute second largest value.");
		} else{
			System.out.println("The 2nd largest number is : " + secondLargest);
		}
	}

}
