package linearSearch;

public class LinearSearch {

	public static void main(String[] args) {
		
		String key = "hello";
		String[] w1 = {"yo", "homeless", "man", "hello"};
		String[] w2 = {"yo", "homeless", "man", "buhbye"};

		System.out.println(LinearSearch.includes(key, w2));
	}
	
	/** method searches an array to determine if a string is contained within the array. Returns true if found, else returns false.
	 * @param key     the String in question; the String to be searched for
	 * @param arr     the array to be searched through for the key
	 * @return boolean true if string is included in array, false otherwise
	 */
	public static boolean includes(String key, String[] arr){
		boolean contains = false; //false unless something is found that sets this varaiable to true
		for(int i = 0; i < arr.length; i++){ //loop through length of the array
			if(arr[i].equalsIgnoreCase(key)) contains = true;
		}
		return contains;
	}
}
