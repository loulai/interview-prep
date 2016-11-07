import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int number = 3;
		int[] numbers = new int[1];
		numbers[0] = 5;
		m(number, numbers);
		System.out.println("number is " + number + " and numbers[0] is " + numbers[0]);
		
	}
	
	public static void m(int x, int[] y) {
		x=3;
		y[0] = 3;
	}
}