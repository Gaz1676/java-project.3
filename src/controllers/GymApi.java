package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.Assessment;
import models.Member;
import models.Trainer;
import utils.Analytics;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class handles a collection of Arraylists for members and trainers
 *
 * Within this class are a number of methods:
 *       - Add members and trainers
 *       - Returns number of members and trainers
 *       - Gets members and trainers
 *       - IsValidIndex boolean of members and trainers
 *       - Search member and trainers by email
 *       - Search members by name
 *       - List String of Members, if none returns a response
 *       - ListMembersWithIdealWeight as a String
 *       - ListMembersBySpecificBMICategory as a String
 *       - ListMemberDetailsImperialAndMetric as a String
 *       - Save and Load list to an external XML file for further reference
 *
 * @author Gary Fleming 21/05/2017
 * @version 4.0
 *
 */
public class GymApi {

	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Trainer> trainers = new ArrayList<>();

	private Assessment assessment;

    /**
     * Adds a member to the list
     *
     * @param member member added to arraylist
     */
	public void addMember(Member member) {
		members.add(member);
	}

    /**
     * Adds a trainer to the list
     *
     * @param trainer trainer added to arraylist
     */
	public void addTrainer(Trainer trainer) {
		trainers.add(trainer);
	}

    /**
     *
     * @return returns the number of members
     */
	public int numberOfMembers() {
		return members.size();
	}

    /**
     *
     * @return returns the number of trainers
     */
	public int numberOfTrainers() {
		return trainers.size();
	}

    /**
     *
     * @return returns the members of the arraylist
     */
	public ArrayList<Member> getMembers() {
		return members;
	}

    /**
     *
     * @return returns the trainers of the arraylist
     */
	public ArrayList<Trainer> getTrainers() {
		return trainers;
	}

	/**
	 * Returns a boolean indicating if the index passed as a parameter is a
	 * valid index for the member’s array list.
	 *
	 * @param index
	 */
	public boolean isValidMemberIndex(int index) {
		return ((index >= 0) && (index < members.size()));
	}

	/**
	 * Returns a boolean indicating if the index passed as a parameter is a
	 * valid index for the trainer’s array list.
	 *
	 * @param index
	 */
	public boolean isValidTrainerIndex(int index) {
		return ((index >= 0) && (index < trainers.size()));
	}


	/**
	 * Returns the member object that matches the email entered. If no member
	 * matches, return null.
	 *
	 * @param emailEntered
	 */
	public Member searchMembersByEmail(String emailEntered) {
		Iterator<Member> it = members.iterator();
		Member member = null;
		Member memb;
		while (it.hasNext()) { //hasNext() returns true if the iterator for members has elements to view
			memb = it.next(); //next() returns the next element from the members iterator
			if (memb.getEmail().equals(emailEntered))
				member = memb;
		}
		return member;
	}

	/**
	 * Returns a list of members whose name partially or entirely matches the
	 * entered name. If there are no members in the gym, return a message
	 * indicating this. If there are members in the gym, but none match the name
	 * entered, return a message indicating this also.
	 *
	 * @param nameEntered
	 */
	public String searchMembersByName(String nameEntered) {
		Iterator<Member> it = members.iterator();
		String members = "";
		Member memb;
		while (it.hasNext()) {
			memb = it.next();
			if ( memb.getName().length() >= nameEntered.length() ) {
				if ((nameEntered).equalsIgnoreCase((memb.getName().substring( 0, nameEntered.length())))) members += memb.getName() + "\n";
			}
		}
		if (members.equals(""))
			return "\nThere are no Members by that name";
		return members;
	}

	/**
	 * Returns the trainer object that matches the email entered. If no trainer
	 * matches, return null.
	 *
	 * @param emailEntered
	 * @return
	 */
	public Trainer searchTrainersByEmail(String emailEntered) {
		Iterator <Trainer> it = trainers.iterator();
		Trainer trainer = null;
		Trainer trnr;
		while (it.hasNext()) {
			trnr = it.next();
			if ( trnr.getEmail().equals(emailEntered) ) trainer = trnr;
		}
		return trainer;
	}

	/**
	 *  Returns a String representing all the members stored in the gym collection.
	 *
	 *  @return String representing all the members stored in the gym collection.  The String returned is similar to this structure,
	 *  with the preceding number representing the index number of the member within the collection:
	 *
	 *
	 *    0: member's toString() format
	 *    1: member's toString() format
	 *    2: member's toString() format
	 *
	 */
	public String listMembers() {
        if (members.size() > 0){
            String listOfMembers = "";
            for (int i = 0; i < numberOfMembers(); i++){
                listOfMembers += i + ": " + members.get(i) + "\n";
            }
            return listOfMembers;
        }
        else{
            return "\nThere are no Members in the gym";
        }
	}

