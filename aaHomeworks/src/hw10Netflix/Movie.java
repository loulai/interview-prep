package hw10Netflix;
import java.util.ArrayList;

/** This class represents a single movie that will be used in the Inventory class
 * created on: December 8th 2014
 * @author loulai
 */
public class Movie{
	
	private String title;
	private int year;
	private double rating;
	private int quantity;

	/** Constructor method for Movie object that sets a movie's title, year, rating, and increases quantity
	 * @param title  String title of movie
	 * @param year   int    year the movie was made
	 * @param rating double rating of the movie
	 * @throws IllegalArgumentException thrown when rating or year is invalid
	 */
	public Movie(String title, int year, double rating) throws IllegalArgumentException{
		this.quantity++; 
		this.title = title;
		setRating(rating);
		setYear(year);
	}
	
	/** setter for years
	 * @param year  int year movie was made
	 * @throws IllegalArgumentException throws if the year is not between 1870 and 2014
	 */
	public void setYear(int year) throws IllegalArgumentException{
		if(year >= 1870 && year <= 2014) this.year = year;
		else throw new IllegalArgumentException("Invalid Year, must be between 1870 and 2014 inclusive");
	}
	
	/** getting for Movie title
	 * @return String the title of the movie
	 */
	public String getTitle(){
		return this.title;
	}
	
	/** getting for Movie year
	 * @return int the year of the movie
	 */
	public int getYear(){
		return this.year;
	}
	
	/** getter for Movie rating
	 * @return double the rating of the movie
	 */
	public double getRating() {
		return this.rating;
	}
	
	/** sets the new rating for a Movie object
	 * @param otherRating double the new rating
	 * @throws IllegalArgumentException will throw exceptions when rating not between 0 and 4 inclusive
	 */
	public void setRating(double otherRating) throws IllegalArgumentException{
		if(otherRating >= 0.0 && otherRating <= 4.0) this.rating = otherRating;
		else throw new IllegalArgumentException("Invalid Rating number, must be between 0 and 4 inclusive");
	}
	
	/** getter for Movie quantity
	 * @return int the quantity of the movie
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/** increasing the quantity variable of a Movie object 
	 */
	public void increaseQuantity(){
		this.quantity ++;
	}
	
	/** decreasing the quantity variable of a Movie object
	 */
	public void decreaseQuantity() {
		if(this.quantity > 0){
			this.quantity --;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * returns a String with a properly formatted output of every element in the inventory list array
	 */
	@Override
	public String toString() {
		return String.format("%-10s (%-4d), rating: %2.1f, number in stock: %4d", title, year, rating, quantity);
	}
	
}
