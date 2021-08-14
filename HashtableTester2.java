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
 * 
 * @author Tyler Kortekaas
 *
 */
public class HashtableTester2 {
    
    public static void main(String[] args) {
        System.out.println(testSize());
        System.out.println(testFields());
        System.out.println(addStateStTest());
    }
    // Tests using addStateSt() restaurants
    private static boolean addStateStTest() {
        RestaurantHash resthash = new RestaurantHash();
        resthash.addStateSt();
        if (resthash.containsKey("Qdoba") == false) {
            System.out.println("Did not locate a present object");
            return false;
        }
        // tests if rating is accurately returned
        if (!resthash.get("Chipotle Mexican Grill").getRating().equals(4.2)) {
            System.out.println("Did not accurately reflect rating of object");
            return false;
        }
        // removes object and tests if it is still found
        resthash.remove("Naf Naf Grill");
        try {
             resthash.get("Naf Naf Grill");
             return false;
        } catch (NoSuchElementException exception) {
            
        }
        // tests getting cuisine of a restaurant without a cuisine, should return null
        if (!resthash.get("J-Petal").getCuisine().equals("")) {
            System.out.println("Should not return a cuisine type");
            return false;
        }
        return true;
    }

    // Tests more specialized methods in resthash methods
    private static boolean testFields() {
        RestaurantHash resthash = new RestaurantHash();
        resthash.put(new Restaurant("test", "noname", 4.0));
        Restaurant retrievedField = resthash.get("test");
        // tests addComment by adding two comments, then returning them to a string.
        retrievedField.addComment("Good");
        retrievedField.addComment("ok");
        if (!resthash.getComments("test").equals("Good, ok")) {
            return false;
        }
        // tests get / set cuisine methods
        if (!retrievedField.getCuisine().equals("noname")) {
            System.out.println("Did not accurately reflect cuisine of object");
            return false;
        }
        resthash.updateCuisine("test", "chinese");
        if (!retrievedField.getCuisine().equals("chinese")) {
            System.out.println("Did not accurately update cuisine of object");
            return false;
        }
        // tests get / update rating methods
        if (!retrievedField.getRating().equals(4.0)) {
            System.out.println("Did not accurately reflect rating of object");
            return false;
        }
        resthash.updateRating("test", 4.5);
        if (!retrievedField.getRating().equals(4.5)) {
            System.out.println("Did not accurately update rating of object");
            return false;
        }
        resthash.clear();
        if (resthash.containsKey("test") == true) {
            System.out.println("Did not correctly clear hashtable");
            return false;
        }
        return true;
    }

    // Checks basic method calls within RestaurantHash method, considers chaining
    private static boolean testSize() {
        RestaurantHash resthash = new RestaurantHash();

        // Adds two restaurants that chain, make sure properly sees and returns correct values
        Restaurant one5 = new Restaurant("Panda Express", "Chinese", 4.3);
        Restaurant two5 = new Restaurant("ice", "water", 5.0);
        resthash.put(one5);
        resthash.put(two5);
        if (resthash.containsKey("Panda Express") == false) {
            System.out.println("Did not locate object when it should have");
            return false;
        }
        if (resthash.containsKey("ice") == false) {
            System.out.println("Did not locate object when it should have");
            return false;
        }
        // Makes sure size is accurately returned
        if (resthash.size() != 2) {
            System.out.println("Did not accurately reflect size");
            return false;
        }
        // tests remove method
        resthash.remove("Panda Express");
        if (resthash.size() != 1) {
            System.out.println("Did not accurately reflect size after using remove method");
            return false;
        }
        // Adds random restaurants to get to capacity
        resthash.put(new Restaurant("Candy", "sugar", 1.0));
        resthash.put(new Restaurant("apple", "fruit", 2.2));
        resthash.put(new Restaurant("fire", "air", 8.0));
        resthash.put(new Restaurant("Ford", "car", 6.0));
        resthash.put(new Restaurant("clock", "time", 3.3));
        resthash.put(new Restaurant("Duck", "Bird", 6.0));
        resthash.put(new Restaurant("Computer", "Machine", 4.0));
        resthash.put(new Restaurant("Wow", "Exclamation", 1.1));
        resthash.put(new Restaurant("Ok", "Exclamation", 1.2));
        resthash.put(new Restaurant("Yes", "Exclamation", 1.1));



        // Checks size after clearing
        resthash.clear();
        if (resthash.size() != 0) {
            System.out.println("Did not correctly clear hashtable");
            return false;
        }



        return true;
    }


}
