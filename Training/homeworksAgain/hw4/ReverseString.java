package hw4;
import java.util.Scanner;
public class ReverseString {

	public static void main(String[] args) {
		System.out.println("input the string you want to reverse, then press enter: ");
		Scanner input = new Scanner(System.in);
		String s = input.nextLine(); //nextLine() takes until line break
		char[] chars = s.toCharArray();
		char temp;

		for(int i = 0; i < (chars.length/2); i++){ // only needs to go half the length, and for odds the integer division takes care of
			                                       // the middle val not needing to be swapped
			
			/*kind of the same idea as bubble swap; temp is the storer, and the just swap things around*/
			temp = chars[i];                 
			chars[i] = chars[chars.length - (i + 1)]; //first case is e.g. chars.length - 1, then chars.length - 2, so the i changes each time
			chars[chars.length - (i + 1)] = temp;
		}
		
		//just printing and making the output of printing the char array look like a string with print (instead of println.. sneaky huh)
		System.out.println("== OLD: " + s + " ==");
		System.out.print("== NEW: ");
		for(int i = 0; i < chars.length; i++){
			System.out.print(chars[i]);
		}
		System.out.print(" ==");
	}

}