
public class Node<T> {
	
	  protected T info;
	  protected Node<T> next;

	  
	  public Node(T info)
	  {
	    this.info = info;
	    next = null;
	  }
	 
	  public void setInfo(T info)
	  // Sets info of this Node.
	  {
	    this.info = info;
	  }

	  public T getInfo()
	  // Returns info of this Node.
	  {
	    return info;
	  }
	 
	  public void setnext(Node link)
	  {
		  next = link;
	  }
	  
	  public Node getNext()
	  {
	    return next;
	  }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
