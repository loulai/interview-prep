import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AssignmentMain {

	public static void main(String[] args) throws BinaryHeap.UnderflowException {
		TreeNode root = stringInputToTree("a 0 ( b 4 ( * 100 b 6 ) w 9 ( z 3 y 5 ( * 2 z 3 ) ) )"); //readContents returns a String, which is converted into a TreeNode and the root is returned
		printBinaryTree(root, 0); //optional, remove if needed, will not affect code. Just illustrating tree visually.
		try {
			System.out.println("\nFound \"*\" at distance: " + findClosest(root, "*"));
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
	}
	
	public static Double findClosest(TreeNode root, Object target) throws BinaryHeap.UnderflowException {
	    	BinaryHeap<TreeNode<String>> minheap = new BinaryHeap<TreeNode<String>>();
	    	minheap.insert(root);
	    	TreeNode<String> t;
	  
	    	while(!minheap.isEmpty()){
	    		t = minheap.deleteMin();
	    		
	            if(t != null && !t.element.equals(target)){
	    			if(t.left!=null){
	    				t.left.distance += t.distance;
	    				minheap.insert(t.left);
	    			}
	    			if(t.right!=null){
	    				t.right.distance += t.distance;
	    				minheap.insert(t.right);
	    			}
		    	} else if(t.element.equals(target)) {
		    		return t.distance;
		    	}
	            //this if loop ends if the element is not found. If the element was found, with min value, then it would've been returned
	    	}
	    return -1.0;
	  }

	public static TreeNode stringInputToTree(String stringInput) {
		 ArrayStack<TreeNode> stack = new ArrayStack<TreeNode>();
		 Scanner tokenizer = new Scanner(stringInput);
		 while(tokenizer.hasNext()){
			 if(tokenizer.hasNext("[^()]")){ //if is is anything other than "(" or ")"
				 TreeNode<String> treeNode = new TreeNode<String>(tokenizer.next(), tokenizer.nextDouble());
				 stack.push(treeNode);
			 } else if (tokenizer.hasNext("[(]")){
				 tokenizer.next();
			 } else {
				 tokenizer.next();
				 TreeNode rightChild = stack.top();
				 stack.pop();
				 
				 TreeNode leftChild = stack.top();
				 stack.pop();
				 stack.top().setRightChild(rightChild);
				 stack.top().setLeftChild(leftChild);
			 }
		 }
		 return stack.top();
	}

	/**extra method, for some fun
	 * prints out the tree in a visual format, used when debugging
	**/
	public static void printBinaryTree(TreeNode root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------{" + root.element + ", " + root.distance + "}");
	    }
	    else
	        System.out.println(root.element);
	    printBinaryTree(root.left, level+1);
	}    

	/**
	   * Reads in the contents of the file named filename and returns
	   * it as a String. The main method calls this method on args[0]...
	   */
	  public static String readContents(String filename){
			/* convert file to String */
			String text = "";
			try {
				text = new Scanner( new File(System.getProperty("user.dir") + "/" + filename)).useDelimiter("\\A").next();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return text;
	   }
}
