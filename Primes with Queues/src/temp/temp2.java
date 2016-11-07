package temp;
import java.io.*;
import java.util.*;


public class temp2 {
	
	  public static int findMissing(int[] a) {
	    int completeSum = a.length + 1; 
	    int incompleteSum = 0;
	    int missingNumber;
	    
	    //summing all the numbers from 1 until 'n' if there were no missing numbers
	    for(int i = 1; i <= a.length; i++){
	    	completeSum = completeSum + i;
	    }
	    
	    //summing all the numbers from the array that does have one missing number
	    for (int i = 0; i < a.length; i++){
	    	incompleteSum = incompleteSum + a[i];
	    }
	    
	    //the missing number is the difference between the complete sum and the incomplete sum
	    missingNumber = completeSum - incompleteSum;

	   return missingNumber;
	   
	  }
	  
	  public static void main(String[] args) {
		    int[] numbers = {1, 6, 4, 5, 2}; //the array with one missing number
		    System.out.printf("The missing number is %d.", findMissing(numbers));
		    // note: if {1, 2, 3, 4, 5, 6} was entered, this means the missing number is 7 
	  }
	  
}
