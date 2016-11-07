package bracket;

/**
 * StackOfCharacters class provides the data structure for
 * storing characters in the last-in, first-out fashion.
 * 
 * @author     Joanna Klukowska
 * @since      Oct. 27, 2013
 * 
 */

public class StackOfCharacters {
	
	private Character[] list;
	private int size;
	private int capacity;
	
	/**
	 * Constructs an empty stack of characters with a specified capacity 
	 * (if provided capacity is less than or equal to zero, the capacity 
	 * is set to default 16).
	 * @param capacity current capacity of an array for storing characters
	 */
	public StackOfCharacters( int capacity )
	{
		//if capacity is negative or zero, reset it to 
		//default 16
		if (capacity <= 0 ) capacity = 16;
	
		//allocate the array for storing characters
		list = new Character[capacity];
		
		//set the initial values
		size = 0;
		this.capacity = capacity;	
	}
	
	/**
	 * Constructs an empty stack of characters with a default capacity of 16.
	 */
	public StackOfCharacters( )
	{
		this(16);
	}
	 
	/**
	 * Returns true if the stack is empty, otherwise it returns false.
	 */
	public boolean empty ( )
	{
		if (size == 0 )
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the number of elements in the stack.
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Returns the capacity of the stack.
	 */
	public int getCapacity()
	{
		return capacity;
	}
	
	/**
	 * Puts the character value at the top of the stack.
	 * @param value adds specified character to the stack
	 */
	public void push ( Character value )
	{
		//if the stack is full, allocate a larger array
		if (  full() )
			makeLarger();
		//add the new value to the top of the stack
		if (value != null) {
			list[size] = value;
			size++;
		}
	}
	
	/**
	 * Removes the character from the top of the stack and returns it.
	 * @return character from the top of the stack, or null if stack is empty
	 */
	public Character pop()
	{
		//if stack is empty return null reference
		if ( empty() ) return null;
		//otherwise remove and return character from the top of the stack
		else {
			size--;
			return list[size];
		}
	}
	
	
	/**
	 * Returns the character from the top of the stack (without removing it). 
	 * @return character from the top of the stack, or null if stack is empty
	 */
	public Character peek()
	{
		//if stack is empty return null reference
		if ( empty() ) return null;
		//otherwise return character from the top of the stack
		else {
			return list[size-1];
		}
	}
	
	/*
	 * Returns true if the array is at max capacity
	 */
	private boolean full()
	{
	if (size == capacity )
		return true;
	else
		return false;
	}
	
	/*
	 * Allocates an array twice the size of the current array used for 
	 * storing the stack and copies all the data to the new array.
	 */
	private void makeLarger ()
	{
		//allocate larger array
		Character [] newList = new Character [capacity * 2 ];
		//copy the data over to the new array
		for (int i = 0; i < capacity; i++)
		{
			newList[i] = list[i];
		}
		//reset list reference to the new array
		list = newList;
		//reset the capacity to the new value
		capacity = 2*capacity;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Does not work if there is nothing in the stack!
	 */
	@Override
	public String toString() {
		
		if(empty()){
			return "=== Stack Empty ===";
		}
		
		StringBuilder s = new StringBuilder();
		s.append("bottom [");
		//add all elements to the output string
		for (int i = 0; i < size-1; i++) 
			s.append(list[i]+", ");
		s.append(list[size-1]);
		s.append("] top");
		return s.toString();
	}
}







