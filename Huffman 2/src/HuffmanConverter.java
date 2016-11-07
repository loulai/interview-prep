import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HuffmanConverter { 
  // The # of chars in the ASCII table dictates
  // the size of the count[] & code[] arrays.
  public static final int NUMBER_OF_CHARACTERS = 256;
 
  // the contents of our message...
  private String contents;
 
  // the tree created from the msg
  private HuffmanTree huffmanTree;
 
  // tracks how often each character occurs
  private int count[];
 
  // the huffman code for each character
  private String code[];
 
  // stores the # of unique chars in contents
  private int uniqueChars = 0; //(optional)
  

  /**
   * Uses args[0] as the filename, and reads in its contents. Then
   * instantiates a HuffmanConverter object, using its methods to
   * obtain our results and print the necessary output. Finally,
   * decode the message and compare it to the input file.<p>
   * NOTE: Example method provided below...
   *
   *
   */
  public static void main(String args[]) {
	  HuffmanConverter hc = new HuffmanConverter("a 0 ( b 4 ( * 100 b 6 ) w 9 ( z 3 y 5 ( * 2 z 3 ) ) )");
	  hc.recordFrequencies();
	  hc.frequenciesToTree();
	  hc.treeToCode();
	  printBinaryTree(hc.huffmanTree.root, 0);
	  
	  String encoded = hc.encodeMessage();
	  System.out.println("\nHuffman Encoding: \n" + encoded);
	  System.out.printf("\nMessage size in ASCII encoding: %d\nMessage size in Huffman coding: %d\n\n", (hc.contents.length()*8), encoded.length());
	  String decoded = hc.decodeMessage(encoded);
	  System.out.println(decoded);
	
  }

  /** Constructor taking input String to be converted */
  public HuffmanConverter(String input) {
    this.contents = input;
    this.count = new int[NUMBER_OF_CHARACTERS];
    this.code = new String[NUMBER_OF_CHARACTERS];
  }
 
  /**
   * Records the frequencies that each character of our
   * message occurs...
   * I.e., we use 'contents' to fill up the count[] list...
   */
  public void recordFrequencies() {
	 //make char array from string
	 char[] c = this.contents.toCharArray();
	 
	 for(int i = 0; i < c.length; i++){
		 count[(int) c[i]]++; //Incrementing the count of each char, as positioned by the ASCII numbering
	 }
	
  }
 
  /**
   * Converts our frequency list into a Huffman Tree. We do this by
   * taking our count[] list of frequencies, and creating a binary
   * heap in a manner similar to how a heap was made in HuffmanTree's
   * fileToHeap method. Then, we print the heap, and make a call to
   * HuffmanTree.heapToTree() method to get our much desired
   * HuffmanTree object, which we store as huffmanTree.
   */
  public void frequenciesToTree() throws UnderflowException, UnderflowException {
	  /* formats contents into a string that looks like A~20~B~10~.. */
	  String result = "";
	  for(int i = 0; i < this.count.length; i++){
		  if(count[i] != 0){
			result += ( (char)i + "~" + count[i] + "~" );
		  }
	  }

	  /* creating a Huffman tree from the contents */
	  // splits string into array, in preparation for creating an array of huffman nodes */
	  String[] stringToArray = result.split("~");
	  System.out.println();
	  HuffmanNode[] arrayToHuffman = new HuffmanNode[stringToArray.length/2];
	  int k = 0; 
	  for(int i = 0; i < stringToArray.length ; i++){
		HuffmanNode temp = new HuffmanNode(stringToArray[i++], Double.parseDouble(stringToArray[i]));
		arrayToHuffman[k] = temp;
		System.out.printf("%2d. [%s]\n", k, arrayToHuffman[k].toString()); //used to test each huffman node is is correct and prints fine
		k++;
	  }
		
		//creates binary heap from array and assigns it
		BinaryHeap arrayToHeap = new BinaryHeap(arrayToHuffman);
		try {
			this.huffmanTree = HuffmanTree.heapToTree(arrayToHeap); 
		} catch (BinaryHeap.UnderflowException e) {
			e.printStackTrace();
		}
		System.out.println();
		this.huffmanTree.printLegend();
  }
 
  /**
   * Iterates over the huffmanTree to get the code for each letter.
   * The code for letter i gets stored as code[i]... This method
   * behaves similarly to HuffmanTree's printLegend() method...
   * Warning: Don't forget to initialize each code[i] to ""
   * BEFORE calling the recursive version of treeToCode...
   */
  public void treeToCode(){
	  for(int i = 0; i < NUMBER_OF_CHARACTERS; i++){
		  code[i] = "";
	  }
	  
	  treeToCode(huffmanTree.root, "");
  }
 
  /**
   * A private method to iterate over a HuffmanNode t using s, which
   * contains what we know of the HuffmanCode up to node t. This is
   * called by treeToCode(), and resembles the recursive printLegend
   * method in the HuffmanTree class. Note that when t is a leaf node,
   * t's letter tells us which index i to access in code[], and tells
   * us what to set code[i] to...
   */
  private void treeToCode(HuffmanNode t, String s){
	  if(t.letter.length() > 1){
		  treeToCode(t.left, s + "1");
		  treeToCode(t.right, s + "0");
	  }
	  
	  if(t.letter.length() == 1){
		  code[(int)t.letter.charAt(0)] = s; //gets char, uses it as index, stores code
	  }
	  
	  
  }
 
  /**
   * Using the message stored in contents, and the huffman conversions
   * stored in code[], we create the Huffman encoding for our message
   * (a String of 0's and 1's), and return it...
   */
  public String encodeMessage(){
	  String s = "";
	  char[] arr = contents.toCharArray();
	  for(int i = 0; i < arr.length; i++){
		  if(!code[(int)arr[i]].equals("")){
			  s += code[(int)arr[i]];
		  }
	  }
	  return s;
  }
 
  /**
   * Reads in the contents of the file named filename and returns
   * it as a String. The main method calls this method on args[0]...
   */
  public static String readContents(String filename){
		/* convert file to String */
		String text = "";
		try {
			text = new Scanner( new File(System.getProperty("user.dir") + "/" + filename)).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return text;
   }
 
  /**
   * Using the encoded String argument, and the huffman codings,
   * re-create the original message from our
   * huffman encoding and return it...
   */
  public String decodeMessage(String encodedStr) {
	  char[] c = encodedStr.toCharArray();
	  HuffmanNode current = this.huffmanTree.root;
	  String s = "";
	  for(int i = 0; i < c.length; i++){
		  if(c[i] == '1')current = current.left;
		  else current = current.right;
		  
		  if(current.right == null && current.left == null){
			  s += current.letter;
			  current = this.huffmanTree.root;
		  }
	  }
	  return s;
  }
 
  /**extra method, for some fun
	 * prints out the tree in a visual format, used when debugging
	**/
	public static void printBinaryTree(HuffmanNode root, int level){
	    if(root==null)
	         return;
	    printBinaryTree(root.right, level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("|\t");
	            System.out.println("|-------{" + root.letter + ", " + root.letter + "}");
	    }
	    else
	        System.out.println(root.letter);
	    printBinaryTree(root.left, level+1);
	}    
  

}
