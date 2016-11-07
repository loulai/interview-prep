
public class TreeNode<T> implements Comparable{
	public T element;
	public Double distance;
	public TreeNode<T> left, right;
	
	public TreeNode(T letter, Double distance){
		this.element = letter;
		this.distance = distance; //distance of this new TreeNode from parent
		this.left = null;
		this.right = null;
	}
	
	public String toString(){
		String s = "<" + element + ", " + distance + ">";
		return s;
	}
	
	@Override
	public int compareTo(Object object){
		TreeNode t = (TreeNode) object;
		return this.distance.compareTo(t.distance);
	}
	
	 public void setInfo(T element)
	  // Sets info T of this LLStringNode.
	  {
	    this.element = element;
	  }

	  public T getInfo()
	  // Returns info T of this LLStringNode.
	  {
	    return element;
	  }
	 
	  public void setRightChild(TreeNode link)
	  {
		  right = link;
	  }
	  
	  public void setLeftChild(TreeNode link)
	  {
		  left = link;
	  }

	  public TreeNode getRightChild()
	  {
	    return right;
	  }
	  
	  public TreeNode getLeftChild()
	  {
	    return left;
	  }

	
}
