package org.rygn.nosqlbench.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rygn.nosqlbench.domain.MUserSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:mongodb-beans.xml"})
public class TestMongoDbDao {

	@Autowired
	private MongoDbDao mongoDbDao;
	
	@Before
	public void cleanAll() {
		
		this.mongoDbDao.deleteUserSelections();
	}
	
	@Test
	public void testAddUserSelection() {
		
		MUserSelection userSelection = new MUserSelection();
		
		userSelection.setEmail("rgirodon@sqli.com");
		
		userSelection.setFormation("4-3-3");
		
		userSelection.addGoalKeeper("Lloris");
		
		userSelection.addDefender("Debuchy");
		userSelection.addDefender("Varane");
		userSelection.addDefender("Sakho");
		userSelection.addDefender("Evra");
		
		userSelection.addMidfield("Pogba");
		userSelection.addMidfield("Cabaye");
		userSelection.addMidfield("Matuidi");
		
		userSelection.addForward("Valbuena");
		userSelection.addForward("Benzema");
		userSelection.addForward("Ribery");
				
		this.mongoDbDao.addUserSelection(userSelection);
		
		Collection<MUserSelection> userSelections = this.mongoDbDao.retrieveAllUserSelections();
		
		assertEquals(1, userSelections.size());
	}

	@Test
	public void testRetrieveUserSelectionForEmail() {
		
		MUserSelection userSelection = new MUserSelection();
		
		userSelection.setEmail("rgirodon@sqli.com");	
		
		userSelection.setFormation("4-3-3");
		
		userSelection.addGoalKeeper("Lloris");
		userSelection.addDefender("Debuchy");
		userSelection.addDefender("Varane");
		userSelection.addDefender("Sakho");
		userSelection.addDefender("Evra");
		
		userSelection.addMidfield("Pogba");
		userSelection.addMidfield("Cabaye");
		userSelection.addMidfield("Matuidi");
		
		userSelection.addForward("Valbuena");
		userSelection.addForward("Benzema");
		userSelection.addForward("Ribery");
				
		this.mongoDbDao.addUserSelection(userSelection);
		
		MUserSelection foundUserSelection = this.mongoDbDao.retrieveUserSelectionForEmail("rgirodon@sqli.com");
		
		assertEquals("4-3-3", foundUserSelection.getFormation());
		
		assertTrue(foundUserSelection.getDefenders().contains("Varane"));
	}
}
