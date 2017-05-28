package models;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This is an abstract class template for a single Member It is a subclass to
 * the Person class
 *
 * The details stored for a member include: - Member email - Member Name -
 * Member Address - Member Gender (M/F), if no input then it is set to
 * "Unspecified" - Member Height which is set in meters - Member Starting Weight
 * which is set in kgs - Methods for their chosen package (Premium/Student
 * Member)
 *
 * Along with the standard constructors, getters, setters and toString methods
 * listed below, there are specific methods that:
 *
 * - Returns the latest assessment by date - Returns the sorted set of
 * assessments by date - Returns a hashmap
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 */

public abstract class Member extends Person {

	// instance fields
	private double height;
	private double startingWeight;
	protected String chosenPackage;
	private HashMap<Date, Assessment> hashmap = new HashMap<>();

	/**
	 * Constructor for objects of the Member Class
	 *
	 * @param email
	 *            Members Email
	 * @param name
	 *            Members Name
	 * @param address
	 *            Members Address
	 * @param gender
	 *            Members Gender (M/F)
	 * @param height
	 *            Members Height (in meters)
	 * @param startingWeight
	 *            Members Starting Weight (in kgs)
	 */

	public Member(String email, String name, String address, String gender, double height, double startingWeight,
			String chosenPackage) {
		super(email, name, address, gender);

		if ((height >= 1) && (height <= 3))
			this.height = height;

		if ((startingWeight >= 35) && (startingWeight <= 250))
			this.startingWeight = startingWeight;

		this.chosenPackage = chosenPackage;
	}

	/**
	 *
	 * @return returns the latest Assessment
	 */
	public Assessment latestAssessment() {
		SortedSet<Date> assess = sortedAssessmentDates();
		Iterator<Date> it = assess.iterator();
		Object last = null;
		while (it.hasNext()) {// returns true if it has elements
			last = it.next();// returns next element
		}
		return hashmap.get(last);
	}

	/**
	 *
	 * @return returns sorted set by Date
	 */
	public SortedSet<Date> sortedAssessmentDates() {
		SortedSet<Date> sortedSet = new TreeSet<>();
		System.out.println(hashmap);
		sortedSet.addAll(hashmap.keySet());
		return sortedSet;
	}

	// -------
	// getters
	// -------

	/**
	 *
	 * @return returns the member's height
	 **/
	public double getHeight() {
		return height;
	}

	/**
	 *
	 * @return returns the member's starting weight
	 */
	public double getStartingWeight() {
		return startingWeight;
	}

	/**
	 *
	 * @returnn returns the member's chosen package
	 */
	public String getChosenPackage() {
		return chosenPackage;
	}

	/**
	 * 3
	 *
	 * @return returns the hashmap
	 */
	public HashMap<Date, Assessment> getHashMap() {
		return hashmap;
	}

	// -------
	// setters
	// -------

	/**
	 * Updates the member's height field.
	 *
	 * @param height
	 *            The member's height is measured in Meters. A minimum height of
	 *            one meter is allowed and a maximum height of three meters.
	 */
	public void setHeight(double height) {
		if ((height >= 1) && (height <= 3))
			this.height = height;

	}

	/**
	 * Updates the member starting weight field.
	 *
	 * @param startingWeight
	 *            The member's weight upon joining the gym (in kgs). A minimum
	 *            weight of 35kg and a max of 250kg is permitted in the gym.
	 */
	public void setStartingWeight(double startingWeight) {
		if ((startingWeight >= 35) && (startingWeight <= 250))
			this.startingWeight = startingWeight;

	}

	/**
	 * Sets the Members Chosen Package
	 *
	 * @param chosenPackage
	 *            Members chosen package - either Premium or Student
	 */
	public void setChosenPackage(String chosenPackage) {
		this.chosenPackage = chosenPackage;
	}

	/**
	 * Sets the Hashmap
	 *
	 * @param hashMap
	 *            Has a hashmap key of Date and a value of Assessment
	 */
	public void setHashMap(HashMap<Date, Assessment> hashMap) {
		this.hashmap = hashMap;
	}

	/**
	 *
	 * @param chosenPackage
	 *            Abstract method for chosen package
	 */
	public abstract void chosenPackage(String chosenPackage);

	/**
	 *
	 * @return User-friendly String representing the current Member
	 */
	@Override
	public String toString() {
		return super.toString() + "/ Height: " + height + "m" + "/ Starting Weight: " + startingWeight + "kg"
				+ "/ Chosen Package: " + chosenPackage;
	}

}
