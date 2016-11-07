package temp;

public interface MaxStack<T> {
	boolean isEmpty();
	
	void push(T info);
	
	void pop();
	
	T getMaxSoFar();
}