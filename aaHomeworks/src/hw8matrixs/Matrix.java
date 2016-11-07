package hw8matrixs;

/** Description: This class represents a Matrix class. It takes two int parameters (row size, column size) and generates a 2D array which is interpreted as a matrix.
 *  Created on: 18th November 2014
 * @author loulai
 */
public class Matrix {
	
	public static void main(String[] args){
		Matrix myMatrix = new Matrix(2,2);
		System.out.print(myMatrix);
	}
	
	private int numOfRows;
	private int numOfColumns;
	private int[][] rawMatrix;
	
	/** Constructor that generates a matrix with rows & cols between 1-5 inclusive, else reverts to either 1 (too small) or 5 (too large)
	 * @param row     desired number of rows
	 * @param column  desired number of columns
	 */
	public Matrix(int row, int column){
	
		//the following two if statements catch when a number too large or too small is passed as an argument
		if(row <= 0) this.numOfRows = 1; //if 0 or negative, make it 1
		else if (row > 5) this.numOfRows = 5; //larger than 5? make it 5
		
		if(column <= 0) this.numOfColumns = 1; //same logic as rows
		else if (column > 5) this.numOfColumns = 5;
		
		if(row <= 5 && column <= 5 && row > 0 && column > 0){ //if all conditions are met, run the constructor
			this.numOfRows = row;
			this.numOfColumns = column;
			int[][] matrix = new int[row][column]; //generating the 2D array
			for(int i = 0; i < row; i++) {
				for(int j = 0; j< column; j++) {
					matrix[i][j] = (int) (Math.random() * 21) - 10; //populating with random numbers from -10 to 10 inclusive
					}
				}
			this.rawMatrix = matrix; //once populated, the array is assigned to the data field
		}

	}
	
	
	/** getter for number of rows
	 * @return data field of how many rows are in the matrix (i.e. how many arrays)
	 */
	public int getNumOfRows(){
		return numOfRows;
	}
	
	/** getter for number of columns
	 * @return data field of how many cols are in the matrix (i.e. how many elements within one array)
	 */
	public int getNumOfColumns(){
		return numOfColumns;
	}
	
	
	/** flips the values within the matrix horizontally
	 * @return the modified, horizontally flipped object of Matrix class
	 */
	public Matrix horizontalFlip() {
        int[][] newMatrix = new int[numOfRows][numOfColumns]; //generating a 2D array filled with zeros that is the same size as original matrix
		
		for(int i = 0; i < numOfRows; i++) { //outer runs #row times and inner runs #column times
			for(int k = 0; k < numOfColumns; k++){ //within a row, it's the last column that gets assigned a value first, because the equation (columnSize - 1 -j) is largest the first time the inner 
				newMatrix[i][numOfColumns - 1 -k] = rawMatrix[i][k];  //loop runs. e.g. [0][2], [0][1], [0][0] then outerloop runs again then it does the same thing
															     //but for the second row this time e.g. [1][2], [1][1], [1][2]
			}
		}
		rawMatrix = newMatrix; //assigning it so that the old matrix is actually changed
		return this; //returns the Matrix object
	}
	
	/** flips the values within the matrix vertically
	 * @return the modified, vertically flipped object of Matrix class
	 */
	public Matrix verticalFlip() { //logic is the same as method horizontalFlip(), except for column and rows are switched
		int[][] newMatrix = new int[numOfRows][numOfColumns];
		for(int i = 0; i < numOfColumns; i++) {
			for(int j = 0; j < numOfRows; j++){
				newMatrix[numOfRows - 1 - j][i] = rawMatrix[j][i]; 
			}
		}
		rawMatrix = newMatrix;
		return this;
	}
	/** transposes the values within the matrix, and also modifies the dimensions of the matrix
	 * @return the modified, transposed object of Matrix class. Matrix now has different dimensions; the row is swapped for cols and vie versa
	 */
	public Matrix transpose(){
		int[][] transposedMatrix = new int[numOfColumns][numOfRows]; //setting up new 2D array, with rows as columns instead and vice versa
		for(int i = 0; i< numOfRows; i++){                         //like everything else, outside loop is rows and inside is columns 
			for(int j=0; j< numOfColumns; j++){        
				transposedMatrix[j][i] = rawMatrix[i][j];         //conceptually, its like cris-cross swapping of values
													 	    //i.e. going down by column, making the column values (going down) equal the row values (going across)
			}
		}
		rawMatrix = transposedMatrix;
		/* 'resetting' the rows and columns, because those variables are still of the of old matrix dimensions
		 * temporary variable is needed as a placeholder while the swap occurs
		 */
		int temp = this.numOfRows;  
		this.numOfRows = numOfColumns;
		this.numOfColumns = temp;
		return this;
	}
	
	
	/** modifies the current Matrix to be a multiplication of an integer, taken as an argument.
	 * @param x  integer taken as the multiplication number
	 * @return   the modified, multiplied Matrix
	 */
	public Matrix multiplyBy(int x){
		for(int i = 0; i < numOfRows; i++){
			for(int k = 0; k < numOfColumns; k++){
				this.rawMatrix[i][k] = this.rawMatrix[i][k] * x; //multiplying each element with the inner array by the integer passed and replacing the old values for new
			}
		}
		return this;	
	}

	/**changes the current Matrix to the sum of itself and another matrix (if compatible). Returns true/false if 'addable' or not.
	 * @param otherMatrix Object of the Matrix class that you want to add onto a Matrix
	 * @return            Boolean value: if can be added, returns true, else if cannot be added return false
	 */
	public boolean add(Matrix otherMatrix){
		boolean addable = false; //intial value
		int[][] m1 = this.rawMatrix; //creating a new 2D array from old 2D array that we called this method on
		int[][] m2 = otherMatrix.rawMatrix; //creating another new 2D array from the Matrix we passed in as the argument (i.e. otherMatrix)
		
		/*testing to see if the #rows and #cols match, otherwise this code won't run, and because the boolean was initially set to false
		  the return will be false if the Matrices cannot be added */
		if(numOfColumns == otherMatrix.numOfColumns && numOfRows == otherMatrix.numOfRows){ 
			addable = true; //immediately set boolean to true if compatible (i.e. can be added)
			for(int i = 0; i < numOfRows; i++){
				for(int k = 0; k < numOfColumns; k++){
					m1[i][k] = m1[i][k]+ m2[i][k]; //adding the values by looking at each 'row' (i.e. array) and then adding all columns (i.e. elements within that particular array)
				}
			}
		}
		return addable;
	}

	/**overrides default toString() method
	 * @return  Formatted String representation of a Matrix
	 */
	public String toString(){
		String myString = ""; //must have a value, even if null, to be properly initialized
		for(int i = 0; i < numOfRows; i++){ //looping through #row times
			for(int k = 0; k < numOfColumns; k++){  //looping through #column times
				myString = myString + String.format("%4d ", rawMatrix[i][k]); //goes through each element of the inner array (i.e. each "column" for the row), and adds
				                                                               // it to the string
			}
		 myString = myString + "\n"; //adds line break after the end of each row's iteration, to make it look like a matrix
		}
		return myString;
	}

}



