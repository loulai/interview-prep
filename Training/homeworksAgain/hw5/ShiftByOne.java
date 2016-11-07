package hw5;

public class ShiftByOne {

	public static void main(String[] args){
		String s = "table";
		// 0 1 2 3 4
		// c r a b s
		// c c a b s (r)  >shift1 result
		// c c r b s (a)  >shift2 result
		// c c r a s (b)  >shift3 result
		// c c r a b (s)  >shift4 result
		// s c r a b (c?)
	
		/* temp is the one that replaces stuff, and the store is the storage variable, which 
		 * makes sure things are 'saved' before they get swapped and is the one used for the upcoming swap*/
		char[] chars = s.toCharArray();
		char store;
		char temp;
		
		store = chars[1];  //store r
		chars[1] = chars[0]; // change r into c
		System.out.printf("==   first shift: %s, (%s)\n", new String(chars), store);
		
		//shift2
		temp = store;  //make sure the correct char is saved before we overwrite store (temp gets r)
		store = chars[2]; //overwrite store (store gets a)
		chars[2] = temp; //change a into r (3rd pos gets r)
		System.out.printf("==  second shift: %s, (%s)\n", new String(chars), store);
		
		//shift3
		temp = store;
		store = chars[3];
		chars[3] = temp;
		System.out.printf("==   third shift: %s, (%s)\n", new String(chars), store);
		
		//shift4
		temp = store;
		store = chars[4];
		chars[4] = temp;
		System.out.printf("==  fourth shift: %s, (%s)\n", new String(chars), store);
		
		//shiftLast
		chars[0] = store; //it doesn't matter if nothing is 'saved' for the upcoming swaps
		System.out.printf("==    last shift: %s, (%s)\n", new String(chars), store);
		
		System.out.println("==== SHIFTED STRING: " + new String(chars) + " ====");
	}

}
