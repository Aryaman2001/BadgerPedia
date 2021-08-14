// --== CS400 File Header Information ==--
// Name: Aryaman Agarwal
// Email: agarwal59@wisc.edu 
// Team: GB
// Role: Back End Developer 2
// TA: Dan
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;

/**
 * This class implements the HashTableMap class made for Project one to store
 * Restaurant objects in the hash table. Chaining is used to handle collisions.
 * Linked lists are used to chain. Insert, get, remove, size and clear are some
 * functionalities available.
 * 
 * @author Aryaman Agarwal
 *
 */
public class RestaurantHash {
	private HashTableMap restArray;

	/**
	 * Constructor for the class. Calls HashTableMap class from Project one with
	 * capacity given.
	 * 
	 * @param capacity length of array which stores Restaurant objects
	 */
	public RestaurantHash(int capacity) {
		restArray = new HashTableMap(capacity);
	}

	/**
	 * Default constructor. Calls HashTableMap class from Project one with a default
	 * capacity of 10.
	 */
	public RestaurantHash() {
		restArray = new HashTableMap(10); // default capacity = 10
	}

	/**
	 * Calls put method from Project one which calculates hash index from given
	 * string name and inserts the restaurant object in the table. Only new
	 * restaurant objects are added. Collisions are handled by chaining. Table is
	 * resized if Load Factor is greater than or equal to 0.8.
	 * 
	 * @param restaurant object to be added to the table
	 * 
	 * @return true if object is inserted, false otherwise
	 */
	public boolean put(Restaurant restaurant) {
		return restArray.put(restaurant.getName(), restaurant);
	}

	/**
	 * Calls get method Project one which finds the restaurant object corresponding
	 * to the name provided.
	 * 
	 * @param rName name of the Restaurant object to be found
	 * @return restaurant object corresponding to the String given
	 * @throws NoSuchElementException when name given is not in the table
	 */
	public Restaurant get(String rName) throws NoSuchElementException {
		return (Restaurant) restArray.get(rName);
	}

	/**
	 * This method is expected to be called by the front end to populate the table
	 * with existing data.
	 */
	public void addStateSt() {
		this.put(new Restaurant("Chipotle Mexican Grill", "Mexican", 4.2));
		this.put(new Restaurant("Poke Bowl Plus", "Poke", 4.1));
		this.put(new Restaurant("Mediterranean Cafe", "Mediterranean", 4.7));
		this.put(new Restaurant("State Street Brats", "Bar", 4.1));
		this.put(new Restaurant("Colectivo Coffee", "Coffee", 4.5));
		this.put(new Restaurant("Jimmy John's", "Sandwich", 3.4));
		this.put(new Restaurant("Conrad's Grill", "Grill", 4.7));
		this.put(new Restaurant("Naf Naf Grill", "Middle Eastern", 4.4));
		this.put(new Restaurant("Potbelly Sandwich Shop", "Sandwich", 4.1));
		this.put(new Restaurant("Qdoba", "Mexican", 3.9));
		this.put(new Restaurant("Mondays", "Bar", 4.1));
		this.put(new Restaurant("HungryBadger Cafe", "Bar", 5.0));
		this.put(new Restaurant("Five Guys", "Hamburger", 4.3));
		this.put(new Restaurant("J-Petal", 4.6));
		this.put(new Restaurant("Chen's Dumpling House", "Dumpling", 4.5));
		this.put(new Restaurant("Koi Sushi", "Sushi", 3.6));
		this.put(new Restaurant("Insomnia Cookies", "Bakery", 3.6));
		this.put(new Restaurant("Cold Stone Creamery", "Ice Cream", 4.2));
		this.put(new Restaurant("Grace Coffee Co.", "Coffee", 4.0));
		this.put(new Restaurant("Le C's Patisserie & Tea House", "Bubble tea", 4.8));
		this.put(new Restaurant("Sencha Tea Bar", "Tea House", 4.6));
		this.put(new Restaurant("Fair Trade Coffee House", "Coffee", 4.5));
		this.put(new Restaurant("Dragon I", "Asian Fusion", 3.6));
		this.put(new Restaurant("Pizza Di Roma State", "Pizza", 4.0));
		this.put(new Restaurant("Parthenon Gyros", "Greek", 4.5));
		this.put(new Restaurant("Tutto Pasta State Street", "Italian", 4.1));
		this.put(new Restaurant("Short Stack Eatery", "Breakfast", 4.6));
		this.put(new Restaurant("Noodles and Company", 3.8));
		this.put(new Restaurant("Fresco", "Fine Dining", 4.4));
		this.put(new Restaurant("Espresso Royale Cafe", "Coffee", 4.5));
		this.put(new Restaurant("Cask & Ale", "Bar", 4.3));
		this.put(new Restaurant("Paul's Club", "Bar", 4.3));
		this.put(new Restaurant("Kiwlin's Madison", "Chocolate", 4.8));
		this.put(new Restaurant("Buck and Badger Northwoods Lodge", "Grill", 3.5));
		this.put(new Restaurant("Michelangelo's", "Coffee", 4.6));
		this.put(new Restaurant("107 State", "American", 4.5));
		this.put(new Restaurant("Ian's Pizza on State", "Pizza", 4.6));
	}

