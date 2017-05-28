package models;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AssessmentTest {

	private Assessment assessment1, assessment2, assessment3;
	private Trainer gary, leah, tom;

	@Before
	public void setUp() throws Exception {

		gary = new Trainer("gaz@gmail.com", "Gary", "wateford", "M", "Boxing");
		assessment1 = new Assessment(gary, 78, 30, 18, 14, 32, 34, "excellent work");

		leah = new Trainer("leah@gmail.com", "Leah", "waterford", "F", "KickBoxing");
		assessment2 = new Assessment(leah, 79, 31, 19, 15, 33, 35, "nice work");

		tom = new Trainer("tom@gmail.com", "Tom", "waterford", "M", "Running");
		assessment3 = new Assessment(tom, 80, 32, 20, 16, 34, 36, "must try harder");
	}

	@After
	public void tearDown() throws Exception {
	}

	// ============
	// Test Getters
	// ============
	@Test
	public void testGetWeight() throws Exception {
		assertEquals(78, assessment1.getWeight(), 0);
		assertEquals(79, assessment2.getWeight(), 0);
		assertEquals(80, assessment3.getWeight(), 0);
	}

	@Test
	public void testGetChest() throws Exception {
		assertEquals(30, assessment1.getChest(), 0);
		assertEquals(31, assessment2.getChest(), 0);
		assertEquals(32, assessment3.getChest(), 0);
	}

	@Test
	public void testGetThigh() throws Exception {
		assertEquals(18, assessment1.getThigh(), 0);
		assertEquals(19, assessment2.getThigh(), 0);
		assertEquals(20, assessment3.getThigh(), 0);
	}

	@Test
	public void testGetUpperArm() throws Exception {
		assertEquals(14, assessment1.getUpperArm(), 0);
		assertEquals(15, assessment2.getUpperArm(), 0);
		assertEquals(16, assessment3.getUpperArm(), 0);
	}

	@Test
	public void testGetWaist() throws Exception {
		assertEquals(32, assessment1.getWaist(), 0);
		assertEquals(33, assessment2.getWaist(), 0);
		assertEquals(34, assessment3.getWaist(), 0);
	}

	@Test
	public void testGetHips() throws Exception {
		assertEquals(34, assessment1.getHips(), 0);
		assertEquals(35, assessment2.getHips(), 0);
		assertEquals(36, assessment3.getHips(), 0);
	}

	@Test
	public void testGetComment() throws Exception {
		assertEquals("excellent work", assessment1.getComment());
		assertEquals("nice work", assessment2.getComment());
		assertEquals("must try harder", assessment3.getComment());
	}

	@Test
	public void testGetTrainer() throws Exception {
		assertEquals(gary, assessment1.getTrainer());
		assertEquals(leah, assessment2.getTrainer());
		assertEquals(tom, assessment3.getTrainer());
	}

	// =============
	// Test Setters
	// =============

	@Test
	public void testSetTrainer() throws Exception {
		assessment1.setTrainer(gary);
		assertEquals(gary, assessment1.getTrainer());
		assessment2.setTrainer(leah);
		assertEquals(leah, assessment2.getTrainer());
		assessment3.setTrainer(tom);
		assertEquals(tom, assessment3.getTrainer());
	}

	@Test
	public void testSetWeight() throws Exception {
		assessment1.setWeight(78);
		assertEquals(78, assessment1.getWeight(), 0);
		assessment2.setWeight(79);
		assertEquals(79, assessment2.getWeight(), 0);
		assessment3.setWeight(80);
		assertEquals(80, assessment3.getWeight(), 0);
	}

	@Test
	public void testSetChest() throws Exception {
		assessment1.setChest(30);
		assertEquals(30, assessment1.getChest(), 0);
		assessment2.setChest(31);
		assertEquals(31, assessment2.getChest(), 0);
		assessment3.setChest(32);
		assertEquals(32, assessment3.getChest(), 0);
	}

	@Test
	public void testSetThigh() throws Exception {
		assessment1.setThigh(18);
		assertEquals(18, assessment1.getThigh(), 0);
		assessment2.setThigh(19);
		assertEquals(19, assessment2.getThigh(), 0);
		assessment3.setThigh(20);
		assertEquals(20, assessment3.getThigh(), 0);
	}

	@Test
	public void testSetUpperArm() throws Exception {
		assessment1.setUpperArm(14);
		assertEquals(14, assessment1.getUpperArm(), 0);
		assessment2.setUpperArm(15);
		assertEquals(15, assessment2.getUpperArm(), 0);
		assessment3.setUpperArm(16);
		assertEquals(16, assessment3.getUpperArm(), 0);
	}

	@Test
	public void testSetWaist() throws Exception {
		assessment1.setWaist(32);
		assertEquals(32, assessment1.getWaist(), 0);
		assessment2.setWaist(33);
		assertEquals(33, assessment2.getWaist(), 0);
		assessment3.setWaist(34);
		assertEquals(34, assessment3.getWaist(), 0);
	}

	@Test
	public void testSetHips() throws Exception {
		assessment1.setHips(34);
		assertEquals(34, assessment1.getHips(), 0);
		assessment2.setHips(35);
		assertEquals(35, assessment2.getHips(), 0);
		assessment3.setHips(36);
		assertEquals(36, assessment3.getHips(), 0);
	}

	@Test
	public void testSetComment() throws Exception {
		assessment1.setComment("hello");
		assertEquals("hello", assessment1.getComment());
		assessment2.setComment("hello again");
		assertEquals("hello again", assessment2.getComment());
		assessment3.setComment("goodbye");
		assertEquals("goodbye", assessment3.getComment());
	}

	// ==============
	// Test ToString
	// ==============
	@Test
	public void testToString() throws Exception {

		assertEquals(
				"Trainer: Email: gaz@gmail.com/ Name: Gary/ Address: wateford/ Gender: M/Speciality: BoxingWeight: 78.0/Chest: 30.0/Thigh: 18.0/Upper Arm: 14.0/Waist: 32.0/Hips: 34.0/Comment: excellent work",
				assessment1.toString());

		assertEquals(
				"Trainer: Email: leah@gmail.com/ Name: Leah/ Address: waterford/ Gender: F/Speciality: KickBoxingWeight: 79.0/Chest: 31.0/Thigh: 19.0/Upper Arm: 15.0/Waist: 33.0/Hips: 35.0/Comment: nice work",
				assessment2.toString());

		assertEquals(
				"Trainer: Email: tom@gmail.com/ Name: Tom/ Address: waterford/ Gender: M/Speciality: RunningWeight: 80.0/Chest: 32.0/Thigh: 20.0/Upper Arm: 16.0/Waist: 34.0/Hips: 36.0/Comment: must try harder",
				assessment3.toString());
	}

}
