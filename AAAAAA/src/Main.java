
public class Main {

	public static void main(String[] args) {
		String digits = "01";
		otherSum(digits);
	}

	private static void otherSum(String s) {
		char[] myArray = s.toCharArray();
		int sum = 0;
		for (int i = 0; i < myArray.length; i++){
			System.out.println(myArray[i])
			if (myArray[i]%2 == 0){
				System.out.println(myArray[i]);
				sum = sum + myArray[i];
				System.out.println(sum);
			}
		}
		System.out.println(sum);
	}
}
