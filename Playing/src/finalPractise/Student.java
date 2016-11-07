package finalPractise;

public class Student extends Person{
	
	private double GPA;

	public static void main(String[] args) {
		Student lou = new Student("Lou");
		System.out.println(lou);
	}
	
	public Student(String name){
		this.name = name;
	}
	
	public void setGPA(double newGPA){
		this.GPA = newGPA;
	}
	
	public String toString(){
		String personString = this.getClass().getSimpleName() + " " + this.getName();
		return personString;
	}

}
