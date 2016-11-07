package justPlaying;

public class Car {
	
	private int howManyCarsMade = 3;
	
	public static void main(String[] args){
		Car c = new Car();
		System.out.println(c.howManyCarsMade);
	}
	
	public int getHowManyCarsMade(){
		return howManyCarsMade;
	}
}
