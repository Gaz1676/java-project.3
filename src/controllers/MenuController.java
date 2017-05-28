package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Assessment;
import models.Member;
import models.PremiumMember;
import models.StudentMember;
import models.Trainer;

/**
 * This class controls the MenuController.
 *
 * It displays the following basic menu for the Gym and processes the user
 * input. ------------ Welcome Menu ------------ Gives the user the options to:
 * 1) Login 2) Register
 *
 * -------------------------------------------------------- If the user decides
 * to login they are asked are they a: 1) Member (prompted to enter valid member
 * email) 2) Trainer (prompted to enter a valid trainer email)
 * ---------------------------------------------------------
 *
 * If register the user is asked do they want to register as a: 1) Member 2)
 * Trainer
 *
 *
 * If member the user must enter the following information: 1) Email address 2)
 * Name 3) Address 4) Gender (M/F) 5) Height (in meters) 6) Starting Weight (in
 * kgs) ===========================
 *
 * If trainer the user must enter the following information: 1) Email address 2)
 * Name 3) Address 4) Gender (M/F) 5) Speciality ===============
 *
 * If Member the user is sent to the Member menu ------------- Member Menu
 * ------------- 1) View profile 2) Update profile 0) Exit =================
 *
 * If Trainer the user is sent to the Trainer menu ------------ Trainer Menu
 * ------------ 1) Add a new member 2) List of all members 3) Search for a
 * member (by email) 4) Search for a member (by name) 0) Exit
 * ---------------------------------
 *
 * @author Gary Fleming
 * @version 4.0
 *
 */

public class MenuController {

	private Scanner input;
	private GymApi gym;
	private Member memb;
	private Trainer trainer;

	public static void main(String[] args) {
		MenuController app = new MenuController();
		app.mainMenu();
	}

	/**
	 * mainMenu() - This displays the menu welcome screen. It is here where you
	 * can login or register as a member or trainer.
	 */

	private void mainMenu() {
		gym = new GymApi();

		try {
			gym.load();
		} catch (Exception e) {
			System.err.println("Error reading from file: " + e);
		}

		input = new Scanner(System.in);
		String option;
		String login;

		while (true) {
			System.out.println("+----------------------------+");
			System.out.println("| HELLO & WELCOME TO THE GYM |");
			System.out.println("|----------------------------|");
			System.out.println("|    ~~ Login Press [L] ~~   |");
			System.out.println("| ~~~ Register Press [R] ~~~ |");
			System.out.println("+____________________________+");
			option = input.next(); // gets next string option user types in

			if ("L".equalsIgnoreCase(option)) {
				System.out.println("\n+----------------------------+");
				System.out.println("|           LOG IN           |");
				System.out.println("|----------------------------|");
				System.out.println("|    As a Member Press[M]    |");
				System.out.println("|   As a Trainer Press [T]   |");
				System.out.println("+____________________________+");
				option = input.next();

				if ("M".equalsIgnoreCase(option)) {
					System.out.print("\nEnter your email: ");
					login = input.next();

					if (gym.searchMembersByEmail(login) != null) {
						memb = gym.searchMembersByEmail(login);
						System.out.println("\n Welcome Back " + memb.getName());
						memberLogged();
					} else {
						System.out.println(">>>>>>>  Access Denied <<<<<<<");
						System.out.println("       Please Try Again!    \n");
						mainMenu();
					}
				}
				if ("T".equalsIgnoreCase(option)) {
					System.out.print("Enter your email: ");
					login = input.next();

					if (gym.searchTrainersByEmail(login) != null) {

						trainer = gym.searchTrainersByEmail(login);
						System.out.println("\n Welcome Back " + trainer.getName());
						trainerLogged();

					} else {
						System.out.println(">>>>>>>  Access Denied <<<<<<<");
						System.out.println("       Please Try Again!    \n");
						mainMenu();
					}
				}
			}
			if ("R".equalsIgnoreCase(option)) {
				System.out.println("\n+----------------------------+");
				System.out.println("|          REGISTER          |");
				System.out.println("+----------------------------+");
				System.out.println("|    As a Member Press[M]    |");
				System.out.println("|   As a Trainer Press [T]   |");
				System.out.println("+____________________________+");
				option = input.next();

				if ("M".equalsIgnoreCase(option)) {
					addMember();
					try {
						gym.load();
					} catch (Exception e) {
						System.err.println("Error reading from file: " + e);
					}
				}

				if ("T".equalsIgnoreCase(option)) {
					addTrainer();
					try {
						gym.load();
					} catch (Exception e) {
						System.err.println("Error reading from file: " + e);
					}
				}
			}
		}
	}

