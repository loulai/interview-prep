package hw6;

public class Matrix {
	
	public static void main(String[] args){
		int[][] myMatrix = {{-1}};
		printMatrix(myMatrix);
		System.out.println("=========== Horizontal flip:");
		printMatrix(horizontalFlip(myMatrix));
		System.out.println("=========== Vertical flip:");
		printMatrix(verticalFlip(myMatrix));
		System.out.println("=========== Transpose:");
		printMatrix(transpose(myMatrix));
		System.out.println("=========== Row Max:");
		printArray(findRowMax(myMatrix), "by row");
		System.out.println("=========== Column Sum:");
		printArray(sumColumns(myMatrix), "by column");
		
		
	}

 	public static void printArray(int[] nums, String display){
 		if(display.equalsIgnoreCase("by column"))  for(int i = 0; i < nums.length; i++) System.out.printf("[%3d  ]", nums[i]);
 		else if(display.equalsIgnoreCase("by row")) for(int i = 0; i < nums.length; i++) System.out.printf("[%3d  ]\n", nums[i]);
	}
	public static void printMatrix(int[][] matrix){
		for(int r = 0; r < matrix.length; r++){ //run #row times
			for(int c = 0; c < matrix[0].length; c++){ //run #column times
				System.out.printf("[%3d  ]",matrix[r][c]);
			}
		System.out.println();
		}
	}
	
	public static int[][] horizontalFlip(int[][] matrix){
		int[][] hFlipped = new int[matrix.length][matrix[0].length];
		
		for(int r = 0; r < matrix.length; r++){ //run #row times
			for(int c = 0; c < matrix[0].length; c++){ //run #column times
				hFlipped[r][c] = matrix[r][matrix[0].length - c - 1]; //e.g. if each 'row' has 5 columns, for first row and col, hflipped[0][0] gets matrix[0][5 - 0 - 1]
			}
		}
		return hFlipped;
	}
	
	public static int[][] verticalFlip(int[][] matrix){
		int[][] vFlipped = new int[matrix.length][matrix[0].length];
		for(int c = 0; c < matrix[0].length; c++){
			for(int r = 0; r < matrix.length; r++){ //because 'row' is the one changing #row times, and column stays the same. Jumping down rows. 
				vFlipped[r][c] = matrix[matrix.length - r - 1][c];
			}
		}
		return vFlipped;
	}
	
	public static int[][] transpose(int[][] matrix){
		int[][] transposed = new int[matrix[0].length][matrix.length];
		/* chosen to fill the new matrix column by column (going down)*/
		for(int c = 0; c < transposed.length; c++){ //run #columns of the NEW matrix (which is the #rows of old matrix, which is why it works)
			for(int r = 0; r < transposed[0].length; r++){
				transposed[c][r] = matrix[r][c];   //the slots to be changed is affected by the row change. The values are filled 'going down' the NEW array, collected
				                                   //by 'going across' the OLD array
			}
		}
		return transposed;
	}
	
	public static int[] findRowMax(int[][] matrix){
		int[] rowMaxes = new int[matrix.length]; //new array, size of the #rows in matrix
		int largest;
		for(int r = 0; r < matrix.length; r++){
			largest = matrix[r][0]; //largest gets the first value in each row. Reset when moves on to new row
			rowMaxes[r] = largest; //Here for the case when there no value in that row > first value (so if block code never runs)
			for(int c = 0; c < matrix[0].length; c++){
				if(matrix[r][c] > largest) {
					largest = matrix[r][c];
					rowMaxes[r] = largest; //rowMaxes works with sub[r] (usually sub[i]), because r is basically the index.. think about it
				}
			}
		}
		return rowMaxes;
	}
	
	public static int[] sumColumns(int[][] matrix){
		int[] columnSums = new int[matrix[0].length];
		int sum;
		for(int c = 0; c < matrix[0].length; c++){
			sum = 0;
			for(int r = 0; r < matrix.length; r++){
				sum = sum + matrix[r][c];
			}
			columnSums[c] = sum;
		}
		return columnSums;
	}
	
	

}
