/** playing with all things odd and even **/
package findThenSum;

public class FindThenSum {

	 public static void main(String[] args){
		 int finalSum = sumEvensBetween(1,4, "inclusive");
		 System.out.println(finalSum);
		 System.out.println(sumOddsBetween(0,5, "inclusive"));
	 }
	 
	 /* given an interval, sum all the even numbers in between. User specifies if end values are inclusive or not. */
	 public static int sumEvensBetween(int first, int last, String mod){
		 int sum = 0;
		 if(mod.equalsIgnoreCase("inclusive")){
			 if(first%2 != 0) first = first + 1; //make even if starting value is odd
			 for(int i = first; i <= last; i+=2) sum = sum + i;
		 } else if (mod.equalsIgnoreCase("not inclusive")){
			 if(first%2 == 0) first = first + 2; //if the starting value is even, add two so the first num isn't included in the final sum
			 else first = first + 1; //if starting value is odd, make even
			 for(int i = first; i < last; i+=2) sum = sum + i;//stops when it is LESS THAN last (equals is removed)
		 }
		 return sum;
	 }
	 
	 /* this time sum odds, ends also inclusive/not also depends on user input */
	 public static int sumOddsBetween(int first, int last, String mod){
		 int sum = 0;
		
		 if(mod.equalsIgnoreCase("inclusive")){
			 if(first%2 != 1) first = first + 1;
			 for (int i = first; i <= last; i+=2) sum = sum + i;
		 } else if (mod.equalsIgnoreCase("not inclusive")){
			 if(first%2 != 1) first = first + 1; //if even (i.e. mod of 2 does not have remainder 1), make odd by adding 1
			 else first = first + 2; //if odd, add 2 to move onto the next odd num
			 for(int i = first; i < last; i+=2) sum = sum + i;
		 }
		 return sum;
	 }
}
