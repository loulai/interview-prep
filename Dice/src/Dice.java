
/*Author     : Louise (Lou) Lai
 *Created on : September 13th 2014
 *Description: Program stimulates rolling a dice 100,00 times. It prints the occurrence,
 *             in percentage, of each result.
 */


public class Dice {

	public static void main(String[] args) {
		
		// Concept: six 'counters' are responsible for keeping count of the number
		// of times a dice face is rolled. i.e. 'oneCounter' keeps track of the 
		// number of times 1 is rolled.
		
		// First, each counter is initialized as an integer.
		
		int oneCounter = 0;
		int twoCounter = 0;
		int threeCounter = 0;
		int fourCounter = 0;
		int fiveCounter = 0;
		int sixCounter = 0;
		
		// The loop runs 100,000 times
		for (int i = 0; i < 100000; i++) {
			
			// Within the for loop..
			
			//.. a random number is generated, and modified to span
			//   numbers 0.0 to 6.0 (non-inclusive).
			Double dice = Math.random() * 6.0;
			
			//.. each counter is incremented by one when their 
			//   respective dice face is rolled.
			
			if (dice < 1) {
				oneCounter++;
			} else if (dice < 2) {
				twoCounter++;
			} else if (dice < 3) {
				threeCounter++;
			} else if (dice < 4) {
				fourCounter++;
			} else if (dice < 5) {
				fiveCounter++;
			} else {
				sixCounter++;
			}
		}
		

		// prints the percentage of times dice face is rolled.
		System.out.printf("1 was rolled %.4f%% of the times. \n", + (oneCounter/100000.0)*100);	
		System.out.printf("2 was rolled %.4f%% of the times. \n", + (twoCounter/100000.0)*100);
		System.out.printf("3 was rolled %.4f%% of the times. \n", + (threeCounter/100000.0)*100);
		System.out.printf("4 was rolled %.4f%% of the times. \n", + (fourCounter/100000.0)*100);	
		System.out.printf("5 was rolled %.4f%% of the times. \n", + (fiveCounter/100000.0)*100);
		System.out.printf("6 was rolled %.4f%% of the times. \n", + (sixCounter/100000.0)*100);
	
	}

}
