// --== CS400 File Header Information ==--
// Name: Aryaman Agarwal
// Email: agarwal59@wisc.edu 
// Team: GB
// Role: Back End Developer 2
// TA: Dan
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.Scanner;

/**
 * Kexiang Fang's front end development. 
 * 
 * NOTE: (Small changes made by Aryaman Agarwal to integrate with his back end code)
 * 
 * This class serves as the actual user interface of our application that user can look up for a 
 * restaurant on State Street and then see its cuisine or rating or both of them. The user can add 
 * or remove a restaurant with cuisine and rating or without cuisine or rating. The user can update 
 * a Restaurant's cuisine or rating. The user can also add comments to a Restaurant or get a 
 * Restaurant's comments. The user can get the total number of Restaurants stored in this 
 * application and reset this application which contains no data.
 * This class based on RestaurantHash class which creates functional hashtable that can store 
 * data and manipulate data, Restaurant class which deals with groups of data, and my own 
 * supporting classes including MapADT, HashTableMap, and so on.
 * 
 * @author Kexiang Fang
 *
 */
public class HashTableAppImplement {

  private final static String WELCOME_MSG =
      "===Welcome to State Street Food BadgerPedia! You can get or manipulate the information of "
      + "all restaurants on State Street in Madison, WI!===";
  private final static String GOODBYE_MSG =
      "===Thanks for using State Street Food Badgerpedia! Have a nice day!===";
  private final static String MENU =
      "\nCOMMAND MENU:\n" + "[A] Add a restaurant to this app.\n"
          + "[B] Back to the initial state of this app.\n"
          + "[C] To do with comments of a restaurant.\n"
          + "[E] Empty this app (clear all data stored in this app).\n"
          + "[G] Get the information of a restaurant.\n"
          + "[N] Get the total number of restaurants stored in this app.\n" 
          + "[R] Remove a restaurant from this app.\n"
          + "[U] Update the information of a restaurant.\n" 
          + "[Q] Quit the application.\n"
          + "[H] Help (display this Menu).\n";
  
