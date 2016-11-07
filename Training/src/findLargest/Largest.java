/**
 *  Finds the largest integer in an integer array
 */
package findLargest;
import java.util.Scanner;

public class Largest {
	
	public static void main(String[] args){
		int[] numArr = {1,2,3,4,5,8};
		int largest = numArr[0];
		
		for(int i = 0; i < numArr.length - 1; i++){
			if(numArr[i] < numArr[i + 1]) largest = numArr[i + 1]; 
		}
		System.out.println("the largest number is: " + largest);
	}

}

