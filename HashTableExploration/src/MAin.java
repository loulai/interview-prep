import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

// http://beginnersbook.com/2013/12/hashmap-in-java-with-example/

public class MAin {

	public static void main(String[] args) {
		
		String[] a = "us".split("");
		String[] b = "sminu".split("");
		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		
		HashMap aMap = makeHashMap(a);
		HashMap bMap = makeHashMap(b);
		
		int num = 0;
		
		//num difference
		for(int i = 0; i < alphabet.length; i++){
			String w = alphabet[i];
			Integer aTally = (Integer) aMap.get(w);
			Integer bTally = (Integer) bMap.get(w);
			
			if(!aTally.equals(bTally)){
				num += Math.abs(aTally - bTally);
			}
		}

		//display using Iterator
		Set set = aMap.entrySet();
		Iterator iterator = set.iterator();
		
		while(iterator.hasNext()){
			Map.Entry mentry = (Map.Entry)iterator.next();
			System.out.print("Key: " + mentry.getKey() + " Value: ");
			System.out.println(mentry.getValue());
		}
		
		System.out.println(num);

	}
	
	public static HashMap makeHashMap(String[] arr){
		//declaration
		HashMap<String, Integer> xMap = new HashMap<String, Integer>();
		
		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		
		//making initial HashMap with all alphabets
		for(int i = 0; i < alphabet.length; i++){
			if(!xMap.containsKey(alphabet[i])){ 
				xMap.put(alphabet[i] , 0);
			}
		}
		
		for(int i = 0; i < arr.length; i++){
			xMap.put(arr[i] , (Integer) xMap.get(arr[i]) + 1);
		}
	
		return xMap;
	}

}
