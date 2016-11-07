
public class Test {

	public static void main(String[] args) {
		
		sumOfDigits(1234);

	}
	
//	public static int recPrint(int i){
//		int num = 0;
//		if(i%10 == 0){
//			System.out.println(0 + "");
//		} else{
//			num = recPrint(i/10);
//			System.out.println(num);
//		}
//		return num;
//	}
//	
	public static int sumOfDigits(int n){
		if(n/10 == 0){
			return n;
		} else {
			System.out.println((n%10) + sumOfDigits(n/10));
			return((n%10) + sumOfDigits(n/10));
		}
	}

}
