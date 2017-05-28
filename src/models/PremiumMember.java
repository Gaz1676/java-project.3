package models;

/**
 * This is the Premium Member class which stores: - Members email - Members name
 * - Members address - Members gender - Members height - Members starting weight
 *
 * Also provides the concrete implementation for the chosen package method The
 * chosen package is set to the value passed as a parameter. There is no
 * validation on the entered data.
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 */

public class PremiumMember extends Member {
	/**
	 * Constructor for objects of the Member Class
	 *
	 * @param email
	 *            members Email
	 * @param name
	 *            members Name
	 * @param address
	 *            members Address
	 * @param gender
	 *            members Gender (M/F)
	 * @param height
	 *            members Height (in meters)
	 * @param startingWeight
	 *            members Starting Weight (in kgs)
	 */
	public PremiumMember(String email, String name, String address, String gender, double height, double startingWeight,
			String chosenPackage) {
		super(email, name, address, gender, height, startingWeight, chosenPackage);
	}

	/**
	 *
	 * @param chosenPackage
	 *            concrete implementation, set value passed as a parameter
	 */
	@Override
	public void chosenPackage(String chosenPackage) {
		this.chosenPackage = chosenPackage;
	}
}
