/**
 * takes two sorted arrays and merges them together. The end array is sorted.
 */
package hw5;

import java.util.Scanner;

public class SortedMerge {
	
	public static void main(String[] args) {
		
		boolean again1 = true;
		int size1 = 1; double[] list1 = new double[size1]; //must initialize outside while loop! It doesn't matter what the size is, it just needs to be initialized
		while(again1){
			//getting user input. First size of the array, then the content. Same process for the second array.
			System.out.print("===#1\nSize of first array: ");
			Scanner input1 = new Scanner(System.in);
			size1 = input1.nextInt();
			list1 = new double[size1];
			System.out.printf("Input %s numbers from smallest to largest, and end with enter:", size1);
			Scanner input2 = new Scanner(System.in);
			for(int i = 0; i < size1; i++){
				list1[i] = input2.nextDouble();
			}
			
			if(isSorted(list1)){
				again1 = false;
			} else {
				System.out.println(">>>>> Array is not sorted from smallest to largest; you shall not pass. Try again. <<<<<"); //again is still set to true
			}
			
		}
		
		boolean again2 = true;
		int size2 = 1; double[] list2 = new double[1]; 
		while(again2){
			System.out.print("===#2\nSize of second array: ");
			Scanner input3 = new Scanner(System.in);
			size2 = input3.nextInt();
			list2 = new double[size2];
			System.out.printf("Input %s numbers from smallest to largest, and end with enter:", size2);
			Scanner input4 = new Scanner(System.in);
			for(int i = 0; i < size2; i++){
				list2[i] = input4.nextDouble();
			}
			
			if(isSorted(list2)){
				again2 = false;
			} else{
				System.out.println(">>>>> Array 2 not sorted. None for you Gretchen. Try again.  <<<<<");
			}
		}
		
		
		double[] total = new double[size1 + size2]; //creating new array size of both entered arrays
		
		/* concept: compare elements from list1 and list2. The smaller one will be inserted into the new array, and because both lists are sorted, 
		 *          we will end up with a sorted array.
		 * how: each array has a counter, and that dictates which value is being compared. Towards the end, when one array has been completely
		 *      'inserted' into the final array, the remaining values of the other array are inserted in (naturally, it is sorted).
		 *       e.g. [1,2,4] and [3,5,6]. list1 will reach the 'end' when 4 is copied into final array. The if statement goes into the if else
		 *       section, and the remaining values in list2 (5 and 6) are inserted into final array.
		 */
		int c1 = 0; //initializing counters
		int c2 = 0;
		
		for(int i = 0; i < total.length; i++){
			
			/*filling in final array with whichever value is smallest*/
			if(c1 < size1 && c2 < size2){
				
				if(list1[c1] <= list2[c2]) total[i] = list1[c1++];//increment each time one value of the array has been inserted. Same below for list2.
				else if (list1[c1] > list2[c2]) total[i] = list2[c2++];
				
			/*when the 'end' of a list is reached*/
			} else if(c1 >= size1) total[i] = list2[c2++]; //list1 has been 'used up' fill the remaining spaces in final array with remaining values from list2
			  else if (c2 >= size2){ total[i] = list1[c1++];//list2 used up this time, so fill with leftover list1 values
			}
		}
		//nice output
		System.out.printf("\n==========  First Array (%d): ===============\n", size1);
		for(int i = 0; i < size1; i++){
			System.out.printf("[%3.1f] ",list1[i]);
		}	
		
		System.out.printf("\n========== Second Array (%d): ===============\n", size2);
		for(int i = 0; i < size2; i++){
			System.out.printf("[%3.1f] ",list2[i]);
		}	
		System.out.printf("\n========== Merged Array (%d): =============== <<<<\n", total.length);
		for(int i = 0; i < total.length; i++){
			System.out.printf("[%3.1f] ",total[i]);
		}	
	}

	/** checks to see is a given list of doubles is sorted from smallest to largest (ascending) order
	 * @param list double[] List that needs to be determined if sorted or not
	 * @return      boolean  true if it is sorted, false otherwise
	 */
	private static boolean isSorted(double[] list){
		boolean isSorted = true;
		for(int i =  0; i < list.length - 1; i++){
			if(list[i] > list[i + 1]){
				isSorted = false;
			}
		}
		return isSorted;
	}
}
