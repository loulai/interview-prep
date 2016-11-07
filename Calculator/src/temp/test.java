package temp;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		PostFixEvaluator fx = new PostFixEvaluator();
		
		System.out.println(fx.evaluate("4 2 + 3 - 3 *"));
	}

}
