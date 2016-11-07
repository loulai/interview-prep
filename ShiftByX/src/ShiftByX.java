import java.util.Scanner;

/**
 *Created on : October 16th 2014
 *Description: Program shifts the words of an inputted string by X number of characters, which is indicated by the user.
 *@author Lou Lai
 */
public class ShiftByX {

	public static void main(String[] args) {
		//getting input and storing strings and shift by how many integer
		System.out.println("Please input string: ");
		Scanner input = new Scanner(System.in);
		String originalString = input.nextLine();
		
		System.out.println("How characters to shift by? Input integer: ");
		Scanner input2 = new Scanner(System.in);
		int shiftInt = input.nextInt();
	
		//runs as many times as the user input indicates, and calls the shift method
		for (int i = 0; i < shiftInt; i++){
			originalString = shift(originalString);
		}
		
		System.out.println(originalString);
	
	}
	
	//shift method from ShiftByOne
	public static String shift(String notShiftedString){
				char[] letters = notShiftedString.toCharArray();
				int stringLength = letters.length;
				char stored1 = letters[stringLength - 1];
				char stored2 = letters[0];
				
				for(int i = 0; i < stringLength-1; i++){
					letters[i] = stored1; 
					stored1 = stored2;    
					stored2 = letters[i + 1]; 
				}
			
				letters[stringLength - 1] = stored1;
				String shiftedWord = new String(letters);
				return shiftedWord;
	}

}
