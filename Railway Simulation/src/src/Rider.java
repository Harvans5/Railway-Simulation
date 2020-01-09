//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//Rider class creates a rider which holds an ID, starting destination and desired destination
package src;
public class Rider {
	 String riderID;
	 String startingStation;
	 String destinationStation;
	 int direction;
	/**
	 * Constructor for the rider class creates a rider with an ID, start and end locations
	 * Constant time O(1)
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
	}
	/**
	 * Returns the starting location of the rider
	 * Constant time O(1)
	 * @return
	 */
	public String getStarting() {
		return startingStation;
	}
	/**
	 * Constant time O(1)
	 * @return Returns their desired end location
	 */
	public String getDestination() {
		return destinationStation;
	}
	/**
	 * Constant time O(1)
	 * @return returns the riderID
	 */
	public String getRiderID() {
		return riderID;
	}
	/**
	 * Constant time O(1)
	 * @return Returns the direction they are heading
	 */
	public int getDirection() {
		return direction;
	}
	/**
	 * Sets the direction they should be heading
	 * Constant time O(1) 
	 * @param direc
	 */
	public void setDirection(int direc) {
		direction = direc;
	}
	/**
	 * Returns their ID end destination and the direction they are heading 
	 * Constant time O(1)
	 */
	public String toString() {
		String ns = "";
		if(direction == 0) {
			ns = "north";
		} else {
			ns = "south";
		}
		return riderID + " is headed " + ns + " to " + destinationStation;
	}
	/**
	 * Checks if two riders have the same riderID
	 * Constant time O(1)
	 */
	public boolean equals(Object s) {
		if(s instanceof Rider) {
			Rider sNew = (Rider) s;
			if(sNew.riderID.equals(this.riderID)) {
				return true;
			}
		}
		return false;
	}
}
