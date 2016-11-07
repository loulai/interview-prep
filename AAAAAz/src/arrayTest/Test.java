package arrayTest;

public class Test {

	public static void main(String[] args) {
		String[] s1 = {"hello", "goodbye", "coffee"};
		String[] s2 = s1;
		
//		for (int i = 0; i < s1.length; i++) {
//			System.out.println(s1[i]);
//			System.out.println(s2[i]);
//			System.out.println();
//		}
		
		s1[0] = "replaced!";
		
		for (int i = 0; i < s1.length; i++) {
			System.out.println(s1[i]);
			System.out.println(s2[i]);
			System.out.println();
		}
		
	}

}
