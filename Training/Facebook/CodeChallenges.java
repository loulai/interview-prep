
public class CodeChallenges {

	public static void main(String[] args) {
		System.out.println("hell");

	}
	
	public static int combo(int sum){
		//1, 5, 20, 50
		if(sum == 0) return 0;
		int ways = sum;
		/* ways of stuffing whole same number bills in */ 
		
		if(sum % 5)
		if(sum%50 == 0){
			
		} else if(sum%20 == 0){ //divisible by 20
			ways = ways + (sum/20); //add on #20bills that can fit
			ways = ways + (sum/5);  //add on #5bills that can fit
		} else if (sum%5 == 0){ //not divisible by 20 but divisible by 5 (like 15)
			ways = ways + (sum/5); //add on #5bills that can fit
		} 

		return ways;
	}

}