  /**
   * Private helper method that processes and runs one user command (get, add, remove, update, 
   * comment, get total number of Restaurants, and clear this application) or do nothing.
   * 
   * @param table a reference to RestaurantHash class in order to use methods in RestaurantHash
   * @param command a user command 
   */
  public static void processUserCommand(RestaurantHash table, String command) {
    Scanner scnr = new Scanner(System.in);
    String input = command.trim(); // get rid of surrounding spaces
    String name;
    String cuisine;
    double rating;
    String choice;
    String comment;
    switch (input.toUpperCase()) {
      case "A": // add a restaurant to this app
        System.out.println("Please enter the name of a restaurant: ");
        name = scnr.nextLine().trim();
        System.out.println("Would you like to enter the cuisine of the restaurant? (Y/N): ");
        choice = scnr.nextLine().trim();
        if (choice.equalsIgnoreCase("Y")) {
          System.out.println("Please enter the cuisine of a restaurant: ");
          cuisine = scnr.nextLine().trim();
          System.out.println("Would you like to enter the rating of the restaurant? (Y/N): ");
          choice = scnr.nextLine().trim();
          if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Please enter the rating (a double value) of a restaurant: ");
            rating = scnr.nextDouble();
            if (table.put(new Restaurant(name, cuisine, rating)))
              System.out.println("The restaurant named " + name + " was successfully added.");
            else
              System.out.println("This Add operation failed.");
          }
          else if (choice.equalsIgnoreCase("N")) {
            if (table.put(new Restaurant(name, cuisine, -1.0)))
              System.out.println("The restaurant named " + name + " was successfully added.");
            else 
              System.out.println("This Add operation failed.");
          }
        } 
        else if (choice.equalsIgnoreCase("N")) {
          System.out.println("Would you like to enter the rating of the restaurant? (Y/N): ");
          choice = scnr.nextLine().trim();
          if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Please enter the rating (a double value) of a restaurant: ");
            rating = scnr.nextDouble();
            if (table.put(new Restaurant(name, "", rating)))
              System.out.println("The restaurant named " + name + " was successfully added.");
            else 
              System.out.println("This Add operation failed.");
          }
          else if (choice.equalsIgnoreCase("N")) {
            if (table.put(new Restaurant(name, "", -1.0))) 
              System.out.println("The restaurant named " + name + " was successfully added.");
            else 
              System.out.println("This Add operation failed.");
          }
        }
        else {
          System.out.println("Please enter valid Y or N, not other inputs.");
        }
        break;
      case "B": // back to the initial state of this app
        table.clear();
        table.addStateSt();
        System.out.println("This app backs to its initial state which includes restaurants on "
            + "state street.");
        break; 
      case "C": // to do with comments of a restaurant
        System.out.println("Would like to add or get a comments of a restaurant? (add/get): ");
        choice = scnr.nextLine().trim();
        if (choice.equalsIgnoreCase("add")) {
          System.out.println("Please enter the name of a restaurant that you want comment on: ");
          name = scnr.nextLine().trim();
          System.out.println("Please enter the comment: ");
          comment = scnr.nextLine(); 
          if (table.addComment(name, comment))
            System.out.println("The comment is successfully added to " + name + ".");
          else 
            System.out.println("This operation failed. Because the restaurant doesn't exist.");
        }
        else if (choice.equalsIgnoreCase("get")) {
          System.out.println("Please enter the name of a restaurant that you want get comments "
              + "from: ");
          name = scnr.nextLine().trim();
          System.out.println("The comments are as follows: ");
          if (table.getComments(name) != null) 
            System.out.println(table.getComments(name));
          else
            System.out.println("This operation failed. Because the restaurant doesn't exist.");
        }
        else {
          System.out.println("Please enter valid Y or N, not other inputs.");
        }
        break;
      case "E": // empty this app (clear all data stored in this app)
        table.clear();
        System.out.println("Now there is no info of restaurants stored in this app.");
        break;
      case "G": // get the information of a restaurant
        boolean boolCuisine = false;
        boolean boolRating = false;
        System.out.println("Please enter the name of a restaurant that you want get info from: ");
        name = scnr.nextLine().trim();
        if (!table.containsKey(name)) {
          System.out.println("Oops! The restaurant you are searching for donesn't exist.");
          break;
        }
        System.out.println("Would you like to get the cuisine of a restaurant? (Y/N): ");
        choice = scnr.nextLine().trim();
        if (choice.equalsIgnoreCase("Y")) 
          boolCuisine = true; 
        else if (choice.equalsIgnoreCase("N"))
          boolCuisine = false;
        System.out.println("Would you like to get the rating of a restaurant? (Y/N): ");
        choice = scnr.nextLine().trim();
        if (choice.equalsIgnoreCase("Y")) 
          boolRating = true; 
        else if (choice.equalsIgnoreCase("N"))
          boolRating = false;
        if (boolCuisine) 
          System.out.println("The cuisine of " + name + " is " + table.get(name).getCuisine() 
              + ".");
        if (boolRating)
          System.out.println("The rating of " + name + " is " + table.get(name).getRating() + ".");
        if (!(boolCuisine||boolRating))
          System.out.println("There is no cuisine and rating returned as to your command.");
        break;
      case "N": // get the total number of restaurants stored in this app
        System.out.println("The total number of restaurants stored in this app is " + table.size() 
            + ".");
        break;
      case "R": // remove a restaurant from this app
        System.out.println("Please enter the name of a restaurant that you want to remove: ");
        name = scnr.nextLine().trim();
        if (table.remove(name) != null)
          System.out.println("The restaurant named " + name + " was successfully removed.");
        else
          System.out.println("This operation failed. Because the restaurant doesn't exist.");
        break;
      case "U": // update the information of a restaurant
        System.out.println("Would like to update cuisine or rating of a restaurant? "
            + "(cuisine/rating): ");
        choice = scnr.nextLine().trim();
        if (choice.equalsIgnoreCase("cuisine")) {
          System.out.println("Please enter the name of a restaurant: ");
          name = scnr.nextLine().trim();
          System.out.println("Please enter the cuisine for updating: ");
          cuisine = scnr.nextLine().trim();
          if (table.updateCuisine(name, cuisine))
            System.out.println("The cuisine of " + name + " is successfully updated.");
          else 
            System.out.println("The update is failed. Because the restaurant doesn't exist.");
        }
        else if (choice.equalsIgnoreCase("rating")) {
          System.out.println("Please enter the name of a restaurant: ");
          name = scnr.nextLine().trim();
          System.out.println("Please enter the rating for updating: ");
          rating = scnr.nextDouble();
          if (table.updateRating(name, rating))
            System.out.println("The rating of " + name + " is successfully updated.");
          else
            System.out.println("The update is failed. Because the restaurant doesn't exist.");
        }
        break;
      case "H": // display the menu
        System.out.println(MENU);
        break;
      default:
        System.out.println("WARNING. Invalid command. Please enter H and refer to the menu.");
    } 
  }
  
  /**
   * Driver method for this Hashtable application (reads and processes user command)
   * This driver method prompts the user to do series of actions according to the menu or 
   * do nothing. 
   * 
   */
  private static void driver() {
    // Create a scanner to read the user input commands
    Scanner scanner = new Scanner(System.in);
    // set prompt command message
    String promptCommand = "ENTER COMMAND: ";
    // Create and initialize a instance of RestaurantHash. 
    RestaurantHash table = new RestaurantHash();
    // Initialize the table with all street state restaurants 
    table.addStateSt();
    
    // display menu
    System.out.println(MENU);
    // prompt user
    System.out.println(promptCommand);
    // read first user command
    String command = scanner.next();

    while (!command.equalsIgnoreCase("Q")) {
      // process the user command
      processUserCommand(table, command);
      // read next user command
      command = scanner.next();
    }
    
    // close the scanner
    scanner.close();
  }
  
  /**
   * Main method for state street food Badgerpedia application
   * 
   * @param args 
   */
  public static void main(String[] args) {
    // display Welcome Message
    System.out.println(WELCOME_MSG);
    // read and process user commands 
    driver();
    // display good bye message
    System.out.println(GOODBYE_MSG);
    
  }
  
}
