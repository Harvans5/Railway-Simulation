package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {
	DoubleLinkedList <Integer> l;
	@Test
	void test() {
		l = new DoubleLinkedList<Integer>();
		l.insert(5);
		assertEquals(5,(int)l.getHead().getElement());
		assertEquals(5,(int)l.getTail().getElement());
		assertEquals(1,l.length());
		l.insert(3);
		assertEquals(3,(int)l.getTail().getElement());
		l.delete(5);
		assertEquals(1,l.length());
		assertEquals(3,(int)l.getHead().getElement());
	}

}
