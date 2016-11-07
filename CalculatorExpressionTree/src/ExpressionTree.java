

import java.util.Scanner;

public class ExpressionTree {
	
	LLTreeNode<String> rootNode;
	
	public static void main(String[] args){
		
		boolean again = true;
		
		while(again){
			System.out.println("~ ~ ~ Type in prefix:");
			Scanner input = new Scanner(System.in);
			String originalInput = input.nextLine();
			Convertor convertor = new Convertor(originalInput);
			String postfixExpression = convertor.toPostFix();
			
			ExpressionTree ex = new ExpressionTree(postfixExpression);
			
			//asking for repeat or not
			System.out.println("\n\n>===< Y for again, else program will terminate >===<");
			Scanner input2 = new Scanner(System.in);
			again = false;
			if(input2.next().equalsIgnoreCase("Y")) again = true;
		}
		
	}
	
	public ExpressionTree(String postfixExpression){
		String[] arr = postfixExpression.split(" ");
		
		ArrayStack<LLTreeNode<String>> stack = new ArrayStack<LLTreeNode<String>>(); //String because never needs to be evaluated (for this assignment)
		
		for (int i = 0; i < arr.length; i++){
			if(arr[i].matches("^-?\\d+$")){ //means if it's a digit, matched my regular expressions
				stack.push(new LLTreeNode<String>(arr[i])); //makes new Node, with info as the integer (as a string)
			} else {
				LLTreeNode<String> operatorNode = new LLTreeNode<String>(arr[i]); //operator
				
				// right child
				LLTreeNode<String> rightChild = stack.top();
				stack.pop();
				operatorNode.setRightChild(rightChild);
			
				//left child
				LLTreeNode<String> leftChild = stack.top();
				stack.pop();
				operatorNode.setLeftChild(leftChild);
				
				stack.push(operatorNode);
			}
		}
		
		//set the expression 'tree'
		rootNode = stack.top();
		
		System.out.print("\n=== preorder  : ");
		preorder(rootNode);
		
		System.out.print("\n=== inorder   : ");
		inorder(rootNode);
		
		System.out.print("\n=== postorder : ");
		postorder(rootNode);
	}
	
	public static void preorder(LLTreeNode<String> tree){
		if(tree == null) return;
		System.out.print(tree.info + " ");
		preorder(tree.getLeftChild());
		preorder(tree.getRightChild());
	}
	
	public static void inorder(LLTreeNode<String> tree){
		if(tree != null){
			if(tree.getInfo().matches("^-?\\d+$")){ //leaf
				System.out.print(tree.getInfo() + " ");
			} else {
				System.out.print("( ");
				inorder(tree.getLeftChild());
				System.out.print(tree.getInfo() + " ");
				inorder(tree.getRightChild());
				System.out.print(") ");
			}
		}
	}
	
	public static void postorder(LLTreeNode<String> tree){
		if(tree == null) return;
		postorder(tree.getLeftChild());
		postorder(tree.getRightChild());
		System.out.print(tree.info + " ");
	}
	
}
