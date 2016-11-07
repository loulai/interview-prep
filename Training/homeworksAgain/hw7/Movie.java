package hw7;

public class Movie {
	
	public static void main(String[] args){
		Movie daMovie = new Movie("Da Movie", 1.4, 2009);
		System.out.println(daMovie.getTitle());
	}
	
	private String title;
	private double duration;
	private int releaseYear;
	private float rating;
	
	public Movie(String title, double duration, int releaseYear){
		this.title = title;
		this.duration = duration;
		this.releaseYear = releaseYear;
		this.rating = 0;
	}
	
	private String getTitle(){
		return this.title;
	}
	
	private void setTitle(String newTitle){
		this.title = newTitle;
	}
	
	private double getDuration(){
		return this.duration;
	}
	
	private void setDuration(double newDuration){
		this.duration = newDuration;
	}
	
	private int getReleaseYear(){
		return this.releaseYear;
	}
	
	private void setReleaseYear(int newReleaseYear){
		this.releaseYear = newReleaseYear;
	}
	
	private float getRating(){
		return this.rating;
	}
	
	private void setRating(float newRating){
		this.rating = newRating;
	}

}
