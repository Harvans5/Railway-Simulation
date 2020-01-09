//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//This class creates train objects which hold a direction and a current station
package src;
public class Train {
	 final int TOTAL_PASSENGERS = 10;
	 Rider[] passengers;
	 String currentStation;
	 int direction;
	 int passengerIndex;
	/**
	 * Constructor which creates an array of passengers which can hold 10 and passes the paramters of the object which 
	 * is its current station and direction also has a passenger index to keep track of how many passengers there are
	 * Constant time O(1)
	 * @param currentStation
	 * @param direction
	 */
	public Train(String currentStation, int direction) {
		passengers = new Rider [TOTAL_PASSENGERS];
		this.currentStation = currentStation;
		this.direction = direction;
		this.passengerIndex = 0;
	}
	/**
	 * Returns the direction of the train
	 * Constant time O(1)
	 * @return the direction of the train
	 */
	public int getDirection() {
		return direction;
	}
	
	/**
	 * Sets the direction of the train which just swaps it with its current direction
	 * @param direc that the train will be heading
	 */
	public void setDirection(int direc) {
		direction = direc;
	}
	/**
	 * Returns a string of the current passengers on the train
	 * Constant time since this can only ever run 10 times which is the max amount of passengers allowed O(1)
	 * @return all passengers on train
	 */
	public String currentPassengers() {
		if(passengerIndex < 1) {
			return "";
		}
		String result = "" + passengers[0];
		for(int i = 1; i < passengers.length; i++) {
			if(passengers[i] != null) {
				result = result + "\n" + passengers[i];
			}
		}
		return result;
	}
	/**
	 * Adds a passenger to the train by first calling to the canAddPassenger and then finds an empty spot in the train
	 * if the passenger and the train are headed in the same direction and places the passenger in the first empty spot
	 * increases the passenger index as well
	 * Constant time since it will only run for a max of 10 times which is the max amount of passengers O(1)
	 * @param r, rider being added to the train
	 * @return true or false if the rider could be added
	 */
	public boolean addPassenger(Rider r) {
		if(canAddPassenger()) {	
			//checks if the rider is compatible with the train
			if(this.getStation().equals(r.getStarting()) && r.getDirection() == this.getDirection()) {
				//finds a spot for the rider on the train
				for(int i = 0; i < passengers.length; i++) {
					if(passengers[i] == null) {
						passengers[i] = r;
						passengerIndex ++;
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Checks if a passenger can be added which just checks if the train is already full or not 
	 * Constant time O(1)
	 * @return true or false
	 */
	public boolean canAddPassenger() {
		if(passengerIndex == TOTAL_PASSENGERS) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Loops through the train of passengers and checks if the passengers desired destination is where the train 
	 * currently is and if so removes the passenger from the train and returns a string of all passengers removed 
	 * and also decreases the passenger index
	 * O(n) linear run time
	 * @param s, station of train
	 * @return the removed passenger
	 */
	public String removePassenger(Station s) {
		String p = "";
		for(int i = 0; i < passengers.length;i++) {
			if(passengers[i] != null) {
				//checks if passenger is at their desired station
				if(passengers[i].getDestination() == s.stationName()) {
					//removes them from the train
					p = passengers[i].getRiderID() + ", " + s.stationName() + "\n";
					passengers[i] = null;
					passengerIndex--;
					return p;
				}
			}
		}
		//if this station was no passengers destination station
		return "";
	}
	/**
	 * Sets the station equal to the current station
	 * Constant time O(1)
	 * @param s
	 */
	public void updateStation(String s) {
		this.currentStation = s;
	}
	/**
	 * returns the current station
	 * Constant time O(1)
	 * @return
	 */
	public String getStation() {
		return currentStation;
	}
	/**
	 * Returns how many passengers are on the train and which station it is at and what direction it is headed
	 * Constant time O(1)
	 */
	public String toString() {
		String ns = "";
		if(direction == 0) {
			ns = "north";
		} else {
			ns = "south";
		}
		return "There are " + passengerIndex + " passengers. Currently at " + currentStation + " heading " + ns;
	}
}
