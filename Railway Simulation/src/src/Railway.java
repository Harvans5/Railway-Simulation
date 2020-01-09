//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//Creates the railway which is a double linked list of type station
//Null pointer error in the simulate method due to setting the next node in the linked list to null
package src;
public class Railway {
	DoubleLinkedList<Station> railway;
	String[] stations;
	int stationIndex;

	/**
	 * Constructor creates the double linked list railway of type station and creates the station array which holds 18
	 * and starts the station index at 0
	 */
	public Railway(){
		railway = new DoubleLinkedList<Station>();
		stations = new String [18];
		stationIndex = 0;
	}
	/**
	 * Calls to the insert method in the double linked list and adds the stations name to the stations array 
	 * and increases the stationsIndex
	 * Constant time O(1)
	 * @param s, station being added to the railway
	 */
	public void addStation(Station s) {
		railway.insert(s);
		stations[stationIndex] = s.stationName();
		stationIndex++;
	}
	/**
	 * adds a rider to the railways correct station element and sets the riders direction
	 * linear time O(n)
	 * @param r, rider thats trying to add a station
	 */
	public void addRider(Rider r) {
		String station1 = r.getStarting();
		String station2 = r.getDestination();
		r.setDirection(calcStation(station1,station2));
		Node<Station> s = railway.head;
		while(!(s.getElement().stationName().equals(r.getStarting()))){
			s = s.next;
		}
		s.getElement().addWaitingRider(r);
	}
	/**
	 * adds a train to the railways correct station element 
	 * Linear time O(n)
	 * @param t, train being added
	 */
	public void addTrains(Train t) {
		Node<Station> s = railway.head;
		while(!(s.getElement().stationName().equals(t.getStation()))){
			s = s.next;
		}
		s.getElement().addTrainToStation(t);
	}
	/**
	 * Returns the direction the rider should be headed in and is used in the addRider method figures out wether the 
	 * starting or destination station arrives first in the loop through the stations array to determine the direction
	 * Linear time O(n)
	 * @param station1 starting station of rider
	 * @param station2 station they are trying to reach
	 * @return the direction that the rider is headed
	 */
	public int calcStation(String station1, String station2) {
		int startLocation = -1;
		int endLocation = -1;
		for(int i = 0; i < stations.length; i++) {
			if(station1.equals(stations[i])) {
				startLocation = i;
			} else if(station2.equals(stations[i])) {
				endLocation = i;
			}
		}
		//sees if the rider is heading north or south based off if the starting location is less or greater than the end location
		if(startLocation < endLocation) {
			return 1;
		}
		return 0;
	}
	/**
	 * Simulates the entire railway with all stations and if there is a train at a station it is  moved to their next station.
	 * While this is happening the train will be dropping off and picking up passengers when suitable. 
	 * If a train reaches the last station its direction is reversed and it is pushed the other way. 
	 * Run time is Linear time O(n)
	 * @return
	 */
	public String simulate() {
		String result = "";
		Node<Station> s = railway.head;
		while(s != null) {
			Station current = s.getElement();
			result += current.toString();
			boolean yHasMoved = false;
			if(current.northBoundTrains.isEmpty() == false) {
				if(s.prev == null) {
					s.getElement().moveTrainNorthToSouth();
					yHasMoved = true;
				} else {
					result += s.prev.getElement().addTrainToStation(current.northBoardTrain()) + "\n";
				}
				
			}
			if(current.southBoundTrains.isEmpty() == false) {
				if(yHasMoved == false || current.southBoundTrains.length() >= 2) {
					//if s is the tail then you are at the last station so the direction changes to north 
					if(s.next == null) {
						s.getElement().moveTrainSouthToNorth();
					} else {
						result += s.next.getElement().addTrainToStation(current.southBoardTrain()) + "\n";
					}
				}
			}
			s = s.next;
		}
		return result;
	}
	/**
	 * Returns the toString of railway which is just the toString method of the double linked list class
	 * Constant time O(1) with a call to a linear time method
	 */
	public String toString() {
		return railway.toString();
	}
}