	/**
	 * Calls the size method from Project one.
	 * 
	 * @return number of Restaurant objects stored in the table
	 */
	public int size() {
		return restArray.size();
	}

	/**
	 * Calls containsKey method from Project one which iterates through the table to
	 * find matching restaurant object.
	 * 
	 * @param rName name of the concerned restaurant object
	 * @return true if the table contains the object, false otherwise
	 */
	public boolean containsKey(String rName) {
		return restArray.containsKey(rName);
	}

	/**
	 * Removes and returns the restaurant corresponding to given name.
	 * 
	 * @param rName name of restaurant object to be removed
	 * @return Restaurant object that was removed
	 */
	public Restaurant remove(String rName) {
		return (Restaurant) restArray.remove(rName);
	}

	/**
	 * Clears all restaurant objects from the table.
	 */
	public void clear() {
		restArray.clear();
	}

	/**
	 * Updates the rating of the given restaurant.
	 * 
	 * @param rName     name of the restaurant object to be updated
	 * @param newRating new double to be set as the rating
	 * @return true if updated, false otherwise
	 */
	public boolean updateRating(String rName, Double newRating) {
		if (!restArray.containsKey(rName)) {
			return false;
		}

		((Restaurant) restArray.get(rName)).setRating(newRating);
		return true;
	}

	/**
	 * Updates the cuisine of the given restaurant.
	 * 
	 * @param rName      name of the restaurant object to be updated
	 * @param newCuisine new string to be set as the cuisine
	 * @return true if updated, false otherwise
	 */
	public boolean updateCuisine(String rName, String newCuisine) {
		if (!restArray.containsKey(rName)) {
			return false;
		}

		((Restaurant) restArray.get(rName)).setCuisine(newCuisine);
		return true;
	}

	/**
	 * Adds a new comment to the given restaurant.
	 * 
	 * @param rName      name of the restaurant object to be updated
	 * @param newComment new string of comment to be add
	 * @return true if added, false otherwise
	 */
	public boolean addComment(String rName, String newComment) {
		if (!restArray.containsKey(rName)) {
			return false;
		}

		((Restaurant) restArray.get(rName)).addComment(newComment);
		return true;
	}

	/**
	 * Retrieves and returns a string of comments made by users for the given
	 * restaurant.
	 * 
	 * @param rName name of the restaurant object for which comments are returned
	 * @return string of comments
	 */
	public String getComments(String rName) {
		if (!restArray.containsKey(rName))
		      return null;
		int i = 0;
		String comments = "";
		while (((Restaurant) restArray.get(rName)).getComments()[i] != null) {
			comments += ((Restaurant) restArray.get(rName)).getComments()[i] + ", ";
		    ++i;
		}if (comments.length() > 0)
		      comments = comments.substring(0, comments.length() - 2);
		    return comments;
	}

}
