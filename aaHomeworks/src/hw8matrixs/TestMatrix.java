package hw8matrixs;

public class TestMatrix {

	public static void main(String[] args) {
		 
		//valid matrix
		Matrix vanilla = new Matrix(3,3);
		System.out.println("=== Valid Matrix\n" +  vanilla);
		System.out.printf("=> %d rows %d columns\n", vanilla.getNumOfRows(), vanilla.getNumOfColumns());
		
		//too small row/column
		Matrix tooSmallRow = new Matrix(-100,3);
		System.out.println("\nRow too small? defaults to    => " + tooSmallRow.getNumOfRows());
		Matrix tooSmallColumn = new Matrix(5, 0);
		System.out.println("Column too small? defaults to => " + tooSmallColumn.getNumOfColumns());
		
		//too large row/column
		Matrix tooLargeRow = new Matrix(99, 3);
		System.out.println("\nRow too large? defaults to    => " + tooLargeRow.getNumOfRows());
		Matrix tooLargeColumn = new Matrix(5, 69);
		System.out.println("Column too large? defaults to => " + tooLargeColumn.getNumOfColumns());
	
		//horizontally flipping
		Matrix h = new Matrix(2,5);
		System.out.println("\n== Before horizontally flipped\n" + h);
		System.out.println("=> After flipped:\n" + h.horizontalFlip());
		
		//vertically flipping
		Matrix v = new Matrix(4,3);
		System.out.println("\n== Before vertically flipped\n" + v);
		System.out.println("=> After flipped:\n" + v.verticalFlip());
		
		//transposing
		Matrix transposed1 = new Matrix(3,2);
		System.out.println("\n== Before transposed 1:\n" + transposed1);
		System.out.println("=> After transposed 1:\n" + transposed1.transpose());
		
		Matrix transposed2 = new Matrix(1,1);
		System.out.println("== Before transposed 2:\n" + transposed2);
		System.out.println("=> After transposed 2:\n" + transposed2.transpose());
		
		Matrix transposed3 = new Matrix(5,5);
		System.out.println("== Before transposed 3:\n" + transposed3);
		System.out.println("=> After transposed 3:\n" + transposed3.transpose());
		
		Matrix transposed4 = new Matrix(1,5);
		System.out.println("== Before transposed 4:\n" + transposed4);
		System.out.println("=> After transposed 4:\n" + transposed4.transpose());
		
		/*adding valid and invalid matrices*/
		Matrix m1 = new Matrix(3,3);
		Matrix m2 = new Matrix(3,3);
		Matrix m3 = new Matrix(4,4);
		
		//valid addition
		System.out.println("=== valid addition, m1 + m2 ===\nm1 before add():\n" + m1);
		System.out.println("m2 before add() :\n" + m2);
		if(m1.add(m2)){ //if this 'if' statement runs, it it sufficient evidence to prove the add() method does return true or false
			System.out.println("m1 and m2 after add():\n" + m1);
			System.out.println(m2);
		}
		
		//invalid addition 
		System.out.println("=== invalid additon, m2 + m3 ===\nm2 before add():\n" + m2);
		System.out.println("m3 before add() :\n" + m3);
		if(m2.add(m3) == false){ //if this 'if' statement doesn't run, it it sufficient evidence to prove the add() method does return true or false
			System.out.println("m2 and m3 after add():\n" + m2);
			System.out.println(m3);
		}
		
		//multiplication, positive number
		Matrix m4 = new Matrix(3,3);
		System.out.println("== m4 original:\n" + m4);
		System.out.println("=> m4 * 3 (positive number):\n" + m4.multiplyBy(3));
		
		//multiplication, negative number
		Matrix m5 = new Matrix(3,3);
		System.out.println("== m5 original:\n" + m5);
		System.out.println("=> m5 * -2 (negative number):\n" + m5.multiplyBy(-2));
		
		//multiplication, zero
		Matrix m6 = new Matrix(4,4);
		System.out.println("== m6 original:\n" + m6);
		System.out.println("=> m6 * 0 (zero):\n" + m6.multiplyBy(0));
		
		//multiplication, one (should be unchanged)
		Matrix m7 = new Matrix(2,3);
		System.out.println("== m7 original:\n" + m7);
		System.out.println("=> m7 * 1:\n" + m7.multiplyBy(1));
		
		//multiplication, negative one (makes negative)
		Matrix m8 = new Matrix(5,1);
		System.out.println("== m8 original:\n" + m8);
		System.out.println("=> m8 * -1:\n" + m8.multiplyBy(-1));

	}

}
