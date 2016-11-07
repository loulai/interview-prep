package temp;

public class FastMaxStack implements MaxStack<Integer>{

	private final FastIntegerMaximizer maximizer;
	private LLNode<Integer> top = null;
	private LLNode<Integer> maxStackTop;
	
	public FastMaxStack(FastIntegerMaximizer maximizer) {
		this.maximizer = maximizer;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void push(Integer info) {
		LLNode<Integer> newNode = new LLNode<Integer>(info);
		newNode.setLink(top);
		top = newNode;
		
		/* maxStack tracker section
		 * logic: insert in the tracker stack is the tracker stack is empty (i.e. it's the first value being pushed, ever)
		 *        or if the value being pushed is greater or equal to the current top of the max stack
		 * */
		if(maxStackTop == null || FastIntegerMaximizer.isLargerOrEqualTo(info, maxStackTop.info)){
			LLNode<Integer> newMaxNode = new LLNode<Integer>(info);
			newMaxNode.setLink(maxStackTop);
			maxStackTop = newMaxNode;
		} 
		
	}

	@Override
	public void pop() throws StackUnderflowException {
		 if (!isEmpty()){
			 if(maxStackTop.info.equals(top.info)){ //if the top of source stack equals top of maxStack
				 maxStackTop = maxStackTop.link;  //remove it from the max stack
			 }
		this.top = top.link;
		 } else {
			 throw new StackUnderflowException("Pop attempted on an empty stack.");
		 }
	
	}

	@Override
	public Integer getMaxSoFar() {
		Integer maxIntegerSoFar = null;
		if(!isEmpty())
			maxIntegerSoFar = maxStackTop.info;
		return maxIntegerSoFar;
	}

}
