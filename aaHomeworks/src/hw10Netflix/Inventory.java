package hw10Netflix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/** This class represents the current inventory of a movie distribution center. Each Inventory object has a private ArrayList<Movie> variable. (Submitted without extra credit yet)
 * created on: December 8th 2014
 * @author loulai
 */
public class Inventory {

	private ArrayList<Movie> list = new ArrayList<Movie>(); //each array has a private variable list
	
	public static void main(String[] args) {
		Inventory movieList = new Inventory(); //initializing new inventory
		
		/*
		 * Begin section: reading text file and populating movieList
		 */
		java.io.File moviesDB = new java.io.File("/Users/louiselai/Desktop/Programming/workspace/aaHomeworks/bin/hw10Netflix/movies_db.txt"); //fetching the correct file
		
		try{ //surrounding the entire thing for the input potentially not existing, because of the file not existing
			Scanner input = new Scanner(moviesDB);  //new scanner object using text file 
			for(int i = 0; i < 16; i++){ //16 movies in the text file
				try { //for the year/rating potential errors.
					
					String movieDetails = input.nextLine(); //capturing one whole line in the text file as a String
					String movieTitle = movieDetails.split(" - ")[0]; //using REGEX, splitting the string where " - " is present. 
					                                                  //Returns an array, so the first one is always the title
					int movieYear = Integer.parseInt(movieDetails.split(" - ")[1]); //splitting and storing, this time the movie year. 
					                                                            //Parsing as int, because is will be a String otherwise
					
					double movieRating = Double.parseDouble(movieDetails.split(" - ")[3]); //same, except parsing as double. Skipped duration ([2]) because its not needed
					movieList.list.add(new Movie(movieTitle, movieYear, movieRating)); //finally, creating the new Movie object after all the relevant fields are extracted from the text file
				} catch (IllegalArgumentException e) { //handling possible exceptions from setting the year/rating
					System.out.println("found an exception from the text file");
				} 
			} 
		} catch (FileNotFoundException e1) {
			System.out.println("==whoops, file not found==");
		}
		/*
		 * End section: reading text file and populating movieList
		 * Begin section: adding and renting movies
		 */
		
		System.out.println("{TESTING ADDMOVIE METHOD}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{TESTING ADDMOVIE METHOD}");
		movieList.addMovie("Bears", 2014, 3.5);
		movieList.addMovie("Star Wars - A New Hope", 1997, 3.8);
		movieList.addMovie("Casablanca", 1942, 3.9); //already exists in text file, so increases quantity
		movieList.addMovie("Duck Soup", 1933, 3.75); //already exists in text file, so increases quantity
		System.out.println(movieList);
		
		movieList.addMovie("Casablanca", 1942, 3.9); //testing quantity increment, which is now 3
		movieList.addMovie("Bears", 2050, 2.0); //testing invalid year input. Notice quantity did not increase.
		System.out.println(movieList);
		
		System.out.println("{TESTING RENTMOVIE METHOD}>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>{TESTING RENTMOVIE METHOD}");
		movieList.rentMovie("The Nightmare Before Christmas", 1993); //does nothing because the movie doesn't exist
		System.out.println(movieList);
		
		movieList.rentMovie("Duck Soup", 1933); //count decreases (from 2 to 1) but remains in inventory
		System.out.println(movieList);

	}
	
	
	/** Adds a movie with the given title, year and rating, unless that movie already exists. If it already exists, 
	 * simply increment the quantity of the Movie object and reset the rating. 
	 * @param otherTitle  String  title of movie to be added
	 * @param otherYear   int     year of movie to be added
	 * @param otherRating double rating of movie to be added
	 */
	public void addMovie(String otherTitle, int otherYear, double otherRating) { 
		try{
			/* loop #1 tests each movie to see if it matches. if it does, then the quantity is incremented */
			for(int i = 0; i < this.list.size(); i++){ 
					if(this.list.get(i).getTitle().equalsIgnoreCase(otherTitle) && this.list.get(i).getYear() == otherYear){ //match the title and year
						Movie matchingMovie = this.list.get(i); //fetching the movie that already exists
						matchingMovie.increaseQuantity();       //incrementing quantity and resetting rating (if the value is legit)
						matchingMovie.setRating(otherRating);
						return; //stops method once a match is found
					}
			}
			
			//Method will only progress to this point if there is NO match
			/* loop #2 tests each movie to see if it DOESNT match. If it doesn't, it adds the movie.  */
			for(int i = 0; i < this.list.size(); i++){
				if (!this.list.get(i).getTitle().equalsIgnoreCase(otherTitle) || this.list.get(i).getYear() != otherYear){
					this.list.add(new Movie(otherTitle, otherYear, otherRating));
					return; 
				}
			}
		} catch(IllegalArgumentException e){} //handling exceptions from rate/year
	}

	/** 'Rents' a movie from the inventory's list of movies by removing it, unless there are more than one copies of it
	 * that exist. If more than one exist, the quantity decreases by one.
	 * @param otherTitle String title of the movie to be rented
	 * @param otherYear  int    year of the movie to be rented
	 */
	public void rentMovie(String otherTitle, int otherYear){ 
		try{
			/* loop #1 tests each movie to see if it matches, and there is more than 1 copy of it. if it does, then the quantity is decreased */
			for(int i = 0; i < this.list.size(); i++){ 
					if(this.list.get(i).getTitle().equalsIgnoreCase(otherTitle) && this.list.get(i).getYear() == otherYear && this.list.get(i).getQuantity() > 1){ //match the title and year
						Movie matchingMovie = this.list.get(i); //fetching the movie that already exists
						matchingMovie.decreaseQuantity();       //decrementing quantity and resetting rating (if the value is legit)
						return; //stops method once a match is found
					}
			}
			
			//only at this point if the there were no matches with a quantity greater than 1
			/* loop #1 tests each movie to see if it matches, and if the matched movie has a quantity equal to one. If it matches and there is only one copy, remove it from list  */
			for(int i = 0; i < this.list.size(); i++){
				if (this.list.get(i).getTitle().equalsIgnoreCase(otherTitle) && this.list.get(i).getYear() == otherYear && this.list.get(i).getQuantity() == 1){
					//if movie exists in inventory BUT there is only ONE of it, remove it from the arrayList
					Movie matchingMovie = this.list.get(i);
					this.list.remove(matchingMovie);
				}
			}
		} catch(IllegalArgumentException e){} //handling exceptions from rate/year
	}
	
	/* Creates a formatted string of the movieList's list
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String finalString = "==================== LOOK AT ALL THE MOVIES I HAVE NO TIME TO WATCH ==========================\n";
		for(int i = 0; i < this.list.size(); i ++){
			finalString = finalString + String.format("%3d. %-40s (%-4d), rating: %2.1f, number in stock: %3d \n", (i + 1),  list.get(i).getTitle(), list.get(i).getYear(), list.get(i).getRating(), list.get(i).getQuantity());
		}
		return finalString;
	}

}


