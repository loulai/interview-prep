package findSecondLargest;

public class SecondLargest {

	public static void main(String[] args) {
		int[] numArr = {300,1,6,-9,8,19,21,20};
		int big1 = numArr[0]; //first integer in array
		int big2 = Integer.MIN_VALUE; //pegged as the lowest num
		
		for(int i = 0; i < numArr.length; i++){
			if(numArr[i] > big1) {
				big2 = big1;
				big1 = numArr[i]; 
			}
			if(numArr[i] > big2 && numArr[i] < big1) big2 = numArr[i];
		}
		System.out.printf("     biggest: %d\n 2nd biggest: %d\n", big1, big2);
	}

}
