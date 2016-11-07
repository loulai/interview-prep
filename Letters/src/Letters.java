import java.util.Scanner;

/*Author     : Louise (Lou) Lai
 *Created on : September 10th 2014
 *Description: Program checks if input is a letter or digit. If it's a letter, then determines
 *             if it is a vowel or consonant.
 */

public class Letters {

	public static void main(String[] args) {
		
		// prompting the user for input.
		System.out.println("Enter a character: ");
		Scanner input = new Scanner(System.in);
		String inputString = input.next();
		
		// converting user input to char.
		char value = inputString.charAt(0);
		
		// checks if the input is a letter.
		if (Character.isLetter(value)) {
			
			// checks if input is a vowel.
			if (value == 'a' || value ==  'e' || value ==  'i' || value == 'o' || value == 'u') {
				System.out.print(inputString + " is a vowel.");
			} else {
				System.out.print(inputString + " is a consonant.");
			}
	
		// if not a letter, then below is printed.
		} else {
			System.out.print(inputString + " is not a letter.");
		}

	}

}
