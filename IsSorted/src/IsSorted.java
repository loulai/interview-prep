/**
 *Created on : October 6th 2014
 *Description: From an input of 10 integers, program determines if numbers are sorted (specifically in ascending order) or not.
 *             As specified in assignment, this expects a well-behaved user that will type exactly 10 integers.
 *@author Lou Lai
 */

import java.util.Scanner;

public class IsSorted {

	public static void main(String[] args) {

		System.out.println("Type exactly 10 integers (must be 10 integers): ");
		Scanner input = new Scanner(System.in);
		boolean isSorted = true;      //initializing boolean
		int[] numArray = new int[10]; //initializing array with 10 zeros

		//method is extracted and explained below
		populateArray(input, numArray);

		for(int i = 0; i < 9; i++){ //note that i goes from 0 to 8, because values with index position 8 and 9 are the last to be
			                        //compared and not the 9 and 10 index position (out of bounds).
			
			//Checks to see if the array is sorted in ascending order, by making sure each upcoming value is
	        //larger than the current value. 
			// (e.g. this array IS NOT sorted -> [-1, 3, 1, 6] <- because 3 is larger than 1)
			if(numArray[i] > numArray[i+1]){ 
				isSorted = false;    
			} 
		}
		
		//depending on boolean, prints statement
		if(isSorted) {
			System.out.println("===Hurrah! It's sorted!===");
		} else {
			System.out.println("===Poo... it's not sorted===");
		}

	}

	/**
	 * @param input     scanner object
	 * @param numArray	an array of 10 zeros
	 * @return			returns an array populated with 10 integers that the user had input
	 */
	private static int[] populateArray(Scanner input, int[] numArray) {
		for(int i = 0; i < 10; i++){
			numArray[i] = input.nextInt(); //fills array with user input integer
			System.out.println(numArray[i]);
		}
		return numArray;
	}

}
