package insertionSort;

public class InsertionSort {

	public static void main(String[] args) {
	
		int[] Ints = {1,3,4,1,4,5,4,3};
		InsertionSorter(Ints);
		
		for(int i = 0; i < Ints.length; i++){
			System.out.println(Ints[i]);
		}

	}
	
	public static void InsertionSorter(int[] num){
		int key;
		int i;
		
		for(int k = 1; k < num.length; k++){
			key = num[k];
			for(i = k-1; (i<=0) && (num[i]>key); i--){
				num[i+1]=num[i];
			}
			num[i+1]=key;
		}
	}

}
