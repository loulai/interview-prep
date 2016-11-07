package temp;

public class Operator {

	String stringValue; 
	
	public static void main(String[] args){
		//test
		Operator currentOperator = new Operator("("); //replace this with + - * / ^ to test
		
		System.out.println("FOR: " + currentOperator.stringValue);
		System.out.println("* --------------------------------");
		System.out.println("smaller? " + currentOperator.isSmallerThan("* "));
		System.out.println("equal  ? " + currentOperator.isEqualTo("* "));
		System.out.println("larger ? " +  currentOperator.isGreaterThan("* "));
		
		System.out.println("/ --------------------------------");
		System.out.println("smaller? " + currentOperator.isSmallerThan("/ "));
		System.out.println("equal  ? " + currentOperator.isEqualTo("/ "));
		System.out.println("larger ? " + currentOperator.isGreaterThan("/ "));
		
		System.out.println("^ --------------------------------");
		System.out.println("smaller? " + currentOperator.isSmallerThan("^ "));
		System.out.println("equal  ? " + currentOperator.isEqualTo("^ "));
		System.out.println("larger ? " + currentOperator.isGreaterThan("^ "));
		
		System.out.println("+ --------------------------------");
		System.out.println("smaller? " + currentOperator.isSmallerThan("+ "));
		System.out.println("equal  ? " + currentOperator.isEqualTo("+ "));
		System.out.println("larger ? " + currentOperator.isGreaterThan("+ "));
		
		System.out.println("- --------------------------------");
		System.out.println("smaller? " + currentOperator.isSmallerThan("- "));
		System.out.println("equal  ? " + currentOperator.isEqualTo("- "));
		System.out.println("larger ? " + currentOperator.isGreaterThan("- "));
		
		System.out.println("( --------------------------------");
		System.out.println("smaller? " + currentOperator.isSmallerThan("( "));
		System.out.println("equal  ? " + currentOperator.isEqualTo("( "));
		System.out.println("larger ? " + currentOperator.isGreaterThan("( "));
	}
	public Operator(String value) {
		this.stringValue = value;
	}
	
	/** method compares values and determines if the current value of the instance variable is "smaller" than another operator. 
	 *  The hierachy is: ( + , - ) < ( * , / , ^ )
	 * @param String   topOfStack the other String value that we compare with. This is usually the top value of the stack.
	 * @return boolean             true if value is smaller than otherValue (usually the value at top of the stack), false if larger or equal.
	 */
	public boolean isSmallerThan(String topOfStack){
		String currentOperator = this.stringValue;
		if (currentOperator.equals("(") && !topOfStack.equals("( ")){ // parenthesis will always be smallest
			return true;
		}else if (topOfStack.equals("( ") && !currentOperator.equals("(")){ //if the top of stack is (, and the current operator isn't (, current operator is always larger than top of stack operator
			return false;
		} else if ((topOfStack.equals("* ") || topOfStack.equals("/ ") || topOfStack.equals("^ ")) && (currentOperator.equals("-") || currentOperator.equals("+") || currentOperator.equals("("))){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEqualTo(String topOfStack){
		String currentOperator = this.stringValue;
		boolean isEqual = false;
		if((currentOperator).equals(topOfStack + " ")) {
			isEqual = true; //if it straight up matches
		} else {
			/*if currentOperator in the same hierarchy as the operator at top of the stack, isEqual is changed to true*/
			if(currentOperator.equals("+") || currentOperator.equals("-")){
				if(topOfStack.equals("+ ") || topOfStack.equals("- ")) isEqual = true;
			} else if (currentOperator.equals("*") || currentOperator.equals("/") || currentOperator.equals("^")){
				if(topOfStack.equals("* ") || topOfStack.equals("/ ") || topOfStack.equals("^ ")) isEqual = true;
			} else if(currentOperator.equals("(") && topOfStack.equals("( ")){ //compares double parenthesis
				return true;
			} 
		}
		return isEqual;
	}
	
	public boolean isGreaterThan(String topOfStack){
		if(this.isSmallerThan(topOfStack)) return false;
		else if (this.isEqualTo(topOfStack)) return false;
		else return true;
	}
	


}