	// Displays the options when the member is logged in
	private void memberLogged() {
		while (true) {
			System.out.println("\n+------------------------------+");
			System.out.println("|          MEMBER MENU         |");
			System.out.println("+------------------------------+");
			System.out.println("|1) To View profile            |");
			System.out.println("|2) To Update profile          |");
			System.out.println("+------------------------------+");
			System.out.println("|     PROGRESS SUB MENU        |");
			System.out.println("+------------------------------+");
			System.out.println("|3) By Weight                  |");
			System.out.println("| 4) By Chest Measurement      |");
			System.out.println("|  5) By Thigh Measurement     |");
			System.out.println("|   6) By UpperArm Measurement |");
			System.out.println("|    7) By Waist               |");
			System.out.println("|     8) By Hips               |");
			System.out.println("|      0) Exit	      	       |");
			System.out.println("+______________________________+");
			System.out.println("");

			int option = input.nextInt();

			List<String> list = new ArrayList<>();
			Map<Date, Assessment> map = memb.getHashMap();

			switch (option) {
			case 1:
				System.out.println(memb.toString());
				break;
			case 2:
				changeProfile();
				break;
			case 3:
				for (Date d : map.keySet()) {// iterates through the key value
												// date
					list.add(Double.toString(map.get(d).getWeight()));
				}
				System.out.println("Weight: " + list.toString());
				break;
			case 4:
				for (Date d : map.keySet()) {
					list.add(Double.toString(map.get(d).getChest()));
				}
				System.out.println("Chest: " + list.toString());
				break;
			case 5:
				for (Date d : map.keySet()) {
					list.add(Double.toString(map.get(d).getThigh()));
				}
				System.out.println("Thigh: " + list.toString());
				break;
			case 6:
				for (Date d : map.keySet()) {
					list.add(Double.toString(map.get(d).getUpperArm()));
				}
				System.out.println("Upper Arm: " + list.toString());
				break;
			case 7:
				for (Date d : map.keySet()) {
					list.add(Double.toString(map.get(d).getWaist()));
				}
				System.out.println("Waist: " + list.toString());
				break;
			case 8:
				for (Date d : map.keySet()) {
					list.add(Double.toString(map.get(d).getHips()));
				}
				System.out.println("Hips: " + list.toString());
				break;
			case 0:
				System.out.println("    Take care " + memb.getName());
				System.out.println("    Keep up the great work!!\n");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return;
			default:
				System.err.println("Invalid Option");
			}
			System.out.println("\nPress Enter to return to menu...");
			input.nextLine();
			input.nextLine();
		}
	}

	// Lets member update their profile
	private void changeProfile() {
		gym.members.remove(memb);
		addMember();
	}

