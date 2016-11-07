package hw4;
import java.util.Scanner;
public class theLargestNum {

	public static void main(String[] args) {
		
		System.out.println("input integers with space end with 0: ");
		Scanner input = new Scanner(System.in);
		
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int largest = n2;
		int secondLargest = n1;
		int lCounter = 1;
		if(n2 == 0) System.out.println("too few integers, at least 2 numbers please");
		if(n1 > n2) {
			secondLargest = largest;
			largest = n1;
		}
		
		while(n1 != 0){ //compare nextInt() with the last largest integer from last movement
			n1 = input.nextInt();
			if(n1 == largest) lCounter++; //add to counter only when the established 'largest' is the same as the upcoming input
			if(n1 > largest) {
				secondLargest = largest;
				largest = n1;
			}
			if(n1 < largest && n1 > secondLargest && n1 != 0) secondLargest = n1; //replaces second largest when a larger num appears that is still smaller
			                                                           //than largest. Also can't be zero.
		} 
		System.out.printf("===     LARGEST INTEGER: %d, occurs %d time(s) ===\n", largest, lCounter);
		System.out.println("=== 2ND LARGEST INTEGER: " + secondLargest + " ===");
	}

}
