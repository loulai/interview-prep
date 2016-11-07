
public class LLTreeNode<T> {
  protected T info;
  protected LLTreeNode<T> rightChild;
  protected LLTreeNode<T> leftChild;
  
  public LLTreeNode(T info)
  {
    this.info = info;
    rightChild = null;
    leftChild = null;
  }
 
  public void setInfo(T info)
  // Sets info T of this LLStringNode.
  {
    this.info = info;
  }

  public T getInfo()
  // Returns info T of this LLStringNode.
  {
    return info;
  }
 
  public void setRightChild(LLTreeNode link)
  {
	  rightChild = link;
  }
  
  public void setLeftChild(LLTreeNode link)
  {
	  leftChild = link;
  }

  public LLTreeNode getRightChild()
  {
    return rightChild;
  }
  
  public LLTreeNode getLeftChild()
  {
    return leftChild;
  }

}
 
 