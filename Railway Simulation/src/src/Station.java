//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//This class creates the station object and creates 4 queues for waiting riders in both directions and 
//waiting trains in both directions
package src;
public class Station {
	public String name;
	Queue<Rider> northWaiting;
	Queue<Rider> southWaiting;
	Queue<Train> northBoundTrains;
	Queue<Train> southBoundTrains;
	/**
	 * Constructor of the station class parameter with the stations name and creates the queues with a size of 20
	 * Constant time O(1)
	 * @param name
	 */
	public Station(String name) {
		this.name = name;
		northWaiting = new Queue<Rider>(20);
		southWaiting = new Queue<Rider>(20);
		northBoundTrains = new Queue<Train>(20);
		southBoundTrains = new Queue<Train>(20);
	}
	/**
	 * Checks which direction the rider is going and then adds them to the appropriate queue 
	 * Constant time O(1)
	 * @param r, rider that is waiting for a train
	 */
	public void addWaitingRider(Rider r) {
		if(r.getDirection() == 0) {
			northWaiting.enqueue(r);
		} else {
			southWaiting.enqueue(r);
		}
	}
	/**
	 * Checks the direction the train is going and then removes any passengers that will get off at that station before 
	 * adding the train to that stations queue
	 * Constant time O(1)
	 * @param t, train that is being added to queue of trains 
	 * @return the riders that got off the train 
	 */
	public String addTrainToStation(Train t) {
		t.updateStation(name);
		String removedRiders = "";
		//calls to remove passengers at the station
		String riderRemoved = t.removePassenger(this);
		if(riderRemoved.length() > 1) {
			removedRiders = riderRemoved;
		}
		//if the loop equals "" then no rider got off at this station which means no further calls to check for
		//riders that want to get off need to be checked
		while(!riderRemoved.equals("")) {
			riderRemoved = t.removePassenger(this);
			if(riderRemoved.length() > 1) {
				removedRiders = removedRiders + riderRemoved;
			}
		}
		//After riders are removed the train will then be added to the appropriate queue
		if(t.getDirection() == 0) {
			t.removePassenger(this);
			northBoundTrains.enqueue(t);
		} else {
			t.removePassenger(this);
			southBoundTrains.enqueue(t);
		}
		return removedRiders + " " + t.toString();
	}
	/**
	 * Checks to see if the train queue is empty and if it isn't dequeues a train from the southBound queue 
	 * and adds passengers to it if available until its full and then returns the train
	 * Constant time since the train can only hold 10 passengers O(1)
	 * @return
	 */
	public Train southBoardTrain() {
		if(!(southBoundTrains.isEmpty())) {
			Train t = southBoundTrains.dequeue();
			while(!(southWaiting.isEmpty()) && t.canAddPassenger()) {
				Rider r = southWaiting.dequeue();
				t.addPassenger(r);
			}
			return t;
		}
		return null;
	}
	/** 
	 * Works exaclty the same as southBoardTrain but for trains heading north
	 * Constant time since a train can only hold 10 passengers O(1)
	 * @return
	 */
	public Train northBoardTrain() {
		if(!(northBoundTrains.isEmpty())) {
			Train t = northBoundTrains.dequeue();
			while(!(northWaiting.isEmpty()) && t.canAddPassenger()) {
				Rider r = northWaiting.dequeue();
				t.addPassenger(r);
			}
			return t;
		}
		return null;
	}
	/**
	 * Checks if the train is at the northern most stop and then changes its direction and adds it to south queue 
	 * Constant time O(1)
	 */
	public void moveTrainNorthToSouth() {
		if(northBoundTrains.isEmpty()) {
			return;
		}
		Train t = northBoundTrains.dequeue();
		t.setDirection(1);
		southBoundTrains.enqueue(t);
	}
	/**
	 * Same as the moveTrainNorthToSouth but just checks for south trains that have reached southern most station
	 * Constant time O(1)
	 */
	public void moveTrainSouthToNorth() {
		Train t = southBoundTrains.dequeue();
		t.setDirection(0);
		northBoundTrains.enqueue(t);
	}
	/**
	 * Returns how many people and trains are currently waiting at the station to go north
	 * and how many people and trains are currently waiting at the station to go south
	 * Constant time O(1)
	 */
	public String toString() {
		String trains = "Station: " + name + "\n" + northBoundTrains.length()+ " north-bound trains waiting \n" +southBoundTrains.length() + " south-bound trains waiting\n";
		String riders = northWaiting.length() + " north-bound passengers waiting\n" + southWaiting.length() + " south-bound passengers waiting\n\n";
		return trains + riders;
	}
	/**
	 * Returns the name of the station
	 * Constant time O(1)
	 * @return
	 */
	public String stationName() {
		return name;
	}
	/**
	 * Checks if the station names are equal 
	 * Constant time O(1)
	 */
	public boolean equals(Object s) {
		if(s instanceof Station) {
			Station sNew = (Station) s;
			if(sNew.stationName().equals(this.stationName())) {
				return true;
			}
		}
		return false;
	}
}
