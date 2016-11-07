/**
 *Created on : October 16th 2014
 *Description: Program shifts the words of a string by one. e.g. PENS becomes SPEN, CLOUDS becomes SCLOUD.
 *@author Lou Lai
 */
import java.util.Scanner;

public class ShiftByOne {

	public static void main(String[] args) {
		
		//obtaining user input
		System.out.println("Please input string: ");
		Scanner input = new Scanner(System.in);
		String originalString = input.nextLine();
		
		//creating a char array from the input, and counting its length
		char[] letters = originalString.toCharArray();
		int stringLength = letters.length;
		
		/*Over arching concept: there are always two variables that store a char each.
		 * The for loop iterates over each char, and replaces/stores chars */
		
		//storing the last letter as variable 'stored1', and the first letter as variable 'stored2'
		char stored1 = letters[stringLength - 1];
		char stored2 = letters[0];
		
		//runs stringLength-1 times. E.g.if the string is 5 chars long, the string will run 4 times. 
		//must run stringLength-1 times otherwise we'll run into a out of bounds error (look at stored2 at the end of the for loop code)
		for(int i = 0; i < stringLength-1; i++){
			letters[i] = stored1; // replacing the ith position of the char array with the stored1 (initially initialized above)
			stored1 = stored2;    // now that stored1 is used, it's being replaced by store2
			stored2 = letters[i + 1]; // now stored2 is used, stored2 must move on, because we're storing the future char to be used in the next loop
		}
		
		//this line must be run to fix up the last char, because we quit the for loop (to avoid the out of bounds error) before we
		//got to the last char
		letters[stringLength - 1] = stored1;
		
		//printing string
		String shiftedWord = new String(letters);
		
		System.out.println(shiftedWord);
		
	}
		

}
