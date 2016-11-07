import java.util.Random;

public class Main {
	public static void main(String[] args) {
		String[] colours = {"grey", "blue", "green", "red", "pink", "purple", "black", "brown", "white", "beige"}; 
		String[] bodyParts = {"elbow", "pinky", "nose", "knee", "ear", "shoulder", "butts", "hip", "inner elbow", "thumb"}; 
		int num1 = (int) (Math.random() * (colours.length));
		int num2 = (int) (Math.random() * (bodyParts.length));
		System.out.print(colours[num1] + " ");
		System.out.print(bodyParts[num2]);
		
		for(int i = 0; i<100; i++){
			System.out.println(Math.random() * 7);
		}
	}

}
