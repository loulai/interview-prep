import java.util.Scanner;

/**
 *Created on : October 21st 2014
 *Description: Program creates a matrix (i.e. a 2D array) with row and column size specifications from the user, then applies transformations to the
 *             matrix according to what the user chooses from the given menu.
 *@author Lou Lai
 */

public class Matrix{

	public static void main(String[] args) {
		
		System.out.println("Size of your matrix? (row by column): ");
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		
		//checking for all conditions: rows && columns can only be between 1 and 5 inclusive
		if(row == 0 || column == 0){
			System.out.println("<---You trolling? How am I meant to give you a matrix with 0 rows or columns. Try again.--->");
		} else if (row < 1 || column < 1){
			System.out.println("<---Getting sassy eh? Have you ever heard of negative rows or columns? Didn't think so. Try again.--->");
		} else if(row > 5 || column > 5){
			System.out.println("<---Whoa that's too big! Row and column can only go up to 5. Try again.--->");
		} else { //at this point, code only runs if all conditions of matrix size are met
			int[][] myMatrix = generateMatrix(row, column); //generates a matrix
			printMatrix(myMatrix); //prints matrix
			boolean again = true;  //used for the while loop for menu selection below
			
			/* menu selection part begins */
			while(again){
			System.out.println("\n=========  MENU  =========");
			System.out.println("---(H) horizontal flip---");
			System.out.println("---(V) vertical flip ----");
			System.out.println("---(T) transpose --------");
			System.out.println("---(R) row maximum ------");
			System.out.println("---(C) column sum -------");
			System.out.println("---(P) print original ---");
			System.out.println("---(Q) quit -------------");
			System.out.println("==========================");
			
			Scanner menuInput = new Scanner(System.in);
			String choice = menuInput.next().toUpperCase();
				
				//calling the corresponding method for each case of user input
				switch(choice){
				case "Q": System.out.println("\n====May the force be with you====");
						  again = false;
						  break;
				case "H": printMatrix(horizontalFlip(myMatrix));
					      break;
				case "V": printMatrix(verticalFlip(myMatrix));
						  break;
				case "T": printMatrix(transpose(myMatrix));
				          break;
				case "R": printArray(rowMax(myMatrix));
				          break;
				case "C": printArray(columnSum(myMatrix));
		                  break;
				case "P": printMatrix(myMatrix);
	                      break;   
	            default: System.out.println("<---Invalid choice. Choose wisely young elf. Here's the menu again.--->");
	            	     break;
				} 
			}
			/* menu selection part ends */
		}
	
	}
	
