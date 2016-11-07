package hw8;

public class Matrix {
	
	private int[][] rawMatrix;
	
	public static void main(String[] args){
		Matrix myMatrix = new Matrix();
		System.out.println("========== original:");
		System.out.println(myMatrix);
		System.out.println("========== hflip:");
		System.out.println(myMatrix.hFlip());
	}
	
	private Matrix(){
		this.rawMatrix = generateMatrix(3,3);
	}
	
	private static int[][] generateMatrix(int r, int c){
		int[][] matrix = new int[r][c];
		for(int i = 0; i < r; i++){
			for(int k = 0; k < c; k++){
				matrix[i][k] = (int)((Math.random() * 21) - 10);
			}
		}
		return matrix;
	}
	
	private Matrix hFlip(){
		int[][] rawMatrix = this.rawMatrix;
		int temp;
		
		for(int r = 0; r < this.rawMatrix.length; r++){
			for(int c = 0; c < (this.rawMatrix[0].length / 2); c++){
				temp = this.rawMatrix[r][c]; //store current value in current position
				this.rawMatrix[r][c] = this.rawMatrix[r][this.rawMatrix[0].length - c - 1]; //change value in current position
				this.rawMatrix[r][this.rawMatrix[0].length - c - 1] = temp; //swapping mirror value
			}
		}
		return this;
	}
	
	public String toString(){
		String finalString = "";
		for(int r = 0; r < this.rawMatrix.length; r++){
			for(int c = 0; c < this.rawMatrix[0].length; c++){
				finalString = finalString  + String.format("%4d", this.rawMatrix[r][c]);
			}
			finalString = finalString + "\n";
		}
		return finalString;
	}
	
	
	
	
}
