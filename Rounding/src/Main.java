
public class Main {

	public static void main(String[] args) {
	
		for (int i = 0; i < 7; i++) {
			Double myDouble = Math.random() * 8 + 1;
			
			long myLong = Math.round(myDouble);
			
			System.out.println(myLong);
		}
		

	}

}
