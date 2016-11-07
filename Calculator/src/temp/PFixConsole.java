package temp;

//----------------------------------------------------------------------
// PFixConsole.java         by Dale/Joyce/Weems                Chapter 3
//
// Evaluates posfix expressions entered by the user.
// Uses a Console interface.
//----------------------------------------------------------------------

import java.util.Scanner;

public class PFixConsole 
{
  public static void main(String[] args)
  {
    String line = null;          // string to be evaluated
    String more = null;          // used to stop or continue processing
    int result;                  // result of evaluation

    do
    {
      // Get next expression to be processed.
      System.out.println("Enter a infix expression to be evaluated: ");
      Scanner conIn = new Scanner(System.in);
      line = conIn.nextLine();
      
      // Obtain and output result of expression evaluation.
      try
      {
        result = Calculator.evaluate(line);

        // Output result.
        System.out.println();
        System.out.println("Result = " + result);
      }
      catch (PostFixException error)
      {        
        // Output error message.
        System.out.println();
        System.out.println("Error in expression - " + error.getMessage());
      }

      // Determine if there is another expression to process.
      System.out.println();
      System.out.print("Evaluate another expression? (Y=Yes): ");
      more = conIn.nextLine();
      System.out.println();
    }
    while (more.equalsIgnoreCase("y"));

    System.out.println("Program completed.");
  }
}