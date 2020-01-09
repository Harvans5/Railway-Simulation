//Henry Arvans
//harvans5@brandeis.edu
//2/17/2019
//This class creates the riders, stations, and trains with the given information in the text files provided and then 
//Runs the simulate method in railway for the amount of hours provided as a final field 
package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MBTA {
	
	static final int HOURS = 3;
	static Scanner s;
	static Railway r = new Railway();
	/**
	 * Calls to all four static methods in the class
	 * Calls to multiple linear run time methods O(n)
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main (String[] args) throws FileNotFoundException {
		initiateStations("redline.txt");
		initiateRiders("riders.txt");
		initiateTrains("trains.txt");
		System.out.println("Begin Simulation");
		System.out.println("-----------------");
		runTrains(HOURS);
	}
	/**
	 * Loops through the simulate method in railway and prints out the string returned in that method
	 * Constant time since tics is HOURS passed through as a parameter which is set to a final of 6 O(1)
	 * @param tics how many times simulate will be called
	 */
	public static void runTrains(int tics) {
		for(int i = 1; i <= tics; i++) {
			System.out.println(r.simulate());
			System.out.println("-------------");
		}
	}
	/**
	 * Runs through the stations file and initiates stations with the given information
	 * Linear time O(n)
	 * @param filename of stations
	 * @throws FileNotFoundException
	 */
	public static void initiateStations(String filename) throws FileNotFoundException {
		s = new Scanner(new File(filename));
		while(s.hasNextLine()) {
			Station station = new Station(s.nextLine());
			r.addStation(station);
		}
		
	}
	/**
	 * Runs through the rider file and initiates riders with their given information
	 * Linear time O(n)
	 * @param filename of riders 
	 * @throws FileNotFoundException
	 */
	public static void initiateRiders(String filename) throws FileNotFoundException {
		s = new Scanner(new File(filename));
		while(s.hasNextLine()) {
			String riderID = s.nextLine();
			String startingStation = s.nextLine();
			String endDestination = s.nextLine();
			Rider rider = new Rider(riderID, startingStation, endDestination);
			r.addRider(rider);
		}
	}
	/**
	 * Runs through the train file and creates train objects for the given information
	 * Linear time O(n)
	 * @param filename of trains
	 * @throws FileNotFoundException
	 */
	public static void initiateTrains(String filename) throws FileNotFoundException {
		s = new Scanner(new File(filename));
		while(s.hasNextLine()) {
			String currentStation = s.nextLine();
			int direction = s.nextInt();
			Train train = new Train(currentStation, direction);
			r.addTrains(train);
			s.nextLine();
		}
	}
	
}

