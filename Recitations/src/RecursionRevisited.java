
public class RecursionRevisited {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,7,7,8};
		
		System.out.println(binarySearch(arr, 7, 0, 9));
	
	}
	
	public static int binarySearch(int[] arr, int n, int first, int last){
		if(first == (last-1)) return -1;
		int mid = (last - first)/2 + first;
		
		if(arr[mid] > n) {
			return binarySearch(arr, n, 0, mid-1); //changing last value to focus on lower half
		} else if (arr[mid] < n){
			return binarySearch(arr, n, mid+1, last); //changing start value to focus on the upper half
		} else {
			return mid; //only happens when found the value
		}
	}

}
