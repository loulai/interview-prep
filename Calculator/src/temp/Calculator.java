package temp;

import java.util.Scanner;
import java.math.*;

public class Calculator {
	
	static String postFixExpression;      // string to be evaluated
	static String more = null;           // used to stop or continue processing
    int result;                         // result of evaluation

	public static void main(String[] args) {
		do {
		System.out.println("Enter infix expression to be evaluated: ");
		Scanner input = new Scanner(System.in);
		String infixExpression = input.nextLine();
		postFixExpression = new Convertor(infixExpression).postfix;
		
			try {
			int result = Calculator.evaluate(postFixExpression);
			System.out.println("=======================");
		    System.out.println("Result: " + result);
			System.out.println("=======================");
		    
			} catch (PostFixException error) {        
		        // Output error message.
		        System.out.println();
		        System.out.println("Error in expression - " + error.getMessage());
		    }
			
		      // Determine if there is another expression to process.
		      System.out.println();
		      System.out.print("Evaluate another expression? (Y=Yes): ");
		      more = input.nextLine();
		      System.out.println();
		    }
		
		while (more.equalsIgnoreCase("y"));
	
		System.out.println("Program completed.");
		}
	
	public static int evaluate(String expression)
	  {
	    BoundedStackInterface<Integer> stack = new ArrayStack<Integer>(50);  
	    
	    int value;
	    String operator;

	    int operand1;
	    int operand2;

	    int result = 0;

	    Scanner tokenizer = new Scanner(expression);

	    while (tokenizer.hasNext())
	    {
	      if (tokenizer.hasNextInt())
	      {
	        // Process operand.
	        value = tokenizer.nextInt();
	        if (stack.isFull())
	          throw new PostFixException("Too many operands - stack overflow");
	        stack.push(value);
	      }
	      else
	      {
	        // Process operator.
	        operator = tokenizer.next();
	        
	        // Obtain second operand from stack.
	        if (stack.isEmpty())
	          throw new PostFixException("Not enough operands - stack underflow");
	        operand2 = stack.top();
	        stack.pop();

	        // Obtain first operand from stack.
	        if (stack.isEmpty())
	          throw new PostFixException("Not enough operands - stack underflow");
	        operand1 = stack.top();
	        stack.pop();
	        
	        if (operand2 == 0 && operator.equals("/")) 
	          	 throw new PostFixException("=== YOU SHALL NOT PASS. Cannot divide by zero you troll === ");

	        // Perform operation.
	        if (operator.equals("/"))
	          result = operand1 / operand2;
	        else
	        if(operator.equals("*"))
	          result = operand1 * operand2;
	        else
	        if(operator.equals("+"))
	          result = operand1 + operand2;
	        else
	        if(operator.equals("-"))
	          result = operand1 - operand2;
	        else 
	        if(operator.equals("^"))
		      result = (int) Math.pow(operand1, operand2);
	        else
	          throw new PostFixException("Illegal symbol: " + operator);

	        // Push result of operation onto stack.
	        stack.push(result);
	      }
	    }

	    // Obtain final result from stack. 
	    if (stack.isEmpty())
	      throw new PostFixException("Not enough operands - stack underflow");
	    result = stack.top();
	    stack.pop();

	    // Stack should now be empty.
	    if (!stack.isEmpty())
	      throw new PostFixException("Too many operands - operands left over");

	    // Return the final.
	    return result;
	  }
}
