package afterFinalsTest;

public class lastQuestion {

	public static void main(String[] args) {
		char[] myChars = {1,2,'*',5,'*',4,2,9};
		moveStars(myChars);
		
	}
	
	public static char[] moveStars(char[] arr){
		int starCounter;
		ArrayList<Character> myArrLi = new ArrayList<Chhar>;
		char[] shiftedArray = new char[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == '*') starCounter++;
			else myArrLi.add(arr[i]);
		}
		
		for(int i = 0; i < starCounter; i++){
			myArrLi.add('*');
		}
		
		for(int i = 0; i < arr.length; i++){
			shiftedArray[i] = myArrLi.get(i);
		}
		
		return shiftedArray;
	}

}
