
public class TowersOfHanoi {

	public static void main(String[] args) {
		
		towers(2, "SSSS", "MMMM", "TTTT");

	}
	
	public static void towers(int nD, String s,String m, String t){
		if(nD==0) return;
		
		towers(nD-1, s, t, m);
		System.out.println("Move Disk from " + s + " to " + t);
		towers(nD-1, m, s, t);
	}

}
