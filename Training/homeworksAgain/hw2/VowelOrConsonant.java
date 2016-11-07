package hw2;
import java.util.Scanner;
public class VowelOrConsonant {

	public static void main(String[] args) {
		
		System.out.println("input character:");
		Scanner input = new Scanner(System.in);

		char c = input.next().charAt(0);
		c = Character.toLowerCase(c);
		
		switch (c){
		case 'a': case 'e': case 'i': case 'o': case 'u':
			System.out.println("is a vowel");
			break;
		default:
			if(!Character.isLetter(c)){
				System.out.println("is not a letter");
				break;
			} else{
				System.out.println("is a consonant");
				break;
			}
		}
	}

}
