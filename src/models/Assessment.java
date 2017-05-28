package models;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This is the Assessment class which stores: - The members weight - The members
 * chest - The members thigh - The members upper arm - The members waist - The
 * members hips - The members comment - Trainer that entered the members
 * assessment
 *
 * It also stores the standard constructors, getters, setters and toString
 * methods listed below, there are specific methods that: - Store the latest
 * assessment by date - Return the sorted assessments by date
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 */

public class Assessment {

	private Trainer trainer;
	private double weight;
	private double chest;
	private double thigh;
	private double upperArm;
	private double waist;
	private double hips;
	private HashMap<Date, Assessment> hashmap = new HashMap<>();
	private String comment;

	/**
	 * Constructor for objects of the Assessment class
	 *
	 * @param trainer
	 *            assessment trainer
	 * @param weight
	 *            assessment weight
	 * @param chest
	 *            assessment chest
	 * @param thigh
	 *            assessment thigh
	 * @param upperArm
	 *            assessment upperArm
	 * @param waist
	 *            assessment waist
	 * @param hips
	 *            assessment hips
	 * @param comment
	 *            assessment comment
	 */
	public Assessment(Trainer trainer, double weight, double chest, double thigh, double upperArm, double waist,
			double hips, String comment) {

		this.trainer = trainer;
		this.weight = weight;
		this.chest = chest;
		this.thigh = thigh;
		this.upperArm = upperArm;
		this.waist = waist;
		this.hips = hips;
		this.comment = comment;
	}
	// -------
	// getters
	// -------

	/**
	 * @return returns the trainer
	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * @return returns the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @return returns the chest
	 */
	public double getChest() {
		return chest;
	}

	/**
	 * @return returns the thigh
	 */
	public double getThigh() {
		return thigh;
	}

	/**
	 * @return returns the upperArm
	 */
	public double getUpperArm() {
		return upperArm;
	}

	/**
	 * @return returns the waist
	 */
	public double getWaist() {
		return waist;
	}

	/**
	 * @return returns the hips
	 */
	public double getHips() {
		return hips;
	}

	/**
	 *
	 * @return returns the hashmap
	 */
	public HashMap<Date, Assessment> getHashMap() {
		return hashmap;
	}

	/**
	 * @return returns the comment
	 */
	public String getComment() {
		return comment;
	}

	// -------
	// setters
	// -------

	/**
	 * @param trainer
	 *            the trainer to set
	 */
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**
	 * @param weight
	 *            the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @param chest
	 *            the chest to set
	 */
	public void setChest(double chest) {
		this.chest = chest;
	}

	/**
	 * @param thigh
	 *            the thigh to set
	 */
	public void setThigh(double thigh) {
		this.thigh = thigh;
	}

	/**
	 * @param upperArm
	 *            the upperArm to set
	 */
	public void setUpperArm(double upperArm) {
		this.upperArm = upperArm;
	}

	/**
	 * @param hips
	 *            the hips to set
	 */
	public void setHips(double hips) {
		this.hips = hips;
	}

	/**
	 * @param waist
	 *            the waist to set
	 */
	public void setWaist(double waist) {
		this.waist = waist;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 *
	 * @param hashMap
	 *            the hashmap to set
	 */
	public void setHashMap(HashMap<Date, Assessment> hashMap) {
		this.hashmap = hashMap;
	}

	/**
	 *
	 * @return latest assessment by date
	 */
	public Assessment latestAssessment() {
		SortedSet<Date> assess = sortedAssessmentDates();
		Iterator<Date> it = assess.iterator();
		Object last = null;
		while (it.hasNext()) {
			last = it.next();
		}
		return hashmap.get(last);
	}

	/**
	 *
	 * @return sorted assessment set by Date
	 */
	public SortedSet<Date> sortedAssessmentDates() {
		SortedSet<Date> sortedSet = new TreeSet<>();
		System.out.println(hashmap);
		sortedSet.addAll(hashmap.keySet());// Set object containing keys in HM
											// object
		return sortedSet;
	}

	/**
	 *
	 * @return User-friendly String representing the current Trainer assessment
	 */
	@Override
	public String toString() {
		return "Trainer: " + trainer + "Weight: " + weight + "/Chest: " + chest + "/Thigh: " + thigh + "/Upper Arm: "
				+ upperArm + "/Waist: " + waist + "/Hips: " + hips + "/Comment: " + comment;
	}

}
