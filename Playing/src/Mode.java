public class Mode {
	public static void main(String[] args) {
		int[] numArr = {1,2,3,4,5};
		System.out.println(containsDuplicate(numArr));
	}
	
	public static boolean containsDuplicate(int[] nums) {
		boolean containsDuplicate = false;
		
		for(int i = 0; i < nums.length; i++){
			int hold = nums[i];
			System.out.println("("+ i +") === " + hold + " ===");
			for(int k = 0; k < nums.length; k ++){
				if((i) != k){
					System.out.print("(" + k + ")");
					if(hold == nums[k]){
						System.out.println(nums[k]);
						containsDuplicate = true;
					}
				}
			}
		}
	
		return containsDuplicate;
	}
}




//11:30 - 1:30