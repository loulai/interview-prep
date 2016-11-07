package FinalQuestion11;

public class CalendarDate implements Comparable {
	
	public Static void main(String[] main){
		System.out.println(Math.max(1,2));
	}

	private int day;
	private int month;
	public static void main(String[] args) {
		CalendarDate cd1 = new CalendarDate();
		CalendarDate cd2 = new CalendarDate();
		System.out.println(cd1.compareTo(cd2));
	}
	
	public CalendarDate(){
		this.day = (int)(Math.random() * 31) + 1;
		this.month = 5;
	}
	
	@Override
	public int compareTo(Object obj){
		CalendarDate c = (CalendarDate) obj;
		if(this.month >= c.month && this.day > c.day ){
			return 1;
		} else if (this.month == c.month && this.day == c.day){
			return 0;
		} else return -1;
	}
	



}
