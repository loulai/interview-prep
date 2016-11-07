/*Author     : Louise (Lou) Lai
 *Created on : September 10th 2014
 *Description: Program prints an approximation of π (pi)
 */

public class Pi {

	public static void main(String[] args) {
		
		//calculating and printing the first version of pi.
		double firstPi = 4 * (1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0);
		System.out.println("1st version of π: " + firstPi);

		//calculating and printing the second version of pi.
		double secondPi = 4 * (1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0 + 1.0/13.0);
		System.out.println("2nd version of π: " + secondPi);
		
		// The above to values of pi are not very accurate. However, the second version of pi
		// is more accurate, and that can be correlated to the additional term it has.
	
		// extra credit section begins
		
		//'sum' is the total value after adding all the fractions. It starts at 1, then 1/3 is added, 
		// then 1/5 is subtracted, and so forth 99 times.
		double sum = 1;
		
		// the denominator begins as 3.
		int denominator = 3;
		
		// It is only looped 99 times because the first value (1) counts as the first term.
		for (int i = 0; i < 99; i++) {
			
			// important pattern: the fraction is either added or subtracted,
			// depending on its position.
			if( i % 2 == 0) {
				sum = sum - (1.0/denominator);
			} else {
				sum = sum + (1.0/denominator);
			}
			
			//important pattern #2: the fraction's denominator is always 
			// incremented by two each time.
			denominator = denominator + 2;
		}
		
		// finally, after the for loop has run 99 times, do the final 
		// calculation and print. 
		System.out.print("Extra credit version of π: " + (4 * sum) );
		
		// This version is much more accurate.
	}
	

	
}
