import java.util.Scanner;

/**
 * By        : Lou (Louise) Lai 
 * Professor : Evan Korth
 * Date      : 22 January 2016
 * About     : Takes an array of any size and determines if it is A) sorted in ascending order B) sorted in descending order C) not sorted
 */

public class IsSortedAdvanced {

	public static void main(String[] args) {
		System.out.println("Enter numbers to be input, separated by comma");
		Scanner input = new Scanner(System.in);
	
		
		int arraySize = 0;
		System.out.println("whoeowuehr");
		while(input.hasNextInt()){
			System.out.println("hey there " + arraySize);
			arraySize = arraySize + 1;
			input.nextInt();
			System.out.println("===");
		}
		System.out.println("hasdf");
		
	
		//generateArray(input);
	}
	
	private static int[] generateArray(Scanner s) {
		System.out.println(findArraySize(s));
		while(s.hasNextInt()){
			System.out.println(s.nextInt());
		}
		return null;
	}
	
	private static int findArraySize(Scanner s){
		int arraySize = 0;
		while(s.hasNextInt()){
			System.out.println("hey there " + arraySize);
			arraySize = arraySize + 1;
			s.nextInt();
			System.out.println("===");
		}
		System.out.println("hasdf");
		System.out.println(arraySize);
		return arraySize;
	}

}
