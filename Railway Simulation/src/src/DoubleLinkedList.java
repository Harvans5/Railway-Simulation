//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
/* The double linked class is created and is generic type and interacts with node class to create a double linked list
 * to store the railway of type station in*/
package src;
public class DoubleLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int length;
	
	/**
	 * Constructor for the class sets the tail and head equal to each other and starts the length at 0
	 * Constant time O(1)
	 */
	public DoubleLinkedList (){
		head = null;
		tail = null;
		length = 0;
	}
	/**
	 * This method simply returns the head of the doubly linked list
	 * Constant time O(1)
	 * @return head of list
	 */
	public Node<T> getHead(){
		return head;
	}
	/**
	 * This method just returns the tail of the doubly linked list
	 * @return tail of list
	 */
	public Node<T> getTail(){
		return tail;
	}
	/**
	 * This method takes an element as a parameter and inserts a new node at the end of the doubly linked list 
	 * it also checks to see if the node is the first node being added in which case that node reprsents both the tail and the head 
	 * or if its being added after nodes already exist in whihc case it shifts the tail. Also updates the length of the list
	 * Constant time O(1)
	 * @param key, value of node entered
	 * @return the node that was entered
	 */
	public Node<T> insert(T key) {
		Node <T> n = new Node<T>(key,null,tail);
		if(tail == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
		}
		tail = n;
		length++;
		return tail;
	}
	/**
	 * This method deletes a specfic node from the list using the search method to locate where in the list the key is and then updates the 
	 * nodes accordingly after the node has been deleted and then decreases the length.
	 * This method is constant time but with a call to the search method which is linear time O(n)
	 * @param key of node that is trying to be removed
	 */
	public void delete(T key) {
		Node <T> n = search(key);
		if(n == null) {
			System.out.println("This key could not be found");
			return;
		}
		if(n.prev != null) {
			(n.prev).next = n.next;
		} else {
			head = n.next;
		}	
		if(n.next != null) {
			(n.next).prev = n.prev;
		}
		length--;
	}
	/**
	 * Checks for a current key and returns it once it finds it in the list
	 * Linear time O(n)
	 * @param key of node being searched for
	 * @return null or the node if it was found
	 */
	public T get(T key){
		Node <T> current = search(key);
		return current.getElement();
	}
	/**
	 * This method returns the length of the list 
	 * Constant time O(1)
	 * @return length of the list
	 */
	public int length() {
		return length;
	}
	/** 
	 * This method prints out the entire doubly linked list and runs until the next node is null
	 * Linear time O(n)
	 */
	public String toString() {
		Node <T> current = head;
		String list = "";
		if(current == null) {
			return list;
		}
		while(current.next != null) {
			list = list + current + " ";
			current = current.next;
		}
		list = list + current;
		return list;
	}
	/**
	 * This method searches for a certain element in the doubly linked list and then returns that node. Mainly used for the delete method 
	 * Linear time O(n)
	 * @param key
	 * @return
	 */
	public Node<T> search(T key){
		Node <T> current = head;
		if(current == null) {
			return current;
		}
		while(!current.compareTo(key) && current.next != null) {
			current = current.next;
		}
		return current;
	}
	
}
