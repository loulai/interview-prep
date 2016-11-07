package findSecondLargest;

public class FindSecondLargestAgain {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		System.out.println(findSecondLargest(nums));
	}
	
	/** finds and then returns the second largest integer in an array of integers
	 * @param nums int[] the array to be examined
	 * @return      int   the second largest integer in the array in question
	 */
	public static int findSecondLargest(int[] nums){
		int largest = nums[0];
		int secondLargest = Integer.MIN_VALUE; //peg to the bottom, so that the second if statement must run at least once to
		                                        //assign a value that is bigger than MIN_VALUE but smaller than largest
		
		for(int i = 0; i < nums.length; i++){
			if(nums[i] > largest){
				secondLargest = largest;
				largest = nums[i];
			}
			if(nums[i] > secondLargest && nums[i] <= largest) secondLargest = nums[i];
		}
		return secondLargest;
	}

}
