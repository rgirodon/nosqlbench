package org.rygn.nosqlbench.cassandra;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rygn.nosqlbench.domain.PlayerMention;
import org.rygn.nosqlbench.domain.PlayerMentionPrimaryKey;
import org.rygn.nosqlbench.domain.Tactic;
import org.rygn.nosqlbench.domain.UserSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:cassandra-beans.xml"})
public class TestCassandraDao {

	@Autowired
	private CassandraDao cassandraDao;
	
	@Before
	public void cleanAll() {
		
		this.cassandraDao.deleteUserSelections();
		
		this.cassandraDao.deletePlayerMentions();
	}
	
	@Test
	public void testAddUserSelection() {
		
		UserSelection userSelection = new UserSelection();
		
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
				
		this.cassandraDao.addUserSelection(userSelection);
		
		Collection<UserSelection> userSelections = this.cassandraDao.retrieveAllUserSelections();
		
		assertEquals(1, userSelections.size());
	}

	@Test
	public void testRetrieveUserSelectionForEmail() {
		
		UserSelection userSelection = new UserSelection();
		
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
				
		this.cassandraDao.addUserSelection(userSelection);
		
		UserSelection foundUserSelection = this.cassandraDao.retrieveUserSelectionForEmail("rgirodon@sqli.com");
		
		assertEquals("4-3-3", foundUserSelection.getFormation());
		
		assertTrue(foundUserSelection.getDefenders().contains("Varane"));
	}
	
	@Test
	public void testAddPlayerMention() {
		
		PlayerMention playerMention = new PlayerMention();
		
		PlayerMentionPrimaryKey pk = new PlayerMentionPrimaryKey();
		pk.setPlayer("Lloris");
		pk.setSelectionerEmail("rgirodon@sqli.com");
		
		playerMention.setPk(pk);
		playerMention.setPosition("goalkeeper");
		
		this.cassandraDao.addPlayerMention(playerMention);
		
		Collection<PlayerMention> allPlayerMentions = this.cassandraDao.retrieveAllPlayerMentions();
		
		assertEquals(1, allPlayerMentions.size());
	}
	
	@Test
	public void testRetrievePlayerMentionsForPlayer() {
		
		PlayerMention playerMention = new PlayerMention();
		
		PlayerMentionPrimaryKey pk = new PlayerMentionPrimaryKey();
		pk.setPlayer("Lloris");
		pk.setSelectionerEmail("rgirodon@sqli.com");
		
		playerMention.setPk(pk);
		playerMention.setPosition("goalkeeper");
		
		this.cassandraDao.addPlayerMention(playerMention);
		
		Collection<PlayerMention> playerMentions = this.cassandraDao.retrievePlayerMentionsForPlayer("Lloris");
		
		assertEquals(1, playerMentions.size());
	}
	
	@Test
	public void testRetrievePlayerMentionForPlayerAndSelectioner() {
		
		PlayerMention playerMention = new PlayerMention();
		
		PlayerMentionPrimaryKey pk = new PlayerMentionPrimaryKey();
		pk.setPlayer("Lloris");
		pk.setSelectionerEmail("rgirodon@sqli.com");
		
		playerMention.setPk(pk);
		playerMention.setPosition("goalkeeper");
		
		this.cassandraDao.addPlayerMention(playerMention);
		
		PlayerMention foundPlayerMention = this.cassandraDao.retrievePlayerMentionForPlayerAndSelectioner("Lloris", "rgirodon@sqli.com");
		
		assertEquals("goalkeeper", foundPlayerMention.getPosition());
	}
}
