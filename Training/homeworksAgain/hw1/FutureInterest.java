package hw1;

import java.util.Scanner;

public class FutureInterest {

	public static void main(String[] args) {
		boolean again = true;
		while(again){
			System.out.println("===type (decimal) investment amount, (decimal) annual interest rate as a percent, (integer) number of years. In space separated order: ===");
			Scanner in = new Scanner(System.in);
			
			double amount = in.nextDouble();
			double rate = in.nextDouble();
			rate = rate / 100;
			int year = in.nextInt();
			
			double mult = 1 + rate;
			double futureVal;
			
			if(year == 1){
				futureVal = amount * mult;
			} else{
				for(int i = 0; i < year - 1; i++){
					mult = mult * (1+rate); //mult is effictively the 'endsum' (see RaiseToItself.java), and 1+rate is the thing that consistently is multiplied
				}
				futureVal = amount * mult;
			}
			System.out.printf("\n=== Your final investment value after %s years is $%4.2f ===", year, futureVal);
			System.out.printf("\n=== Profit: $%4.2f ===", (futureVal - amount));
			System.out.printf("\n\n<<<<<Do you want to play again? Type Y/N>>>>>\n");
			Scanner in2 = new Scanner(System.in);
			String yesNo = in2.next();
			
			if(yesNo.compareToIgnoreCase("Y") == 0  || yesNo.compareToIgnoreCase("Y") == 0 ){} 
			else if(yesNo.compareToIgnoreCase("N") == 0  || yesNo.compareToIgnoreCase("n") == 0 ){again = false;}
			else {
				System.out.print("invalid output");
				again = false;
			}
	
		}

		}
		
}
