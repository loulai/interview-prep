//----------------------------------------------------------------------------
// Implements Integer nodes for a Linked List.
//----------------------------------------------------------------------------

package temp;

public class LLNode<T> {
  protected T info;
  protected LLNode<T> link;
  
  public static void main(String[] args){
	  new LLNode<Integer>(2).setLink(new LLNode<Integer>(1));
	  System.out.println();
  }
 
  
  public LLNode(T info)
  {
    this.info = info;
    link = null;
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
 
  public void setLink(LLNode link)
  // Sets link of this LLStringNode.
  {
    this.link = link;
  }

  public LLNode getLink()
  // Returns link of this LLStringNode.
  {
    return link;
  }
  
  /* additional two methods from homework code */
  public LLNode(T info, LLNode<T> link) {
	  	this.info = info;
		this.link = link;
	}
	
	public LLNode<T> pushValue(T info) {
		return new LLNode<T>(info, this);
	}
	
	public void swapFirstWithLargest(){
		LLNode<Integer> currMax = (LLNode<Integer>) this;
		Integer max = currMax.info;
		LLNode<Integer> list = (LLNode<Integer>) this;
		LLNode<Integer> storeFirst = (LLNode<Integer>) this;
		
		while(list != null){
			if(list.info > max){
				currMax = list;
			}
			list = list.link;
		}
		
		Integer temp;
		temp = storeFirst.info;
		storeFirst.info = max;
		currMax.setInfo(temp);
	}
}
 
 