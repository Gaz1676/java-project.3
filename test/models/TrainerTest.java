package models;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrainerTest {

	private Trainer john, peg, ryan;

	@Before
	public void setUp() throws Exception {
		john = new Trainer("john@gmail.com", "JohnsNameHasThirtyCharacters!", "hamilton", "M", "kickboxing"); // 30
																												// characters
																												// -
																												// proper
																												// gender
		peg = new Trainer("peg@gmail.com", "PeggysNameMakesUpThirtyoneChars", "yorkshire", "f", "karate"); // 31
																											// characters
																											// -
																											// lowercase
																											// letter
		ryan = new Trainer("ryan@gmail.com", "RyanNameIsNotThirtyCharacters", "orlando", "Male", "swimming"); // 29
																												// characters
																												// -
																												// Not
																												// M
																												// or
																												// F
	}

	@After
	public void tearDown() throws Exception {
	}

	// =================
	// Test Constructor
	// =================

	@Test
	public void testConstructors() {
		assertEquals("john@gmail.com", john.getEmail());
		assertEquals("JohnsNameHasThirtyCharacters!", john.getName());
		assertEquals("hamilton", john.getAddress());
		assertEquals("M", john.getGender());
		assertEquals("kickboxing", john.getSpeciality());

		assertEquals("peg@gmail.com", peg.getEmail());
		assertEquals("PeggysNameMakesUpThirtyoneChar", peg.getName());
		assertEquals("yorkshire", peg.getAddress());
		assertEquals("F", peg.getGender());
		assertEquals("karate", peg.getSpeciality());

		assertEquals("ryan@gmail.com", ryan.getEmail());
		assertEquals("RyanNameIsNotThirtyCharacters", ryan.getName());
		assertEquals("orlando", ryan.getAddress());
		assertEquals("Unspecified", ryan.getGender());
		assertEquals("swimming", ryan.getSpeciality());
	}

	// =============
	// Test Getters
	// =============

	@Test
	public void testGetEmail() throws Exception {
		assertEquals("john@gmail.com", john.getEmail());
		assertEquals("peg@gmail.com", peg.getEmail());
		assertEquals("ryan@gmail.com", ryan.getEmail());
	}

	@Test
	public void testGetName() throws Exception {
		assertEquals("JohnsNameHasThirtyCharacters!", john.getName());
		assertEquals("PeggysNameMakesUpThirtyoneChar", peg.getName());
		assertEquals("RyanNameIsNotThirtyCharacters", ryan.getName());
	}

	@Test
	public void testGetAddress() throws Exception {
		assertEquals("hamilton", john.getAddress());
		assertEquals("yorkshire", peg.getAddress());
		assertEquals("orlando", ryan.getAddress());
	}

	@Test
	public void testGetGender() throws Exception {
		assertEquals("M", john.getGender());
		assertEquals("F", peg.getGender());
		assertEquals("Unspecified", ryan.getGender());
	}

	@Test
	public void testGetSpeciality() throws Exception {
		assertEquals("kickboxing", john.getSpeciality());
		assertEquals("karate", peg.getSpeciality());
		assertEquals("swimming", ryan.getSpeciality());
	}

	// =============
	// Test Setters
	// =============

	@Test
	public void testSetEmail() throws Exception {
		john.setEmail("gmail@gmail.com");
		assertEquals("gmail@gmail.com", john.getEmail());
		peg.setEmail("emailTester@gmail.com");
		assertEquals("emailTester@gmail.com", peg.getEmail());
		ryan.setEmail("bigLongTypeSetter@gmail.com");
		assertEquals("bigLongTypeSetter@gmail.com", ryan.getEmail());
	}

	@Test
	public void testSetName() throws Exception {
		john.setName("Set Johns Name");
		assertEquals("Set Johns Name", john.getName());
		peg.setName("ThisNameHasWayMoreCharactersThanThirty");
		assertEquals("ThisNameHasWayMoreCharactersThanThirty", peg.getName());
		ryan.setName("SoRyansNameHasThirtyCharacters");
		assertEquals("SoRyansNameHasThirtyCharacters", ryan.getName());
	}

	@Test
	public void testSetAddress() throws Exception {
		john.setAddress("Test and Set Johns Place");
		assertEquals("Test and Set Johns Place", john.getAddress());
		peg.setAddress("Test and Set Pegs Place");
		assertEquals("Test and Set Pegs Place", peg.getAddress());
		ryan.setAddress("Ryans has no limit");
		assertEquals("Ryans has no limit", ryan.getAddress());
	}

	@Test
	public void testSetGender() throws Exception {
		john.setGender("f");
		assertEquals("F", john.getGender());
		peg.setGender("Female");
		assertEquals("F", peg.getGender());
		ryan.setGender("M");
		assertEquals("M", ryan.getGender());
	}

	@Test
	public void testSetSpeciality() throws Exception {
		john.setSpeciality("speciality test");
		assertEquals("speciality test", john.getSpeciality());
		peg.setSpeciality("peggys test");
		assertEquals("peggys test", peg.getSpeciality());
		ryan.setSpeciality("ryans test");
		assertEquals("ryans test", ryan.getSpeciality());
	}

	// ============
	// Test String
	// ============

	@Test
	public void testToString() throws Exception {
		assertEquals(
				"Email: john@gmail.com/ Name: JohnsNameHasThirtyCharacters!/ Address: hamilton/ Gender: M/Speciality: kickboxing",
				john.toString());
		assertEquals(
				"Email: peg@gmail.com/ Name: PeggysNameMakesUpThirtyoneChar/ Address: yorkshire/ Gender: F/Speciality: karate",
				peg.toString());
		assertEquals(
				"Email: ryan@gmail.com/ Name: RyanNameIsNotThirtyCharacters/ Address: orlando/ Gender: Unspecified/Speciality: swimming",
				ryan.toString());
	}

}