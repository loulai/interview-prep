import java.util.Scanner;

/*Author     : Louise (Lou) Lai
 *Created on : September 10th 2014
 *Description: Program computes and prints future investment. It takes 3 user inputs: investment amount, 
 *             annual interest rate and number of years.
 */

public class Interest {

	public static void main(String[] args) {
		
		// user is prompted for initial investment amount.
		System.out.println("1. Please input the initial investment amount: ");
		Scanner input1 = new Scanner(System.in);
		double investmentAmount = input1.nextDouble();
		
		// user is prompted for annual interest rate.
		System.out.println("2. Please input the annual interest rate: ");
		Scanner input2 = new Scanner(System.in);
		double annualInterestRate = input2.nextDouble();
		
		// user is prompted for number of years investing.
		System.out.println("3. Please input the number of years: ");
		Scanner input3 = new Scanner(System.in);
		double numberOfYears = input1.nextDouble();
		
		// a for loop is set up to execute 'numberOfYears' times.
		for (int i = 0; i < numberOfYears; i++){
			
			// the 'interest on the investment' is added to 'interest'
			// which is done 'numberOfYears' times, so in effect is being raised
			// to the power of 'numberOfYears'. 
			investmentAmount = investmentAmount + investmentAmount * annualInterestRate; 
			
			// the final amount is printed
			if (i == numberOfYears - 1) {
				System.out.printf("The future investment value at the end of %d years is $%.4f", i+1, investmentAmount);
			}
			
		}
		
	}
	
}
