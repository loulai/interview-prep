
package temp;

public class SlowMaxStack implements MaxStack<Integer> {
	private final SlowIntegerMaximizer maximizer;
	private LLNode<Integer> top = null;
	
	public static void main(String[] args){
		Maximizer x = new SlowIntegerMaximizer();
		System.out.println(x.getMax(2,3));
	}
	public SlowMaxStack(SlowIntegerMaximizer maximizer) {
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
	}

	@Override
	public void pop() {
		top = top.link;
	}

	@Override
	public Integer getMaxSoFar() {
		Integer currentMax = maximizer.getGlobalMin();
		
		for(LLNode<Integer> node = top; node != null; node = node.link) {
			currentMax = maximizer.getMax(currentMax, node.info);
		}
		return currentMax;
	}

}