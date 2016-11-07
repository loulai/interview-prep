
public class MyBinarySearchTree<T extends Comparable<T>>{
	
	public static void main(String[] args){
		BinarySearchTree rootOfTree = new BinarySearchTree();
		System.out.println(sum(rootOfTree))
	}
	
	public int sum(BSTIntegerNode tree){
		int sum, leftSum, rightSum;
		if(tree == null){
			sum = 0;
			return sum;
		} else{
			leftSum = sum(tree.getLeft());
			rightSum = sum(tree.getRight());
			sum = tree.getInfo() + leftSum + rightSum;
		}
		return sum;
	}

}
