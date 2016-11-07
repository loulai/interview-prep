import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HuffmanTree {
	
	HuffmanNode root;

	public static void main(String args[]) throws UnderflowException, BinaryHeap.UnderflowException, FileNotFoundException{
		BinaryHeap bheap = fileToHeap(args[0]);
		HuffmanTree htree = heapToTree(bheap);
		htree.printLegend();
	}

	public HuffmanTree(HuffmanNode huff){
		this.root = huff;
	}
	
	public static BinaryHeap fileToHeap(String filename) throws FileNotFoundException {
		/* get first line from file */
		BufferedReader buffRead = new BufferedReader(new FileReader(filename));
		String fileToString = "";
		try {
			fileToString = buffRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* splits string into array, in preparation for creating an array of huffman nodes */
		String[] stringToArray = fileToString.split(" ");
		HuffmanNode[] arrayToHuffman = new HuffmanNode[stringToArray.length/2];
		int k = 0; //counter for new array of Huffman nores
		for(int i = 0; i < stringToArray.length; i++){
			HuffmanNode temp = new HuffmanNode(stringToArray[i++], Double.parseDouble(stringToArray[i]));
			arrayToHuffman[k] = temp;
//			System.out.println(arrayToHuffman[k].toString()); //used to test each huffman node is is correct and prints fine
			k++;
		}
		BinaryHeap arrayToHeap = new BinaryHeap(arrayToHuffman);
		return arrayToHeap;
	}
	
	public void printLegend(){
		printLegend(this.root, "");
	}
	
	private void printLegend(HuffmanNode t, String s){
		if(t.letter.length() > 1){
			printLegend(t.left, s + "1");
			printLegend(t.right, s + "0");
		} 
		if (t.letter.length() == 1) {
			System.out.println(t.letter + "=" + s);
		}
	}
	
	public static HuffmanTree heapToTree(BinaryHeap b) throws UnderflowException, BinaryHeap.UnderflowException{
		HuffmanNode tempLeft = null;
		while(!b.isEmpty()){
			tempLeft = (HuffmanNode) b.deleteMin();
			if(!b.isEmpty()){
				HuffmanNode tempRight = (HuffmanNode) b.deleteMin();
				HuffmanNode newParent = new HuffmanNode(tempLeft, tempRight);
				b.insert(newParent);
			}
		}
		HuffmanTree r = new HuffmanTree(tempLeft);
		return r;
	}
	

}
