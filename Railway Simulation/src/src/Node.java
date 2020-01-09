//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//This class is used for implementing nodes into the doubly linked list 
package src;
public class Node<T> {

	T element;
	Node<T> next;
	Node<T> prev;
	/**
	 * Constructor sets the element, next, and prev equal to null
	 * Constant time O(1)
	 */
	public Node() {
		element = null;
		next = null;
		prev = null;
		
	}
	/**
	 * Constructor for the node class takes in the three parameters and sets them equal to the fields
	 * Constant time O(1)
	 * @param element, value being stored in the node
	 * @param next, pointer to next element
	 * @param prev, pointer to previous element
	 */
	public Node(T element, Node<T> next, Node<T> prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
	/**
	 * Sets the element field equal to the parameter passed
	 * Constant time O(1)
	 * @param element, the value that the node will now hold
	 */
	public void setElement(T element) {
		this.element = element;
	}
	/**
	 * Returns the element
	 * Constant time O(1)
	 * @return element of node
	 */
	public T getElement() {
		return element;
	}
	/**
	 * Sets the next equal to the node next
	 * Constant time O(1)
	 * @param next, the node that will have a next pointer to it
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	/**
	 * Sets the prev equal to the node previous
	 * Constant time O(1)
	 * @param prev, the node that will have a previous pointer to it
	 */
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	/**
	 * returns the next node
	 * Constant time O(1)
	 * @return the next node
	 */
	public Node<T> getNext() {
		return next;
	}
	/**
	 * returns the prev node 
	 * Constant time O(1)
	 * @return prev node
	 */
	public Node<T> getPrev(){
		return prev;
	}
	/**
	 * returns the element inside the node
	 * Constant time O(1)
	 */
	public String toString() {
		return (String)element;
	}
	/**
	 * Used in the search method for the linked list so that nodes can be compared for any type of value 
	 * since the node class is generic
	 * Run time for this method is constant time O(1)
	 * @param element
	 * @return boolean value 
	 */
	public boolean compareTo(T element) {
		if(this.element == element) {
			return true;
		}
		if(this.element.equals(element)) {
			return true;
		}
		return false;
	}
}
