// --== CS400 File Header Information ==--
// Name: Aryaman Agarwal
// Email: agarwal59@wisc.edu 
// Team: GB
// Role: Back End Developer 2
// TA: Dan
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * Created a new class to act as a container holding key-value pairs which are
 * inserted into the Linked List. Key and Value are kept generic to allow usage
 * with different key-value pairings.
 * 
 * @author Aryaman Agarwal
 *
 * @param <KeyType>   key
 * @param <ValueType> value
 */
public class ListNode<KeyType, ValueType> {
	private KeyType key;
	private ValueType value;

	/**
	 * Constructor for the class. Assigns key and value data.
	 * 
	 * @param key   key provided by the user
	 * @param value value provided by the user
	 */
	public ListNode(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
	}

	/***
	 * Getter method for key.
	 * 
	 * @return key provided by the user
	 */
	public KeyType getKey() {
		return key;
	}

	/**
	 * Getter method for value.
	 * 
	 * @return value provided by the user
	 */
	public ValueType getValue() {
		return value;
	}
}
