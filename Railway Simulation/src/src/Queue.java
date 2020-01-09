//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//This class creates a queue that is type generic and is created using an array 
package src;
import java.util.Arrays;

public class Queue<T> {

	T[] q;
	int head;
	int tail;
	int length;
	int size;
	/**
	 * Constructor for the queue which passes in the size of the queue and sets the head tail and length equal to 0
	 * Constant time O(1)
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Queue(int size){
		this.size = size;
		q = (T[]) new Object [size];
		head = 0;
		length = 0;
		tail = 0;
	}
	/**
	 * Enqueue method adds an element into the back of the queue which adjusts the tail to that element and the length
	 * Constant time O(1)
	 * @param element that is being added 
	 */
	public void enqueue(T element) {
		q[tail]= element;
		if(tail == size) {
			tail = 0;
		} else {
			tail++;
		}
		length ++;
	}
	/**
	 * Dequeue method removes the first element inside the queue and shifts the head back and decreases the length
	 * Constant time O(1)
	 * @return the element removed
	 */
	public T dequeue() {
		T x = q[head];
		if(head == size) {
			head = 0;
		} else {
			head++;
		}
		length--;
		return x;
	}
	/**
	 * Returns the head of the queue 
	 * Constant time O(1)
	 * @return the head of the queue
	 */
	public T peek() {
		return q[head];
	}
	/**
	 * Returns the length of the queue
	 * Constant time O(1)
	 * @return the length of the queue
	 */
	public int length() {
		return length;
	}
	/**
	 * Checks to see if the queue is empty which just checks if length is zero
	 * Constant time O(1)
	 * @return
	 */
	public boolean isEmpty() {
		if(length == 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Method creates a generic array and places elements of queue into the array for display
	 * Linear time O(n)
	 */
	public String toString() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[length];
		for(int i = 0; i < length; i++) {
			array[i] = q[head + 1];
		}
		return Arrays.toString(array);
	}
	
}
