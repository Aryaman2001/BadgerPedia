// --== CS400 File Header Information ==--
// Name: Aryaman Agarwal
// Email: agarwal59@wisc.edu 
// Team: GB
// Role: Back End Developer 2
// TA: Dan
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * Stores data from the different restaurants on state street
 * 
 * @author rowan
 *
 */

public class Restaurant {
	private String rName; // Name of the restaurant
	private Double rRating; // Rating of the restaurant
	private String rCuisine; // Type of cuisine
	private static String[] comments = new String[10]; // Array of strings for comments to be added on restaurants
	private static int size; // Number of comments
	
	/**
	 * Constructor stores the value of each if all variables are given
	 * 
	 * @param name    of restaurant
	 * @param cuisine type of cuisine
	 * @param rating  of the restaurant
	 */
	public Restaurant(String name, String cuisine, Double rating) {
		rName = name;
		rRating = rating;
		rCuisine = cuisine;
	}

	/**
	 * Constructor stores values if no rating is given, and the rating is set to -1
	 * 
	 * @param name    of restaurant
	 * @param cuisine type of cuisine
	 */
	public Restaurant(String name, String cuisine) {
		rName = name;
		rRating = -1.0;
		rCuisine = cuisine;
	}

	/**
	 * Constructor stores values if no cuisine is given, and the cuisine is an empty
	 * string
	 *
	 * @param name   of restaurant
	 * @param rating of the restaurant
	 */
	public Restaurant(String name, Double rating) {
		rName = name;
		rRating = rating;
		rCuisine = "";
	}

	/**
	 * Constructor stores value of the name and sets the rating to -1 and the
	 * cuisine to an empty string
	 * 
	 * @param name of the restaurant
	 * 
	 */
	public Restaurant(String name) {
		rName = name;
		rRating = -1.0;
		rCuisine = "";
	}

	/**
	 * Returns the name of the restaurant
	 * 
	 * @return restaurant name
	 */
	public String getName() {
		return rName;
	}

	/**
	 * Returns the type of cuisine
	 * 
	 * @return cuisine type
	 */
	public String getCuisine() {
		return rCuisine;
	}

	/**
	 * Returns the rating
	 * 
	 * @return restaurant rating
	 */
	public Double getRating() {
		return rRating;
	}

	/**
	 * Sets the cuisine to the given string
	 * 
	 * @param c
	 */
	public void setCuisine(String c) {
		rCuisine = c;
	}

	/**
	 * Sets the rating to the given integer
	 * 
	 * @param r
	 */
	public void setRating(Double r) {
		rRating = r;
	}
	
	/**
	 * Adds a comment
	 * 
	 * @param s the comment to be added
	 */
	public void addComment(String s) {
		if (comments[comments.length - 1] != null) {
			String [] temp = comments.clone();
			comments = new String[comments.length*2];
			// Goes through comments and recopies all the old comments into the array
			for (int i = 0; i < temp.length; i++) {
				comments[i] = temp[i];
			}
		}
		// Adds comment
		comments[size] = s;
		size++;
	}
	
	/**
	 * 
	 */
	public String[] getComments() {
		return comments;
	}
}
