
public class sol {

	public static void main(String[] args) {
		System.out.println(numWays(6));
	}
	
	public static int numWays(int n){
		if(n < 0) return 0;
		if(n == 0) return 1;
		return numWays(n-50) + numWays(n-20) + numWays(n-5) + numWays(n-1);
	}
}
