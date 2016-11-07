/**
 *Created on : October 6th 2014
 *Description: Program takes user input as a string and prints the reversed string.
 *@author Lou Lai
 */

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		System.out.println("Enter a string: ");
		Scanner input = new Scanner(System.in);
		String myS = input.nextLine(); //nextLine includes whitespace
		System.out.println("Your string in reverse is: " + reverse(myS)); //method reverse() explained below
	}
	
	/**
	 * @param textToReverse The string to be reversed, which is the user's inputed string
	 * @return              Returns a string
	 */
	public static String reverse(String textToReverse) {
		
		char[] charArray =  textToReverse.toCharArray(); //creates an array of characters from the inputed string
		int orignalIndex = 0;                            // because indexes start at 0. Its usage below makes it clearer
		int reverseIndex = textToReverse.length() - 1;    //number of characters, adjusted for zeroth index use later on
		
		// Below while loop is best explained with an example of a char array, in this case [HELLO]. 
		// Essentially, the loop switches the start and end positions of the char array again and again until it reaches the middle.
		// HELLO
		// OELLH (after first while loop is finished. Index position 0 and 4 are switched)
		// OLLEH (after second loop. Index position 1 and 3 are switched)
		// (breaks now, because originalIndex and reverseIndex both equal 2)
		while (orignalIndex < reverseIndex) {
			char someCharacter = charArray[orignalIndex];     //stores the first value of the array at index = 0, e.g. H in HELLO
			charArray[orignalIndex]= charArray[reverseIndex]; //then replaces the first value with the last value e.g. HELLO becomes OELLO at this point
			charArray[reverseIndex] = someCharacter;          //replaces the last value for someCharacter e.g. OELLO becomes OELLH at this point
			orignalIndex++; //increments by one
			reverseIndex--; //decrements by one
		}
		return new String(charArray); //returns the string version of the array of characters
	}

}
