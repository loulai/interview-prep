public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;      // Number of elements in heap
    private T [] array;		  // The heap array
  

    public static void main(String [] args) throws UnderflowException {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<Integer>();
        int i = 37;
        for (i=37; i!=0; i=(i+37)%numItems)
            h.insert(i);
        for (i = 1; i < numItems; i++)
            if (h.deleteMin() != i)
                System.out.println("Oops! " + i);
	System.out.println("Done.");
    }

    public BinaryHeap() { this(DEFAULT_CAPACITY); }
    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (T[]) new Comparable[capacity+1]; // Blame erasure semantics
    }
    public BinaryHeap(T[] items) { // Construct the heap given array of items
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize+2) * 11/10];
        int i = 1;
        for (T item : items)
            array[i++] = item;
        buildHeap();
    }
    
    /* new methods */
    public int getSize(){
    	return this.currentSize;
    }
    

    public boolean isEmpty() { return currentSize == 0; }

    public void makeEmpty() { currentSize = 0; }

    public void insert(T x) {
        if (currentSize == array.length-1)
            enlargeArray(array.length*2+1);

        int hole = ++currentSize; // Percolate up
        for (; hole > 1 && x.compareTo(array[hole/2]) < 0; hole /= 2)
            array[hole] = array[hole/2];
        array[hole] = x;
    }

    public T findMin() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        return array[1];
    }

    public T deleteMin() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public static class UnderflowException extends Exception {
	public UnderflowException () { super("Underflow"); }
    }

    private void enlargeArray(int newSize) {
        T[] old = array;
        array = (T[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];        
    }
    
    private void buildHeap() { 	// runs in linear time
        for (int i = currentSize/2; i > 0; i--)
            percolateDown(i);
    }

    private void percolateDown(int hole) { // start percolating at hole
        int child;
        T tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child!=currentSize && array[child+1].compareTo(array[child])<0)
                child++; 	// smaller child
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

}
// Local Variables:
// compile-command: "javac -Xlint:unchecked BinaryHeap.java; java BinaryHeap"
// End: