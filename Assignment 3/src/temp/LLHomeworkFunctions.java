package temp;

public class LLHomeworkFunctions {
	
	public static void main(String[] args){
		/* testing for part 1: equalLists() */
		LinkedStack<Integer> a = new LinkedStack<Integer>();
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(2);
		
		LinkedStack<Integer> b = new LinkedStack<Integer>();
		b.push(1);
		b.push(2);
		b.push(3);
		b.push(2);
		b.push(2);
		
		System.out.println(equalLists(a, b));
	}
	
	/** Checks to see if lists are equal, in terms of both length and values
	 * @param LLNode<T> the LLNode class type
	 * @param list1     the head of the list
	 * @param list2     the head of the second list
	 * @return true      if the lists are equal. Assume both lists terminate.
	 */
	static public <T> boolean equalLists(LinkedStack<T> list1, LinkedStack<T> list2) {
		boolean isEqual = true;
		LLNode<T> head1 = list1.top;
		LLNode<T> head2 = list2.top;
		
		while(head1 != null && head2 != null){
			System.out.println("==============");
			if(head1.getInfo() != head2.getInfo()){
				isEqual = false;
				break;
			}
			System.out.printf("%d == %d\n", head1.getInfo(), head2.getInfo());
			System.out.println(isEqual);
			
			/*increment*/
			head1 = head1.getLink();
			head2 = head2.getLink();
		}
		
		if(head1 == null ^ head2 == null){ //exclusive or - if only ONE head is null, this means they must be unequal.
			isEqual = false;
		}
//		
//		if(head1 == null && head2 == null){ //equality is true. because to get to this point the list must be equal in value. This validates it it equal in length.
//		} else {
//			isEqual = false; //always, because only ONE of them is null. This means they're different sizes.
//			//if both of them were null, the above condition catches it and deals with equality comparison
//		}
		return isEqual;
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
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(slow == fast)
				canBeTerminated = false;
		}
		return canBeTerminated;
	}

}
