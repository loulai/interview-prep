package temp;

public class TerminatesTest {

	public static void main(String[] args) {

		/* setting up linked lists */
		
		// this list can be terminated
		LLNode<Integer> a1 = new LLNode<Integer>(1);
		LLNode<Integer> a2 = new LLNode<Integer>(2);
		a2.setLink(a1);
		LLNode<Integer> a3 = new LLNode<Integer>(3);
		a3.setLink(a2);
		
		//this list can't be terminated (recursive)
		LLNode<Integer> b1 = new LLNode<Integer>(1);
		LLNode<Integer> b2 = new LLNode<Integer>(2);
		b2.setLink(b1);
		LLNode<Integer> b3 = new LLNode<Integer>(3);
		b3.setLink(b2);
		LLNode<Integer> b4 = new LLNode<Integer>(4);
		b4.setLink(b3);
//		LLNode<Integer> b5 = new LLNode<Integer>(5);
//		b5.setLink(b4);
//		LLNode<Integer> b6 = new LLNode<Integer>(6);
//		b6.setLink(b5);
		b1.setLink(b4);
		
		System.out.println("Can list 'b' be terminated? " + terminates(b4)); //testing results, if you want
		
	}
	
	/** Checks to see if the linked list stack can can be terminated, by checking the equality of references (logic explained more below)
	 * @param LLNode<T> the LLNode class type
	 * @param list      a node within the linked list
	 * @return true if the list eventually terminates, and false if the list points back at one of its
	 *  previous nodes.
	 */
	static public <T> boolean terminates(LLNode<T> list) {
		/* overarching logic: there is one 'slow' and one 'fast' reference to nodes within the linked list.
		 * The 'fast' reference is incremented (using getLink()) twice as fast as the 'slow' reference.
		 * If the 'fast' and 'slow' ever overlap, this means the list does not terminate and is recursive.
		 */
		boolean canBeTerminated = true;
		LLNode<Integer> slow = (LLNode<Integer>) list; //both start of referencing the top of the list
		LLNode<Integer> fast = (LLNode<Integer>) list;
		
		while(canBeTerminated && fast.getLink() != null && fast.getLink().getLink() != null){ //last two conditions makes sure the while loop ends if the list in question can be terminated
			System.out.printf("s: %d | f: %d\n" , slow.getInfo(), fast.getInfo()); //just for output and testing if you want
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(slow == fast)
				canBeTerminated = false;
		}
		return canBeTerminated;
	}
	
}
