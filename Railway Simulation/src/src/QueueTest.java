package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

	@SuppressWarnings("rawtypes")
	Queue q;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	void initTest() {
		q = new Queue(3);
		assertTrue(q.isEmpty());
		q.enqueue(1);
		assertFalse(q.isEmpty());
		assertEquals(1,q.peek());
		assertEquals(1,q.length());
		q.dequeue();
		assertTrue(q.isEmpty());
	}

}
