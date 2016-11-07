package sortingPlay;

public class Sort {
	
	private int[] arr;

	public static void main(String[] args) {
		int[] intArr = {2,3,3,2,3,1,1,43};
		Sort myThing = new Sort(intArr);
		
		boolean flag = true;
		int temp;
		
		
	

	}
	
	public Sort(int[] a){
		this.arr = a;
	}
	
	public int[] getArray(){
		return this.arr;
	}
	
	public int[] sortArray(){
		int[] nums = this.arr;
		boolean flag = true;
		int temp;
		
		while(flag){
			flag = false;
			for(int i = 0; i < nums.length - 1; i++){
				if(nums[i] > nums[i+1]){
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1]= temp;
					flag = true;
				}
			}
		}
		return nums;
	}
	
	@Override
	public String toString(){
		String myString = "";
		for(int i = 0; i < arr.length; i ++){
			myString = myString + arr[i] + "\n";
		}
		return myString;
	}

		

}
