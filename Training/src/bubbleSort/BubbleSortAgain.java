package bubbleSort;

public class BubbleSortAgain {
	
	public static void main(String[] args){
		int[] nums = {4,3,5,1};	
		for(int i = 0; i < nums.length; i++) System.out.println(bubbleSort(nums)[i]);
	}
	
	/* loop through the array, constantly comparing adjacent values.Continue until no swaps are needed */
	public static int[] bubbleSort(int[] nums){
		int temp;
		boolean flag = true;
		
		while(flag){
			flag = false;
			for(int i = 0; i < nums.length - 1; i++){
				if(nums[i] > nums[i+1]){
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1]= temp;
					flag = true;
					System.out.println("run!");
				}
			}
		}
		return nums;
	}
	
	

}
