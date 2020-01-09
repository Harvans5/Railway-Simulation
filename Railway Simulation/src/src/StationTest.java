package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.Rider;
import src.Station;
import src.Train;

class StationTest {
	Station s;
	
	@Test
	void initTest() {
		s = new Station("s");
		assertEquals(null, s.northBoardTrain());
		assertEquals(null, s.southBoardTrain());
		assertEquals("s", s.stationName());
		assertEquals(0, s.northWaiting.length());
		assertEquals(0, s.southWaiting.length());
	}
	
	@Test
	void addWaitingRiders() {
		s = new Station("s");
		
		Rider r = new Rider("abc", "s", "d");
		r.setDirection(1);
		s.addWaitingRider(r);
		
		r = new Rider("abc", "s", "d");
		r.setDirection(0);
		s.addWaitingRider(r);
		
		assertEquals(1, s.northWaiting.length());
		assertEquals(1, s.southWaiting.length());
		
		s.addWaitingRider(r);
		s.addWaitingRider(r);
		s.addWaitingRider(r);
		
		assertEquals(4, s.northWaiting.length());
	}
	
	@Test
	void addTrains() {
		s = new Station("s");
		
		Train t = new Train("s", 1);
		s.addTrainToStation(t);
		
		t = new Train("s", 0);
		s.addTrainToStation(t);
		
		assertEquals(1, s.northBoundTrains.length());
		assertEquals(1, s.southBoundTrains.length());
		assertEquals(0, s.northWaiting.length());
		assertEquals(0, s.southWaiting.length());
		
		s.addTrainToStation(t);
		s.addTrainToStation(t);
		s.addTrainToStation(t);
		
		assertEquals(4, s.northBoundTrains.length());
		assertEquals(1, s.southBoundTrains.length());
	}
	
	@Test
	void testEquals() {
		s = new Station("s");
		
		Station t = new Station("t");
		assertFalse(t.equals(s));
		
		t = new Station("s");
		assertEquals(t, s);
	}
	
	@Test
	void moveTrains() {
		s = new Station("s");
		
		//1 = south-bound trains
		Train t = new Train("s", 1);
		s.addTrainToStation(t);
		s.addTrainToStation(t);
		//0 = north-bound trains
		t = new Train("s", 0);
		s.addTrainToStation(t);
		s.addTrainToStation(t);
		
		assertEquals(2, s.northBoundTrains.length());
		assertEquals(2, s.southBoundTrains.length());
		
		s.moveTrainNorthToSouth();
		
		assertEquals(1, s.northBoundTrains.length());
		assertEquals(3, s.southBoundTrains.length());
		
		s.moveTrainSouthToNorth();
		s.moveTrainSouthToNorth();
		s.moveTrainSouthToNorth();
		
		assertEquals(4, s.northBoundTrains.length());
		assertEquals(0, s.southBoundTrains.length());		
	}
	
	

}
