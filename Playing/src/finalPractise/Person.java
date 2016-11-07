package finalPractise;

public class Person {
	
	String name;
	String email;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//why do I HAVE to this default constuctor in order for Student(String name) to work?
//	public Person(){
//		
//	}
	
	public Person(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
