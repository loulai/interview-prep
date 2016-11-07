package hw1;

public class Pi{
	
	public static void main(String[] args) {
		
		double n1 = 4 * (1 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11);
		double n2 =  4 * (1 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);
		
		System.out.println(n1);
		System.out.println(n2);
		
		double num = 1;
		int d = 1;
		
		/* logic for loop: The loop runs 100 times, starting at 1. Depending on whether or not it's an odd or even number, add or subtract something.
		 * logic for num: it's originally one, and must be added or subtracted then multiplied by 4.
		 * logic for denominator (d): it increments by 2 each time, and must be incremented regardless of if i was even or odd (this
		 * wasn't realized to mistakes happened).
		 * Finally, times the value by 4.
		 */
		for (int i = 1; i < 101; i++){
			if(i == 1){}
			else if(i%2 == 0){
				d+=2;
				num = num - 1.0/d;
			} else {
				d+=2;
				num = num + 1.0/d;
			}
		}
		System.out.println(4 * num);
	}


}