	/**
	 * List all the members that have an ideal starting weight.
	 *
	 * @return The list of members (i.e. use the toString method here) that have an ideal starting weight based on the
	 * devine method.
	 *
	 *
	 * If there are no members with an ideal starting weight, the message
	 *      "There are no members in the gym with an ideal weight" should be returned.
	 *
	 * If there are no members in the gym, the message
	 *      "There are no members in the gym" should be returned.
	 */
	public String listMembersWithIdealWeight(){
		if (members.size() > 0){
			String listOfMembers = "";
			for (Member member: members){

				if (Analytics.isIdealBodyWeight(member, assessment)){
					listOfMembers += member.toString() + "\n";
				}
			}
			if (listOfMembers.equals("")){
				return "\nNo Members with an Ideal Body Weight";
			}

			return listOfMembers;
		}
		else{
			return "\nThere are no Members in the gym";
		}
	}

	/**
	 * List all the members of a specific BMI category.
	 *
	 * @param category - The category you wish to search members by.
	 *
	 *
	 * The specific categories are:
	 *     "VERY SEVERELY UNDERWEIGHT"
	 *     "SEVERELY UNDERWEIGHT"
	 *     "UNDERWEIGHT"
	 *     "NORMAL"
	 *     "OVERWEIGHT"
	 *     "MODERATELY OBESE"
	 *     "SEVERELY OBESE"
	 *     "VERY SEVERELY OBESE"
	 *
	 * This method also allows you to search by key words e.g. "OBESE" will return members in the following categories:
	 *     "MODERATELY OBESE"
	 *     "SEVERELY OBESE"
	 *     "VERY SEVERELY OBESE"
	 * Note:  In this situation, the members are NOT sorted by category, they are just displayed as is.
	 *
	 *
	 * @return The list of members whose BMI falls into the category passed as a parameter.
	 *
	 * If there are no members in the BMI category, the message
	 *      "There are no members in the gym in this BMI category" should be returned.
	 *
	 * If there are no members in the gym, the message
	 *      "There are no members in the gym" should be returned.
	 */
	public String listMembersBySpecificBMICategory(String category){
		if (members.size() > 0){
			String listOfMembers = "";
			for (Member member: members){
				if (Analytics.determineBMICategory(Analytics.calculateBMI(member, assessment)).toUpperCase().contains(category.toUpperCase())){
					listOfMembers += member.toString() + "\n";
				}
			}
			if (listOfMembers.equals("")){
				return "\nNo Members in this BMI category";
			}
			return listOfMembers;
		}
		else{
			return "\nThere are no Members in the gym";
		}
	}

	/**
	 * List all the members' weight and height both imperically and metrically.
	 *
	 * @return Each member in the gym with the weight and height listed both imperically and metrically.
	 *
	 * The format of the output is like so:
	 *
	 *     Joe Soap:     xx kg (xxx lbs)     x.x metres (xx inches).
	 *     Joan Soap:    xx kg (xxx lbs)     x.x metres (xx inches).
	 *
	 * If there are no members in the gym, the message
	 *      "There are no members in the gym" should be returned.
	 */
	public String listMemberDetailsImperialAndMetric(){
		if (members.size() > 0){
			String listOfMembers = "";
			for (Member member: members){
				listOfMembers += member.getName() + ":\t\t"
						+ member.getStartingWeight() + " kg ("
						+ Analytics.convertWeightKGtoPounds(member,assessment) + " lbs)\t\t"
						+ member.getHeight() + " metres ("
						+ Analytics.convertHeightMetresToInches(member, assessment) + " inches)."
						+ "\n";
			}
			return listOfMembers;
		}
		else{
			return "\nThere are no Members in the gym.";
		}
	}

	//Saves data for the gym into an xml file
	public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream
                (new FileWriter("gym.xml"));
        out.writeObject(members);
        out.writeObject(trainers);
        out.close();
    }

    //Loads data for the gym from an xml file
    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream
                (new FileReader("gym.xml"));
        members = (ArrayList<Member>) is.readObject();
        trainers = (ArrayList<Trainer>) is.readObject();
        is.close();
    }

}
