import java.util.Scanner;

/**
 *Created on : October 16th 2014
 *Description: Merges two arrays that are already sorted, and returns a new array that is sorted.
 *@author Lou Lai
 */
public class SortedMerge {

	public static void main(String[] args) {
		//first takes the length of the array from the user, then the numbers in the array.
		System.out.println("---How long is your first array?");
		System.out.println("---Enter integer: ");
		Scanner input1 = new Scanner(System.in);
		int aLength = input1.nextInt();
		double[] arrayA = new double[aLength];
		
		System.out.println("Note: numbers MUST be in a sorted order.");
		
		//asking for the numbers to put in the first array
		for(int i=0; i < aLength; i++ ){
			System.out.println("Insert number " + (i + 1) + ": ");
			Scanner inputA = new Scanner(System.in);
			int num = inputA.nextInt();
			arrayA[i] = num;
		}
		
		if(!isSorted(arrayA)){
			System.out.println("===You shall not pass. First array is not sorted.===");
			System.exit(0);
		}
		
		//exact same thing as above
		System.out.println("---How long is your second array? Enter integer: ");
		Scanner input2 = new Scanner(System.in);
		int bLength = input2.nextInt();
		double[] arrayB = new double[bLength];
		
		for(int i=0; i < bLength; i++ ){
			System.out.println("Insert number " + (i + 1) + ": ");
			Scanner inputB = new Scanner(System.in);
			int num = inputB.nextInt();
			arrayB[i] = num;
		}
		
		if(!isSorted(arrayB)){
			System.out.println("===You shall not pass. Second array is not sorted.===");
			System.exit(0);
		}
		
		//END of asking for user input
		//counting the combined length of two arrays
		int combinedLength = aLength + bLength;
		double[] finalArray = merge(arrayA, arrayB); 
		
		System.out.println("The final merged array is: ");
		for(int i = 0; i < combinedLength; i++){
			if(i != combinedLength - 1){ //if statement accounts for the last number
				System.out.print(finalArray[i] + ", ");
			}else {
				System.out.print(finalArray[i] + " ");
			}
			
		}
		
	}

	/** method merges two sorted array, and returns a new sorted array
	 * @param arrayA the first array 
	 * @param arrayB the second array
	 * @return       an array of floats
	 */
	private static double[] merge(double[] arrayA, double[] arrayB) {
		int aLength = arrayA.length;
		int bLength = arrayB.length;
		int combinedLength = aLength + bLength;
		double[] mergedArray = new double[combinedLength]; //initializing array that is length of combined lengths
	
		int combined = 0; //wil be used as the combined index of the new array
		int a = 0; //used as the index of array A
		int b = 0; //used as the index of array B

		while(a < arrayA.length && b < arrayB.length){ //runs while the a and b counters are not at the end of the array
			if(arrayA[a] < arrayB[b]){ //compares two integers from arrayA and B
				mergedArray[combined] = arrayA[a]; //adds the smaller number to the new array
				combined++; a++; 
			} else {
				mergedArray[combined] = arrayB[b];
				combined++; b++;
			}
		}
		
		while (a < arrayA.length) { //this while loops accounts for the end of the array
			mergedArray[combined] = arrayA[a]; //replacing the leftover spaces from arrayA
			combined++; a++; // increment
		}
		
		while (b < arrayB.length) {
			mergedArray[combined] = arrayB[b]; //same as while loops for A (just above)
			combined++; b++;
		}
		return mergedArray;
	}
	
	//created from last homework
	private static boolean isSorted(double[] someArray) {
		boolean isSorted = true;
		for(int i = 0; i < someArray.length-1; i++){ 
			if(someArray[i] > someArray[i+1]){ 
				isSorted = false;    
			} 
		}
		
			if(isSorted) {
				return isSorted;
			} else {
				isSorted = false;
				return isSorted;
			}
	}
	

} 