	/**generates a two dimensional array from the user input of the size of row(s) and column(s)
	 * @param row    integer number of desired rows specified in the matrix
	 * @param column integer number of desired columns specified in the matrix
	 * @return       a two dimensional integer array which is the size of the specified rows and columns
	 */
	public static int[][] generateMatrix(int row, int column) {
		int[][] matrix = new int[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j< column; j++) {
				matrix[i][j] = (int) (Math.random() * 21) - 10; // first generates numbers 0 to 20, then subtracts by 10 to get range of -10 to 10
				}
			}
		return matrix;
	}
	
	/** prints out a two-dimensional array, formatted to look like a matrix
	 * @param matrix   a two-dimensional array (the matrix)
	 */
	public static void printMatrix(int[][] matrix){
		int rowSize = matrix.length;       //counts the number of rows
		int columnSize = matrix[0].length; //counts number of columns
		for(int i = 0; i < rowSize; i++) { //outer loop runs #rowSize times
			for(int j = 0; j< columnSize; j++) { //inner loop runs #columnSize times
				System.out.printf("%4d", matrix[i][j]); 
				}
			System.out.println(); //added line break at the end of each row
			}
		}
	
	/** prints out a one-dimensional array, needed for rowMax() and columnSum() methods
	 * @param maxes   a two-dimensional array (the matrix)
	 */
	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.printf("%4d", array[i]);
		}
	}
	
	/** takes a matrix and returns a new matrix whose rows are created by reversing each row of the original matrix, without modifying it
	 * @param matrix a two-dimensional array (the matrix)
	 * @return       the two-dimensional array that has been flipped horizontally
	 */
	public static int[][] horizontalFlip(int[][] matrix) {
		int columnSize = matrix[0].length;         //the number of columns, (i.e the number of elements in the inner array)
		int[][] newMatrix = new int[matrix.length][columnSize]; //generating a two dimensional array filled with zeros that is the same size as original matrix
		for(int i = 0; i < matrix.length; i++) { //outer runs #row times and inner runs #column times
			for(int j = 0; j < columnSize; j++){ //within a row, it's the last column that gets assigned a value first, because the equation (columnSize - 1 -j) is largest the first time the inner 
				newMatrix[i][columnSize - 1 -j] = matrix[i][j];  //loop runs. e.g. [0][2], [0][1], [0][0] then outerloop runs again then it does the same thing
															     //but for the second row this time e.g. [1][2], [1][1], [1][2]
			}
		}
		return newMatrix; //returns new matrix filled with horiontally flipped array
	}
	
	/** takes a matrix and returns a new matrix whose rows are created by reversing each column of the original matrix, without modifying it
	 * @param matrix a two-dimensional array (the matrix)
	 * @return       the two-dimensional array that has been flipped vertically
	 */
	public static int[][] verticalFlip(int[][] matrix) { //logic is the same as method horizontalFlip(), except for column and rows are switched
		int rowSize = matrix.length;
		int[][] newMatrix = new int[rowSize][matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = 0; j < rowSize; j++){
				newMatrix[rowSize - 1 - j][i] = matrix[j][i]; //note that the assignment is [j][i], instead of the usual [i][j] because we're flipping columns not rows
			}
		}
		return newMatrix;
	}
	
	/**takes a matrix and returns a new matrix whose columns are the rows (and vice versa) of the original matrix, without modification
	 * @param matrix a two-dimensional array (the matrix)
	 * @return       a two-dimensional array that has been transposed
	 */
	public static int[][] transpose(int[][] matrix){
		int[][] transposedMatrix = new int[matrix[0].length][matrix.length]; //setting up new 2D array, with rows as columns instead and vice versa
		for(int i = 0; i< matrix.length; i++){                         //like everything else, outside loop is rows and inside is columns 
			for(int j=0; j< matrix[0].length; j++){        
				transposedMatrix[j][i] = matrix[i][j];         //conceptually, its like cris-cross swapping of values
													 	 //i.e. going down by column, making the column values (going down) equal the row values (going across)
			}
		}
		return transposedMatrix;
	}
	
	/** returns an array of numbers such that the value at index i is the largest element of the i'th row in the passed matrix
	 * @param matrix  a two-dimensional array (the matrix)
	 * @return		  a one-dimensional array that contains each row's maximum number
	 */
	public static int[] rowMax(int[][] matrix) {
		int[] arrayOfMaxes = new int[matrix.length]; //creates a 1D array the size of the number of rows in the matrix
		int max = matrix[0][0];                      //assigns the max to the first element in the first row & column
		for(int i = 0; i < matrix.length; i++) {       //runs for #row times
			for(int j = 0; j < matrix[0].length; j++){ //runs #column times
				if(matrix[i][j] > max){                //compares each number with max
					max = matrix[i][j];		           //if the number is smaller, it takes the places of max
					arrayOfMaxes[i] = max;             //slotting in the determined max of the row into the arrayOfMaxes
				} else{
					arrayOfMaxes[i] = max;
				}
			}  
			max = matrix[i][0];                      //resetting max to the first number of the row (i.e. for each outer loop)
		}
		return arrayOfMaxes;
	}
	
	/** returns an array of numbers such that the value at index i is the sum of all elements of the i'th column of the passed matrix
	 * @param matrix   a two-dimensional array (the matrix)
	 * @return         a two-dimensional array that contains the sum of each individual column
	 */
	public static int[] columnSum(int[][] matrix) { 
		int[]arrayOfSums= new int[matrix[0].length]; //creates a 1D array the size of #column in the matrix
		
		/* idea is that the loop will look at each column and go 'down' (i.e. counter for rows change while column stays the same),
		 * which explains why the loop runs #column times first and not #row times like the other methods*/
		for(int i = 0; i < matrix[0].length; i++){     //runs #column times
			int sum = 0;                               //sets the initial sum of each column to 0 at the beginning of each column (i.e. for each outer loop)
			for(int j = 0; j < matrix.length; j++){     //runs #row times
				sum = sum + matrix[j][i];               //sums the numbers that are positioned in the same column
				arrayOfSums[i] = sum;                   //slots the end sum into the array of sums
			}
		}
		return arrayOfSums;
	}
	
}

