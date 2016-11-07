package flips;
import java.util.Scanner;

public class HorizonalFlipArray {

		public static void main(String[] args) {
			System.out.println("input word to be pivoted, then hit enter: ");
			Scanner input = new Scanner(System.in);
			char[] letters = input.nextLine().toCharArray();
			
			//printing out
			for(int i = 0; i < letters.length; i++) System.out.print(letters[i] + " ");
			System.out.println();
			for(int i = 0; i < (2*letters.length); i++) System.out.print("=");
			System.out.println();
			for(int i = 0; i < letters.length; i++) System.out.print(horizontalFlip(letters)[i] + " ");
			
		}
		
		public static char[] horizontalFlip(char[] letters){
			char[] flipped = new char[letters.length];
			for(int i = 0; i < letters.length; i++) flipped[i] = letters[letters.length - 1- i];
			return flipped;
		}

	}

