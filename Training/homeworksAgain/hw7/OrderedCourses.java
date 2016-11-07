package hw7;

public class OrderedCourses {
	
	public static void main(String[] args){
		String[] courseNames = {"Dragons", "Dying", "Nothing", "Hodor", "Cunning", "Greatness", "Dollars", "Feminism", "Fire", "Squiring"};
		String[] courseInstructor = {"Targaryen", "Stark", "Snow", "Hodor", "Bayelish", "Lannister", "Lannister", "Tarth", "Red", "Podrick"};
		int[] courseCapacity = {3000, 20,300, 60, 60, 10000, 4, 50, 40, 25};
		int[] courseNumOfStudents =  {2900, 2900, 3, 266, 30, 55, 999, 2, 45, 2, 15};
		String[] courseCode = {"A101", "B102", "C103", "D104", "E105", "F106", "G107", "H108", "I109", "J110"};
		
		Course[] listOfCourses = new Course[10];
		for(int i = 0; i < 10; i++){
			listOfCourses[i] = new Course(courseNames[i], courseInstructor[i], courseCapacity[i], courseNumOfStudents[i],courseCode[i]);
		}
		for(int i = 0; i < 10; i++) System.out.printf("%-12s| %10s %5d/%-5d (%4s)\n", listOfCourses[i].getName(), listOfCourses[i].getInstructor(), listOfCourses[i].getNumOfStudents(), listOfCourses[i].getCapacity(), listOfCourses[i].getCourseCode());
		System.out.println("=== by instructor: =================== ");
		Course[] sorted = sortByInstuctor(listOfCourses);
		for(int i = 0; i < 10; i++) System.out.printf("%-12s| %10s %5d/%-5d (%4s)\n", sorted[i].getName(), sorted[i].getInstructor(), sorted[i].getNumOfStudents(), sorted[i].getCapacity(), sorted[i].getCourseCode());
		System.out.println("=== by capacity:   =================== ");
		Course[] sortedCapacity = sortByCapacity(listOfCourses);
		for(int i = 0; i < 10; i++) System.out.printf("%-12s| %10s %5d/%-5d (%4s)\n", sortedCapacity[i].getName(), sortedCapacity[i].getInstructor(), sortedCapacity[i].getNumOfStudents(), sortedCapacity[i].getCapacity(), sortedCapacity[i].getCourseCode());
		
	}
	
	public static Course[] sortByInstuctor(Course[] listOfCourses){
		Course[] orderedCourses = new Course[listOfCourses.length];
		boolean flag = true;
		Course temp;
		while(flag){
			flag = false;
			for(int i = 0; i < listOfCourses.length - 1; i++ ){ //while loop runs until no more swaps are needed
				/*swap if instructor names are the same, but smaller capcity goes first. Else just leave it. */
				if(listOfCourses[i].getInstructor().compareToIgnoreCase(listOfCourses[i + 1].getInstructor()) == 0){ //NOTE: could refactor into one if statement, but I think its more legible here no?
					if(listOfCourses[i].getCapacity() > listOfCourses[i + 1].getCapacity()){ 
						temp = listOfCourses[i];
						listOfCourses[i] = listOfCourses[i + 1];
						listOfCourses[i + 1] = temp;
					}
				}
				if(listOfCourses[i].getInstructor().compareToIgnoreCase(listOfCourses[i + 1].getInstructor()) > 0){
					temp = listOfCourses[i];
					listOfCourses[i] = listOfCourses[i+1];
					listOfCourses[i + 1] = temp;
					flag = true;
				}
				
			}
		}
		for(int i = 0; i < listOfCourses.length; i++) orderedCourses[i] = listOfCourses[i];
		return orderedCourses;
	}
	
	public static Course[] sortByCapacity(Course[] listOfCourses){
		Course[] orderedCourses = new Course[listOfCourses.length];
		Course temp;
		boolean flag = true;
		while(flag){
			flag = false;
			for(int i = 0; i < listOfCourses.length - 1; i++){
				if(listOfCourses[i].getCapacity() > listOfCourses[i + 1].getCapacity()){
					temp = listOfCourses[i];
					listOfCourses[i] = listOfCourses[i + 1];
					listOfCourses[i + 1] = temp;
					flag = true;
				}
			}
			for(int i = 0; i <listOfCourses.length; i++) orderedCourses[i] = listOfCourses[i];
		}
		return orderedCourses;
	}

	

}
