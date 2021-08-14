// --== CS400 File Header Information ==--
// Name: Aryaman Agarwal
// Email: agarwal59@wisc.edu 
// Team: GB
// Role: Back End Developer 2
// TA: Dan
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.NoSuchElementException;
import java.lang.Math;
import java.util.LinkedList;

/**
 * This class implements a hash table using arrays. Generics are used for
 * key-value pairs to allow for different data types. Chaining is used to handle
 * collisions. Linked lists are used to chain key-value pairs. Insert, get,
 * remove, size and clear are some functionalities available to the user.
 * 
 * @author Aryaman Agarwal
 *
 * @param <KeyType>   key
 * @param <ValueType> value
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
	private LinkedList[] hashArray;
	private int capacity;
	private int size;

	/**
	 * Constructor for the class. Initializes array (which stores key-value pairs)
	 * to the capacity provided by the user. Also assigns the size variable.
	 * 
	 * @param capacity length of array which stores key-value pairs
	 */
	public HashTableMap(int capacity) {
		hashArray = new LinkedList[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	/**
	 * Default constructor. Initializes the array to a default capacity of 10. Also
	 * assigns the size variable.
	 */
	public HashTableMap() {
		hashArray = new LinkedList[10]; // default capacity = 10
		this.capacity = 10;
		this.size = 0;
	}

	/**
	 * Calculates hash index from given key and inserts the key-value pair in the
	 * table. Only new key-value pairs are added. Collisions are handled by
	 * chaining. Table is resized if Load Factor is greater than or equal to 0.8.
	 * 
	 * @param key   to be inserted
	 * @param value to be inserted
	 * 
	 * @return true if key-value pair is inserted, false otherwise
	 */
	@Override
	public boolean put(KeyType key, ValueType value) {
		if (containsKey(key)) { // value is already in the table
			return false;
		}

		int index = Math.abs(key.hashCode()) % capacity;
		if (hashArray[index] == null) {
			hashArray[index] = new LinkedList<ListNode>(); // creating a new Linked List
		}
		// adding key-value to the array
		hashArray[index].add(new ListNode(key, value));
		size++;

		if ((double) size / capacity >= 0.8) { // checking if resizing is required
			rehash();
		}
		return true;
	}

	/**
	 * Private helper method for insert method. Resizes the table, then rehashes
	 * each key-value pair into the new array.
	 */
	private void rehash() {
		LinkedList[] tempArray = new LinkedList[2 * this.capacity]; // new hash array
		this.capacity = 2 * this.capacity;

		for (int i = 0; i < hashArray.length; i++) { // iterating through old hash array
			if (hashArray[i] != null) {
				// temporarily holding elements from old hash array's individual linked list
				LinkedList<ListNode> tempList = hashArray[i];

				// iterating through the linked list, rehashing and inserting each element into
				// new hash array
				for (int j = 0; j < tempList.size(); j++) {
					int newIndex = Math.abs(tempList.get(j).getKey().hashCode()) % capacity;

					if (tempArray[newIndex] == null) {
						tempArray[newIndex] = new LinkedList<ListNode>();
						tempArray[newIndex].add(tempList.get(j));
					} else {
						tempArray[newIndex].add(tempList.get(j));
					}
				}
			}
		}
		// assigning new hash array
		this.hashArray = tempArray;
	}

	/**
	 * Returns the value corresponding to the key given.
	 * 
	 * @throws NoSuchElementException when key given is not in the table
	 * @param key for which value is to be returned
	 * 
	 * @return <ValueType> value corresponding to the key given
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		if (!containsKey(key)) {
			throw new NoSuchElementException();
		}

		// searching for matching key by iterating through the list
		int index = Math.abs(key.hashCode()) % capacity;
		for (int i = 0; i < hashArray[index].size(); i++) {
			if (((ListNode) hashArray[index].get(i)).getKey().equals(key)) {
				return (ValueType) ((ListNode) hashArray[index].get(i)).getValue();
			}
		}
		return null;
	}

	/**
	 * Returns the number of key-value pairs stored in the table.
	 * 
	 * @return number of key-value pairs stored in the table
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Checks whether the table contains the given key or not.
	 * 
	 * @param key to be checked for
	 * 
	 * @return true if the table contains the key, false otherwise
	 */
	@Override
	public boolean containsKey(KeyType key) {
		int index = Math.abs(key.hashCode()) % capacity;

		if (hashArray[index] == null) {
			return false;
		}

		// searching for matching key by iterating through the list
		for (int i = 0; i < hashArray[index].size(); i++) {
			if (((ListNode) hashArray[index].get(i)).getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes key-value pair from the table for given key.
	 * 
	 * @param key for which pair is to be removed
	 * 
	 * @return value of the removed pair
	 */
	@Override
	public ValueType remove(KeyType key) {
		if (!containsKey(key)) {
			return null;
		}

		// searching for matching key by iterating through the list
		int index = Math.abs(key.hashCode()) % capacity;
		for (int i = 0; i < hashArray[index].size(); i++) {
			if (((ListNode) hashArray[index].get(i)).getKey().equals(key)) {
				size--;
				return (ValueType) ((ListNode) hashArray[index].remove(i)).getValue();
			}
		}
		return null;
	}

	/**
	 * Clears all key-value pair from the table.
	 */
	@Override
	public void clear() {
		for (int i = 0; i < this.capacity; i++) {
			hashArray[i] = null;
		}
		this.size = 0;
	}

}
