/** summing an array **/
package basicSum;

public class Sum {

	public static void main(String[] args) {
		
		int[] nums = {2,2,2,12};
		System.out.println(sumArray(nums));

	}
	
	//method sums the contents of an integer array
	public static int sumArray(int[] nums){
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum = sum + nums[i]; 
		}
		return sum;
	}
	
}
