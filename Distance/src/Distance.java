import java.util.Scanner;

/*Author     : Louise (Lou) Lai
 *Created on : September 10th 2014
 *Description: Program computes the distance between points, which are input by the user.
 */

public class Distance {

	public static void main(String[] args) {
		
		System.out.println("This program will calculate the distance between points (x1, y1) and (x2, y2).");
		
		//asking for user input
		System.out.println("Please input the desired x1 value and press enter: ");
		Scanner input1 = new Scanner(System.in);
		int x1 = input1.nextInt();
		
		System.out.println("Please input the desired y1 value and press enter: ");
		Scanner input2 = new Scanner(System.in);
		int y1 = input2.nextInt();
		
		System.out.println("Please input the desired x2 value and press enter: ");
		Scanner input3 = new Scanner(System.in);
		int x2 = input3.nextInt();
		
		System.out.println("Please input the desired y2 value and press enter: ");
		Scanner input4 = new Scanner(System.in);
		int y2 = input4.nextInt();
		
		//first, calculating the distance between X and Y respectively and assigning the sums to variables
		int distanceBetweenX = x2 - x1;
		int distanceBetweenY = y2 - y1;
		
		//second, summing the squares of the distance with an outside method*
		Double sum = square(distanceBetweenX) + square(distanceBetweenY);
		
		//finally, taking the square root of the sum
	    Double finalDistance = Math.sqrt(sum);
	    
	    System.out.println("The distance between the two points is: " + finalDistance);
	    
	}
	
	// *extracted method that squares a value, and returns the result as a double.
	public static double square(int value) {
		double SquaredAnswer = value * value;
		return SquaredAnswer;
	}

}
