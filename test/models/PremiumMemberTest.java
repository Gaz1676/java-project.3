package models;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PremiumMemberTest {

	private PremiumMember peter, chris, toni;

	@Before
	public void setUp() throws Exception {

		peter = new PremiumMember("peter@gmail.com", "peter", "waterford", "M", 0.9, 34, "P");
		chris = new PremiumMember("chris@gmail.com", "chris", "wexford", "m", 3.1, 251, "P");
		toni = new PremiumMember("toni@gmail.com", "toni", "new york", "Female", 1.50, 78, "P");

	}

	@After
	public void tearDown() throws Exception {
	}

	// =================
	// Test Constructor
	// =================
	@Test
	public void testConstructor() {
		assertEquals("peter@gmail.com", peter.getEmail());
		assertEquals("peter", peter.getName());
		assertEquals("waterford", peter.getAddress());
		assertEquals("M", peter.getGender());
		assertEquals(0, peter.getHeight(), 0);
		assertEquals(0, peter.getStartingWeight(), 0);

		assertEquals("chris@gmail.com", chris.getEmail());
		assertEquals("chris", chris.getName());
		assertEquals("wexford", chris.getAddress());
		assertEquals("M", chris.getGender());
		assertEquals(0, chris.getHeight(), 0);
		assertEquals(0, chris.getStartingWeight(), 0);

		assertEquals("toni@gmail.com", toni.getEmail());
		assertEquals("toni", toni.getName());
		assertEquals("new york", toni.getAddress());
		assertEquals("Unspecified", toni.getGender());
		assertEquals(1.50, toni.getHeight(), 0);
		assertEquals(78, toni.getStartingWeight(), 0);
	}

	// =============
	// Test Getters
	// =============
	@Test
	public void testGetEmail() throws Exception {
		assertEquals("peter@gmail.com", peter.getEmail());
		assertEquals("chris@gmail.com", chris.getEmail());
		assertEquals("toni@gmail.com", toni.getEmail());
	}

	@Test
	public void testGetName() throws Exception {
		assertEquals("peter", peter.getName());
		assertEquals("chris", chris.getName());
		assertEquals("toni", toni.getName());
	}

	@Test
	public void testGetAddress() throws Exception {
		assertEquals("waterford", peter.getAddress());
		assertEquals("wexford", chris.getAddress());
		assertEquals("new york", toni.getAddress());
	}

	@Test
	public void testGetGender() throws Exception {
		assertEquals("M", peter.getGender());
		assertEquals("M", chris.getGender());
		assertEquals("Unspecified", toni.getGender());
	}

	@Test
	public void testGetHeight() throws Exception {
		assertEquals(0, peter.getHeight(), 0);
		assertEquals(0, chris.getHeight(), 0);
		assertEquals(1.50, toni.getHeight(), 0);
	}

	@Test
	public void testGetStartingWeight() throws Exception {
		assertEquals(0, peter.getStartingWeight(), 0);
		assertEquals(0, chris.getStartingWeight(), 0);
		assertEquals(78, toni.getStartingWeight(), 0);
	}

	@Test
	public void testGetChosenPackage() throws Exception {
		assertEquals("P", peter.getChosenPackage());
		assertEquals("P", chris.getChosenPackage());
		assertEquals("P", toni.getChosenPackage());
	}

	// =============
	// Test Setters
	// =============
	@Test
	public void testSetEmail() throws Exception {
		peter.setEmail("email@gmail.com");
		assertEquals("email@gmail.com", peter.getEmail());
		chris.setEmail("chris@gmail.com");
		assertEquals("chris@gmail.com", chris.getEmail());
		toni.setEmail("toni@gmail.com");
		assertEquals("toni@gmail.com", toni.getEmail());
	}

	@Test
	public void testSetName() throws Exception {
		peter.setName("peter");
		assertEquals("peter", peter.getName());
		chris.setName("chris");
		assertEquals("chris", chris.getName());
		toni.setName("toni");
		assertEquals("toni", toni.getName());
	}

	@Test
	public void testSetAddress() throws Exception {
		peter.setAddress("waterford");
		assertEquals("waterford", peter.getAddress());
		chris.setAddress("dublin");
		assertEquals("dublin", chris.getAddress());
		toni.setAddress("cork");
		assertEquals("cork", toni.getAddress());
	}

	@Test
	public void testSetGender() throws Exception {
		peter.setGender("M");
		assertEquals("M", peter.getGender());
		chris.setGender("m");
		assertEquals("M", chris.getGender());
		toni.setGender("f");
		assertEquals("F", toni.getGender());
	}

	@Test
	public void testSetHeight() throws Exception {
		peter.setHeight(2.99);
		assertEquals(2.99, peter.getHeight(), 0);
		chris.setHeight(1);
		assertEquals(1, chris.getHeight(), 0);
		toni.setHeight(2.8);
		assertEquals(2.8, toni.getHeight(), 0);
	}

	@Test
	public void testSetStartingWeight() throws Exception {
		peter.setStartingWeight(35);
		assertEquals(35, peter.getStartingWeight(), 0);
		chris.setStartingWeight(250);
		assertEquals(250, chris.getStartingWeight(), 0);
		toni.setStartingWeight(69.0);
		assertEquals(69, toni.getStartingWeight(), 0);
	}

	@Test
	public void testChosenPackage() throws Exception {
		peter.chosenPackage("Premium");
		assertEquals("Premium", peter.getChosenPackage());
		chris.chosenPackage("Premiumish");
		assertEquals("Premiumish", chris.getChosenPackage());
		toni.chosenPackage("Package 3");
		assertEquals("Package 3", toni.getChosenPackage());
	}

	// ==============
	// Test ToString
	// ==============

	@Test
	public void testToString() throws Exception {
		assertEquals(
				"Email: peter@gmail.com/ Name: peter/ Address: waterford/ Gender: M/ Height: 0.0m/ Starting Weight: 0.0kg/ Chosen Package: P",
				peter.toString());
		assertEquals(
				"Email: chris@gmail.com/ Name: chris/ Address: wexford/ Gender: M/ Height: 0.0m/ Starting Weight: 0.0kg/ Chosen Package: P",
				chris.toString());
		assertEquals(
				"Email: toni@gmail.com/ Name: toni/ Address: new york/ Gender: Unspecified/ Height: 1.5m/ Starting Weight: 78.0kg/ Chosen Package: P",
				toni.toString());
	}
}