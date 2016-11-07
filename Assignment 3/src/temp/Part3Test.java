package temp;

public class Part3Test {

	public static void main(String[] args) {
		//added for double checking 
		
		/* slow stack 1 */
		SlowMaxStack slow = new SlowMaxStack(new SlowIntegerMaximizer());
		slow.push(1);
		slow.push(2);
		slow.push(3);
		slow.push(2);
		System.out.println("1. Slow Max Stack result: " + slow.getMaxSoFar());
		
		
		/* fast stack 1 */
		FastMaxStack fast = new FastMaxStack(new FastIntegerMaximizer());
		fast.push(1);
		fast.push(2);
		fast.push(3);
		fast.push(2);
		System.out.println("1. Fast Max Stack result: " + fast.getMaxSoFar() + "\n");
		
		
		/* slow stack 2 */
		SlowMaxStack slow2 = new SlowMaxStack(new SlowIntegerMaximizer());
		slow2.push(1);
		slow2.push(1);
		slow2.push(1);
		slow2.push(1);
		System.out.println("2. Slow Max Stack result: " + slow2.getMaxSoFar());
		
		/* fast stack 2 */
		FastMaxStack fast2 = new FastMaxStack(new FastIntegerMaximizer());
		fast2.push(1);
		fast2.push(1);
		fast2.push(1);
		fast2.push(1);
		System.out.println("2. Fast Max Stack result: " + fast2.getMaxSoFar() + "\n");
		
		/* slow stack 3 */
		SlowMaxStack slow3 = new SlowMaxStack(new SlowIntegerMaximizer());
		slow3.push(-1);
		slow3.push(-2);
		slow3.push(-3);
		slow3.push(-4);
		System.out.println("3. Slow Max Stack result: " + slow3.getMaxSoFar());
		
		/* fast stack 2 */
		FastMaxStack fast3 = new FastMaxStack(new FastIntegerMaximizer());
		fast3.push(-1);
		fast3.push(-2);
		fast3.push(-3);
		fast3.push(-4);
		System.out.println("3. Fast Max Stack result: " + fast3.getMaxSoFar() + "\n");
		

	}

}
