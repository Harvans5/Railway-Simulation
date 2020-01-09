package src;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest{
	@SuppressWarnings("rawtypes")
	Node n;
	@SuppressWarnings("rawtypes")
	Node nn;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void initTest(){
		n = new Node();
		nn = new Node ();
		nn.setElement(5);
		n.setElement(3);
		assertEquals(3,n.getElement());
		n.setNext(n);
		assertEquals(3,n.getNext());
		assertEquals(null,n.getPrev());
		n.setPrev(nn);
		assertEquals(5,n.getPrev());
	}

}
