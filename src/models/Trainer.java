package models;

/**
 * This is the Trainer class which stores: - Trainers email - Trainers name -
 * Trainers address - Trainers gender (M/F) - Trainers speciality
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 */

public class Trainer extends Person {

	private String speciality;

	/**
	 * Constructor for objects of the Trainer class
	 *
	 * @param email
	 *            Trainers email
	 * @param name
	 *            Trainers Name
	 * @param address
	 *            Trainers Address
	 * @param gender
	 *            Trainers Gender (M/F)
	 * @param speciality
	 *            Trainers Speciality
	 */
	public Trainer(String email, String name, String address, String gender, String speciality) {
		super(email, name, address, gender);
		this.speciality = speciality;
	}

	// ------
	// getter
	// ------

	/**
	 *
	 * @return Trainers speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	// ------
	// setter
	// ------

	/**
	 * Set Trainers speciality
	 *
	 * @param speciality
	 *            Sets what the trainers speciality is
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	/**
	 *
	 * @return User-friendly String representing the current Trainer
	 */
	@Override
	public String toString() {
		return super.toString() + "/Speciality: " + speciality;
	}
}
