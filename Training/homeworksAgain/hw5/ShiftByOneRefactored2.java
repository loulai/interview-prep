
package hw5;
import java.util.Scanner;
public class ShiftByOneRefactored2 {
	public static void main(String[] args){
		System.out.print("type input string: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		char[] letters = s.toCharArray();
		
		char storer; //initialize with nothing, because will fill storer within the for loop later on
		char swapper = letters[letters.length-1]; //load swapper up with the last character of the string
		
		for(int i = 0; i < letters.length; i++){
			storer = letters[i];          //[CHAR][STORER][SWAPPER] > think of cups, 'pouring' values into each other
			letters[i] = swapper;         // like firstly, pour CHAR into STORE (store it). Then pour whatever is in SWAPPER into the now 'empty' cup of CHAR. 
			swapper = storer;             // Finally, load up SWAPPER by what was in STORE, in preparation for the next iteration.
		}
		System.out.printf("Original : %s\n", s);
		System.out.printf("Shifted  : %s", new String(letters));
	}
}
