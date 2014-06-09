package org.rygn.nosqlbench.domain;

import java.io.Serializable;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class PlayerMentionPrimaryKey implements Serializable {

	@PrimaryKeyColumn(name = "player", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String player;
	
	@PrimaryKeyColumn(name = "selectioner_email", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
	private String selectionerEmail;

	public PlayerMentionPrimaryKey() {
		super();
	}

	public PlayerMentionPrimaryKey(String player, String selectionerEmail) {
		super();
		this.player = player;
		this.selectionerEmail = selectionerEmail;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime
				* result
				+ ((selectionerEmail == null) ? 0 : selectionerEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerMentionPrimaryKey other = (PlayerMentionPrimaryKey) obj;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (selectionerEmail == null) {
			if (other.selectionerEmail != null)
				return false;
		} else if (!selectionerEmail.equals(other.selectionerEmail))
			return false;
		return true;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getSelectionerEmail() {
		return selectionerEmail;
	}

	public void setSelectionerEmail(String selectionerEmail) {
		this.selectionerEmail = selectionerEmail;
	}
	
	
}
