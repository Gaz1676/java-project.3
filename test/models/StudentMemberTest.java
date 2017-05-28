package models;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentMemberTest {

	private StudentMember pat, sue, jane;

	@Before
	public void setUp() throws Exception {

		pat = new StudentMember("pat@gmail.com", "PatsNameMakeUpThirtyCharacters", "waterford", "M", 1, 35, "S",
				"12345678", "WIT");// 30 characters - proper gender
		sue = new StudentMember("sue@gmail.com", "SuesNameMakeThirtyoneCharacters", "waterford", "F", 3, 250, "S",
				"87654321", "WIT");// 31 characters - lowercase letter
		jane = new StudentMember("jane@gmail.com", "TwentynineCharactersInHerName", "waterford", "Female", 0.9, 251,
				"s", "43218765", "WIT");// 29 characters - not M or F

	}

	@After
	public void tearDown() throws Exception {
	}

	// =================
	// Test Constructor
	// =================
	@Test
	public void testConstructor() {
		assertEquals("pat@gmail.com", pat.getEmail());
		assertEquals("PatsNameMakeUpThirtyCharacters", pat.getName());
		assertEquals("waterford", pat.getAddress());
		assertEquals("M", pat.getGender());
		assertEquals(1, pat.getHeight(), 0);
		assertEquals(35, pat.getStartingWeight(), 0);
		assertEquals("12345678", pat.getStudentId());
		assertEquals("WIT", pat.getCollegeName());
		assertEquals("S", pat.getChosenPackage());
	}

	// =============
	// Test Getters
	// =============
	@Test
	public void testGetEmail() throws Exception {
		assertEquals("pat@gmail.com", pat.getEmail());
		assertEquals("sue@gmail.com", sue.getEmail());
		assertEquals("jane@gmail.com", jane.getEmail());
	}

	@Test
	public void testGetName() throws Exception {
		assertEquals("PatsNameMakeUpThirtyCharacters", pat.getName());
		assertEquals("SuesNameMakeThirtyoneCharacter", sue.getName());
		assertEquals("TwentynineCharactersInHerName", jane.getName());
	}

	@Test
	public void getAddress() throws Exception {
		assertEquals("waterford", pat.getAddress());
		assertEquals("waterford", sue.getAddress());
		assertEquals("waterford", jane.getAddress());
	}

	@Test
	public void testGetGender() throws Exception {
		assertEquals("M", pat.getGender());
		assertEquals("F", sue.getGender());
		assertEquals("Unspecified", jane.getGender());
	}

	@Test
	public void testGetHeight() throws Exception {
		assertEquals(1, pat.getHeight(), 0);
		assertEquals(3, sue.getHeight(), 0);
		assertEquals(0, jane.getHeight(), 0);
	}

	@Test
	public void testGetStartingWeight() throws Exception {
		assertEquals(35, pat.getStartingWeight(), 0);
		assertEquals(250, sue.getStartingWeight(), 0);
		assertEquals(0, jane.getStartingWeight(), 0);
	}

	@Test
	public void testGetStudentId() throws Exception {
		assertEquals("12345678", pat.getStudentId());
		assertEquals("87654321", sue.getStudentId());
		assertEquals("43218765", jane.getStudentId());
	}

	@Test
	public void testGetCollegeName() throws Exception {
		assertEquals("WIT", pat.getCollegeName());
		assertEquals("WIT", sue.getCollegeName());
		assertEquals("WIT", jane.getCollegeName());
	}

	@Test
	public void testGetChosenPackage() throws Exception {
		assertEquals("S", pat.getChosenPackage());
		assertEquals("S", sue.getChosenPackage());
		assertEquals("s", jane.getChosenPackage());
	}

	// =============
	// Test Setters
	// =============

	@Test
	public void testSetEmail() throws Exception {
		pat.setEmail("jimmy@jmail.com");
		assertEquals("jimmy@jmail.com", pat.getEmail());
		sue.setEmail("stuart@smail.com");
		assertEquals("stuart@smail.com", sue.getEmail());
		jane.setEmail("jennifer@jen.com");
		assertEquals("jennifer@jen.com", jane.getEmail());
	}

	@Test
	public void testSetName() throws Exception {
		pat.setName("pats name");
		assertEquals("pats name", pat.getName());
		sue.setName("sues name");
		assertEquals("sues name", sue.getName());
		jane.setName("janes name");
		assertEquals("janes name", jane.getName());
	}

	@Test
	public void testSetAddress() throws Exception {
		pat.setAddress("dundalk");
		assertEquals("dundalk", pat.getAddress());
		sue.setAddress("washington dc");
		assertEquals("washington dc", sue.getAddress());
		jane.setAddress("west meath");
		assertEquals("west meath", jane.getAddress());
	}

	@Test
	public void testSetGender() throws Exception {
		pat.setGender("M");
		assertEquals("M", pat.getGender());
		sue.setGender("M");
		assertEquals("M", sue.getGender());
		jane.setGender("F");
		assertEquals("F", jane.getGender());
	}

	@Test
	public void testSetHeight() throws Exception {
		pat.setHeight(3.1);
		assertEquals(1, pat.getHeight(), 0);
		sue.setHeight(0.9);
		assertEquals(3.0, sue.getHeight(), 0);
		jane.setHeight(1.5);
		assertEquals(1.5, jane.getHeight(), 0);
	}

	@Test
	public void testSetStartingWeight() throws Exception {
		pat.setStartingWeight(34.9);
		assertEquals(35, pat.getStartingWeight(), 0);
		sue.setStartingWeight(250.1);
		assertEquals(250, sue.getStartingWeight(), 0);
		jane.setStartingWeight(60);
		assertEquals(60, jane.getStartingWeight(), 0);
	}

	@Test
	public void testSetStudentId() throws Exception {
		pat.setStudentId("12345678");
		assertEquals("12345678", pat.getStudentId());
		sue.setStudentId("87654321");
		assertEquals("87654321", sue.getStudentId());
		jane.setStudentId("43218765");
		assertEquals("43218765", jane.getStudentId());
	}

	@Test
	public void testSetCollegeName() throws Exception {
		pat.setCollegeName("UCD");
		assertEquals("UCD", pat.getCollegeName());
		sue.setCollegeName("UCC");
		assertEquals("UCC", sue.getCollegeName());
		jane.setCollegeName("CIT");
		assertEquals("CIT", jane.getCollegeName());
	}

	@Test
	public void testChosenPackage() throws Exception {
		pat.chosenPackage("s");
		assertEquals("Package 3", pat.getChosenPackage());
		sue.chosenPackage("S");
		assertEquals("Package 3", sue.getChosenPackage());
		jane.chosenPackage("p");
		assertEquals("Package 3", jane.getChosenPackage());
	}

	// ============
	// Test String
	// ============
	@Test
	public void testStudentToString() throws Exception {
		assertEquals(
				"Email: pat@gmail.com/ Name: PatsNameMakeUpThirtyCharacters/ Address: waterford/ Gender: M/ Height: 1.0m/ Starting Weight: 35.0kg/ Chosen Package: S/ Student Id: 12345678/ College Name: WIT",
				pat.toString());
		assertEquals(
				"Email: sue@gmail.com/ Name: SuesNameMakeThirtyoneCharacter/ Address: waterford/ Gender: F/ Height: 3.0m/ Starting Weight: 250.0kg/ Chosen Package: S/ Student Id: 87654321/ College Name: WIT",
				sue.toString());
		assertEquals(
				"Email: jane@gmail.com/ Name: TwentynineCharactersInHerName/ Address: waterford/ Gender: Unspecified/ Height: 0.0m/ Starting Weight: 0.0kg/ Chosen Package: s/ Student Id: 43218765/ College Name: WIT",
				jane.toString());
	}

}