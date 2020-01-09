package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrainTest {

	Train t;
	Rider r;
	
	@Test
	void initTest() {
		t = new Train ("s", 1);
		
		assertEquals(1, t.getDirection());

		assertEquals(0, t.passengerIndex);
		assertEquals(10, t.passengers.length);
		assertEquals("s", t.currentStation);
		
		t.updateStation("u");
		
		assertEquals("u", t.currentStation);

		
	}
	
	@Test
	void passengerOperations() {
		t = new Train ("s", 1);
		assertEquals("", t.currentPassengers());
		assertTrue(t.canAddPassenger());
		assertEquals("", t.removePassenger(new Station("s")));
		
		//rider is at same station, same direction
		r = new Rider("abc", "s", "s");
		r.setDirection(1);
		assertTrue(t.addPassenger(r));
		assertEquals(1, t.passengerIndex);
		assertTrue(t.removePassenger(new Station("s")).length()>0);

		//rider is at same station, same direction; different destination
		r = new Rider("abc", "s", "u");
		r.setDirection(1);
		assertTrue(t.addPassenger(r));
		assertTrue(t.removePassenger(new Station("s")).length()==0);
		assertTrue(t.removePassenger(new Station("u")).length()>0);

		//rider is at same station, different direction
		r = new Rider("abc", "s", "s");
		r.setDirection(0);
		assertFalse(t.addPassenger(r));

		//rider is at different station, same direction
		r = new Rider("abc", "t", "u");
		r.setDirection(1);
		assertFalse(t.addPassenger(r));
		
		//rider is at different station, different direction
		r = new Rider("abc", "t", "u");
		r.setDirection(0);
		assertFalse(t.addPassenger(r));

		
	}

}
