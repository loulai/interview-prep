package temp;
import java.util.Scanner;

public class Convertor {

	String infix;
	String postfix;
	
	public Convertor(String expression){
		String[] SArray = expression.split("(?<=[-+*/()^])|(?=[-+*/()^])");
		infix = SArray[0] + " ";
		for(int i = 1; i < SArray.length - 1; i++){
			infix = infix + SArray[i] + " ";
		}
		infix = infix + SArray[SArray.length - 1];
		System.out.println(infix);
		this.postfix = this.toPostFix();
	}
	
	public String toPostFix(){
		Scanner tokenizer = new Scanner(infix);
		String output = "";
		ArrayStack<String> stack = new ArrayStack<String>();
		String temp;
		
		while(tokenizer.hasNext()) {
			if(tokenizer.hasNextInt()){
				output = output + tokenizer.nextInt() + " ";
			tokenizer.h
			} else {
				Operator operator = new Operator(tokenizer.next()); //initialize a new instance of Operator, which has various methods for comparison
				if(operator.stringValue.equals(")")) { //if its the closing bracket, pop everything until the closing bracket (then remove it from the stack)
					while(!stack.top().equals("( ")){
						output = output + stack.top();
						stack.pop();
					}
					stack.pop();
				} else if (stack.isEmpty() || stack.top().equals("( ") || operator.isGreaterThan(stack.top()) || operator.stringValue.equals("(")){ //if the stack is empty OR operator at the top of stack is ( OR the current operator is greater than the top of the stack..
					stack.push(operator.stringValue + " "); //..push the current operator into stack
				} else if (operator.isSmallerThan(stack.top()) || operator.isEqualTo(stack.top())){ //if operator is LARGER or EQUAL to the top of the stack
					while(!stack.isEmpty() && (operator.isSmallerThan(stack.top()) || operator.isEqualTo(stack.top()))){ //copy to output and continue popping out of stack until the stack top is smaller than the current operator
						output = output + stack.top(); //put the top of the stack into output
						stack.pop(); //pop the top of the stack out
					}
					stack.push(operator.stringValue + " "); //then push the current operator into stack
				} 
			} 
		}
		
		while(!stack.isEmpty()){
			output = output + stack.top();
			stack.pop();
		}
		return output;
		
	}

}
