package justPlaying;

public class FourWheel extends Car {
	
	String carName = "";

	public static void main(String[] args) {
		FourWheel SUV = new FourWheel();
		System.out.println(SUV.getHowManyCarsMade());
	}
	
	public FourWheel(String name){
		this.carName = name;
	}
}
