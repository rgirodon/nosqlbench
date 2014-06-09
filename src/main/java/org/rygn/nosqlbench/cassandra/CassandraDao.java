package org.rygn.nosqlbench.cassandra;

import java.util.Collection;

import org.rygn.nosqlbench.domain.PlayerMention;
import org.rygn.nosqlbench.domain.UserSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

@Repository
public class CassandraDao {

	@Autowired
	@Qualifier("cassandraTemplate")
	private CassandraOperations cassandraOperations;
	
	public void addUserSelection(UserSelection userSelection) {
		
		this.cassandraOperations.insert(userSelection);
	}
	
	public void addPlayerMention(PlayerMention playerMention) {
		
		this.cassandraOperations.insert(playerMention);
	}
	
	public Collection<PlayerMention> retrievePlayerMentionsForPlayer(String player) {
		
		Select select = QueryBuilder.select().from("player_mention");
		select.where(QueryBuilder.eq("player", player));
		
		return this.cassandraOperations.select(select, PlayerMention.class);
	}
	
	public PlayerMention retrievePlayerMentionForPlayerAndSelectioner(String player, String selectioner) {
		
		Select select = QueryBuilder.select().from("player_mention");
		select.where(QueryBuilder.eq("player", player));
		select.where(QueryBuilder.eq("selectioner_email", selectioner));
		
		return this.cassandraOperations.selectOne(select, PlayerMention.class);
	}
	
	public Collection<UserSelection> retrieveAllUserSelections() {
		
		return this.cassandraOperations.selectAll(UserSelection.class);
	}
	
	public Collection<PlayerMention> retrieveAllPlayerMentions() {
		
		return this.cassandraOperations.selectAll(PlayerMention.class);
	}
	
	public UserSelection retrieveUserSelectionForEmail(String email) {
		
		Select select = QueryBuilder.select().from("user_selection");
		select.where(QueryBuilder.eq("email", email));
		
		return this.cassandraOperations.selectOne(select, UserSelection.class);
	}

	public void deleteUserSelections() {
		
		this.cassandraOperations.truncate("user_selection");
	}
	
	public void deletePlayerMentions() {
		
		this.cassandraOperations.truncate("player_mention");
	}
}
