package hw8matrix;

public class Matrix {
	
	private int row;
	private int column;
	private int[][] rawMatrix;
	
	public Matrix(int row, int column){
		this.row = row;
		this.column = column;
		int[][] matrix = new int[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j< column; j++) {
				matrix[i][j] = (int) (Math.random() * 21) - 10;
				}
			}
		this.rawMatrix = matrix;
	}
	
	public int getNumOfRows(){
		return row;
	}
	
	public int getNumOfColumn(){
		return column;
	}

}

/** constructor with 2 params, row column
 * - fill with random generated numbers (1-10)
 * - 1-5 inclusive
 * - if < 0, then default to one
 * - if < 5, default to 5
 * - 
 * 
 * - getNumRows, getNumColumns
 * - all matrix methods
 * - toString()
 * - add(matrix) <so this is an instance method> return boolean
 * - multiply(3) <another instance method>
 */

/** DRIVER
 * - construct > 1) with valid 2)3) row/col too small 4)5) row/col too large
 * - all of which is proven my getnumrows/columns
 * - perform all matrix transformations
 * - perform invalid addtion <expect return false>
 * - perform correct multiplication <pos,neg,zero>
 * - 
 */