	// Displays the options when a trainer is logged in
	private void trainerLogged() {
		while (true) {
			System.out.println("\n+-----------------------------+");
			System.out.println("|        TRAINER MENU         |");
			System.out.println("+-----------------------------+");
			System.out.println("|1) Add new Member            |");
			System.out.println("| 2) List of all Members      |");
			System.out.println("|  3) Search Member by email  |");
			System.out.println("|   4) Search Member by name  |");
			System.out.println("|    5) Members with IBW      |");
			System.out.println("|     6) Members BMI Category |");
			System.out.println("|      7) Add Assessment      |");
			System.out.println("|       0) Exit				  |");
			System.out.println("+_____________________________+");
			int option = input.nextInt();

			switch (option) {
			case 1:
				addMember();
				break;
			case 2:
				System.out.println("List of gym Members: \n");
				System.out.println(gym.listMembers());
				break;
			case 3:
				System.out.println("Members by email: \n");
				searchMemberEmail();
				break;
			case 4:
				searchMemberName();
				break;
			case 5:
				System.out.println("Members with Ideal Body Weight: \n");
				System.out.println(gym.listMembersWithIdealWeight());
				break;
			case 6:
				searchMemberBMI();
				break;
			case 7:
				System.out.println("Adding Member Assessment: \n");
				addAssessment();
				break;
			case 0:
				System.out.println("    See you soon " + trainer.getName() + "\n");
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return;
			default:
				System.out.println("Invalid Option");
			}

			System.out.println("\nPress Enter to return to menu...");
			input.nextLine();
			input.nextLine();
		}
	}

	// Lets the trainer add assessments of the members
	private void addAssessment() {

		System.out.print("Enter Members email: ");
		String email = input.next();

		if (gym.searchMembersByEmail(email) != null) {
			System.out.println("\n+-----------------------------+");
			System.out.println("|   Enter Assessment details  |");
			System.out.println("+-----------------------------+");

			double weight;
			double chest;
			double thigh;
			double upperArm;
			double waist;
			double hips;
			String comment;

			System.out.print("1) Weight: ");
			weight = Double.parseDouble(input.next());// returns a primitive
														// double type

			System.out.print("2) Chest: ");
			chest = Double.parseDouble(input.next());

			System.out.print("3) Thigh: ");
			thigh = Double.parseDouble(input.next());

			System.out.print("4) Upper Arm: ");
			upperArm = Double.parseDouble(input.next());

			System.out.print("5) Waist: ");
			waist = Double.parseDouble(input.next());

			System.out.print("6) Hips: ");
			hips = Double.parseDouble(input.next());

			System.out.print("7) Comments: ");
			comment = input.nextLine();
			input.nextLine();
			gym.searchMembersByEmail(email).getHashMap().put(new Date(),
					new Assessment(trainer, weight, chest, thigh, upperArm, waist, hips, comment));
		} else {
			System.out.println("There is no user with such email");
		}
		try {
			gym.save();
		} catch (Exception e) {
			System.err.println("Error writing to file: " + e);
		}
	}

	// Adds a new member to the xml file
	private void addMember() {
		String option;
		String email;
		String chosenPackage;

		System.out.print("Enter email: ");
		option = input.next();
		while (gym.searchMembersByEmail(option) != null) {
			System.out.println("This email is used. Try Again!!");
			input.nextLine();
		}
		email = option;

		System.out.print("Enter name: ");
		String name = input.nextLine();
		name = input.nextLine();

		System.out.print("Enter address: ");
		String address = input.nextLine();

		System.out.print("Enter gender (M/F): ");
		String gender = input.nextLine();

		double height = 0;
		boolean goodInput = false;
		do {
			try {
				System.out.print("Enter height (in meters): ");
				height = input.nextDouble();
				goodInput = true;
			} catch (Exception e) {
				input.nextLine();
				System.err.println("\tEnter a a valid number please.");
			}
		} while (!goodInput);

		double startingWeight = 0;
		goodInput = false;
		do {
			try {
				System.out.print("Enter weight (in kgs): ");
				startingWeight = input.nextDouble();
				goodInput = true;
			} catch (Exception e) {
				input.nextLine();
				System.err.println("\tEnter a number please.");
			}
		} while (!goodInput);

		System.out.println("+---------------------+");
		System.out.println("| Choose your Package |");
		System.out.println("+---------------------+");
		System.out.println("|   'P' for Premium   |");
		System.out.println("|   'S' for Student   |");
		System.out.println("+---------------------+");
		System.out.print(">>");
		option = input.next();
		chosenPackage = option;

		if (!"p".equalsIgnoreCase(option) || !"s".equalsIgnoreCase(option)) {
			if ("p".equalsIgnoreCase(option)) {
				gym.addMember(new PremiumMember(email, name, address, gender, height, startingWeight, chosenPackage));

				try {
					gym.save();
				} catch (Exception e) {
					System.err.println("Error writing to file: " + e);
				}
				System.out.println("You now have a Premium Member Account");
				System.out.println("\nPress Enter to return to Login Screen...");
				input.nextLine();
				input.nextLine();
				// display the main menu again
				mainMenu();

			} else if ("S".equalsIgnoreCase(option)) {
				System.out.print("Enter your Student ID: ");
				option = input.next();
				String studID = option;
				System.out.print("Enter your College Name: ");
				option = input.next();
				String collegeName = option;
				gym.addMember(new StudentMember(email, name, address, gender, height, startingWeight, chosenPackage,
						studID, collegeName));

				try {
					gym.save();
				} catch (Exception e) {
					System.err.println("Error writing to file: " + e);
				}
				System.out.println("\nYou now have a Student Member Account");
				System.out.println("\nPress Enter to return to Login Screen...");
				input.nextLine();
				input.nextLine();
				// display the main menu again
				mainMenu();
			}

			System.out.println(">>>>>>>  INVALID INPUT <<<<<<<");
			System.out.println("       Please Try Again!    \n");
			// return;
		}
	}

