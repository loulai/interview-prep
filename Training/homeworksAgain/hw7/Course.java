package hw7; 	
/**
 * This class represent a university course. 
 *  
 * @author Joanna Klukowska
 *
 */
public class Course {

	
	private String name;
	private String instructor;
	private int capacity;
	private int numOfStudents;
	private String courseCode;
	
	
	/**
	 * Create a default course. The capacity is set to 50, number of students 
	 * is set to 0, the course code is set to "0000", the title of the course 
	 * is set to "Course Title" and the instructor is set to TBD.
	 */
	public Course() {
		this("Course Title", "TBD", 50, 0, "0000");
	}
	
	public Course(String name, int capacity, String courseCode) {
		this(name, "TBD", capacity, 0, courseCode);
	}
	
	public Course(String name, String instructor, int capacity, 
			String courseCode) {
		this(name, instructor, capacity, 0, courseCode);
	}
	public Course(String name, int capacity, int numOfStudents, 
			String courseCode) {
		this(name, "TBD", capacity, numOfStudents, courseCode);
	}
	public Course(String name, String instructor, int capacity,
			int numOfStudents, String courseCode) {
		this.name = name;
		this.instructor = instructor;
		this.capacity = capacity;
		this.numOfStudents = numOfStudents;
		this.courseCode = courseCode;
	}
	/**
	 * Returns the name of this course object.
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Modifies the name of this object. 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the instructor of this course object.
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * Modifies the instructor of this object. 
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/**
	 * Returns the capacity in this course object.
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * Modifies the capacity of this object. 
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * Returns the number of students in this course object.
	 * @return the numOfStudents
	 */
	public int getNumOfStudents() {
		return numOfStudents;
	}
	/**
	 * Modifies the number of students in this object. 
	 * @param numOfStudents the numOfStudents to set
	 */
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}
	/**
	 * Returns the course code of this course object.
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * Modifies the course code of this object. 
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Returns the string representation of the object. 
	 * @return the string representation of the object 
	 */
	@Override
	public String toString() {
		return String.format("%-25s %-15s %5d/%-5d", 
				name+" ["+courseCode+"]", instructor, numOfStudents, capacity);
	}
}
