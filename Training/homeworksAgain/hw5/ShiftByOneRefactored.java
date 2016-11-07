package hw5;

import java.util.Scanner;

public class ShiftByOneRefactored {

	public static void main(String[] args) {
		System.out.println("Input a string: "); 
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		char[] chars = s.toCharArray();
		char storer;
		char swapper;
		
		storer = chars[1];
		chars[1] = chars[0];
		
		if(chars.length > 1){
			for(int i = 2; i < chars.length; i++){
				swapper = storer; // swapper gets storer. The previously stored value gets 'bumped up' in preparation 
				                  //to be swapped into place in the current char[i] spot
				storer = chars[i]; //storer gets the current char. To save the char for the future swap (remember, the swapper gets storer in the next iteration)
				chars[i] = swapper; //finally, after all the saving and storing is done, the char is swapped for the previous value that was stored
//				System.out.printf("==  #%d shift: %s, (%s)\n", i, new String(chars), storer); //can comment out, helped to visualize loop action
			}
			chars[0] = storer;
		}
		
		System.out.printf("==  original: %s ==\n", s);
		System.out.printf("== end shift: %s ==\n", new String(chars));
		
	}

}
