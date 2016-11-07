
public class QuickSort {
	
	public static void main(String[] args){
		int[] data = new int[]{5, 10, 1, 9, 4, 8, 3, 6, 2, 7};
		quickSort(data, 0, data.length - 1);
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
	}
	
	public static void quickSort(int[] arr, int left, int right){
		int i = left;
		int j = right;
		int temp;
		int pivot = arr[(left + right)/2];
		while(i <= j) {
			while(arr[i] < pivot) //while the left data is less than the pivot
				i++;//keep moving up
			while(arr[j] > pivot) //while the right data is greater than the pivot
				j--; //keep moving down
			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (left < j)
			quickSort(arr, left,j);
		if (i < right)
			quickSort(arr, i, right);
	}
	
}
