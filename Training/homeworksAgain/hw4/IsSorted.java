package hw4;
import java.util.Scanner;
public class IsSorted {

	public static void main(String[] args) {
		System.out.println("input ten numbers:");
		Scanner input = new Scanner(System.in);
		int[] intA = new int[10];
		boolean desc = true;
		boolean asc = true;
		
		for(int i = 0; i < 10; i++){
			intA[i] = input.nextInt();
		}
		
		for(int i = 0; i < 9; i++){
			if(intA[i] > intA[i + 1]) asc = false;
			if(intA[i] < intA[i + 1]) desc = false;
		}
		
		if(desc == true && asc == true) System.out.println("=== why are all numbers the same you troll ===");
		else if(asc == true) System.out.println("===list is sorted from SMALL to BIG (ascending)==");
		else if(desc == true) System.out.println("===list is sorted from BIG to SMALL (descending)===");
		else System.out.println("==list is not sorted at all===");
	}

}