	// Adds a new trainer to the xml file
	private void addTrainer() {
		String option;
		String email;

		System.out.print("Enter email: ");
		option = input.next();
		while (gym.searchTrainersByEmail(option) != null) {
			System.out.println("This email is used. Try Again!!");
			input.nextLine();
		}
		email = option;

		System.out.print("Enter name: ");
		String name = input.nextLine();
		name = input.nextLine();

		System.out.print("Enter address: ");
		String address = input.nextLine();

		System.out.print("Enter gender (M/F): ");
		String gender = input.nextLine();

		System.out.print("Enter speciality: ");
		String speciality = input.nextLine();

		gym.addTrainer(new Trainer(email, name, address, gender, speciality));

		try {
			gym.save();
		} catch (Exception e) {
			System.err.println("Error writing to file: " + e);
		}

		System.out.println("\nYou now have a Trainer Account");
		System.out.println("\nPress Enter to return to Login Screen...");
		input.nextLine();
		input.nextLine();
		// display the main menu again
		mainMenu();
	}

	// Lets trainer search for members by email
	private void searchMemberEmail() {
		System.out.print("Enter email: ");
		String email = input.next();
		while (true) {
			if (gym.searchMembersByEmail(email) != null) {
				System.out.println(gym.searchMembersByEmail(email).toString());
				break;
			}
			System.out.println("There is no member with that email!!");
			break;
		}
	}

	// Lets trainer search for members by name
	private void searchMemberName() {
		System.out.print("Enter name: ");
		String name = input.next();
		while (true) {
			if (gym.searchMembersByName(name) != null) {
				System.out.println("\nMember: " + gym.searchMembersByName(name));
				break;
			}
		}
	}

	// Searches the list of members BMI's
	private void searchMemberBMI() {
		System.out.println("\n+----------------------------------+");
		System.out.println("|     Please type in a Category    |");
		System.out.println("+----------------------------------+");
		System.out.println("| VERY SEVERELY OBESE              |");
		System.out.println("|  SEVERELY OBESE                  |");
		System.out.println("|   MODERATELY OBESE               |");
		System.out.println("|    OVERWEIGHT                    |");
		System.out.println("|     NORMAL                       |");
		System.out.println("|      UNDERWEIGHT                 |");
		System.out.println("|       SEVERELY UNDERWEIGHT       |");
		System.out.println("|        VERY SEVERELY UNDERWEIGHT |");
		System.out.println("+----------------------------------+");
		System.out.print(">>");
		String category = input.next();

		if (gym.listMembersBySpecificBMICategory(category) != null) {
			System.out.println(gym.listMembersBySpecificBMICategory(category));
		}
	}
}
