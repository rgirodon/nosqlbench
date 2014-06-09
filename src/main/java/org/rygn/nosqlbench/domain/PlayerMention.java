package org.rygn.nosqlbench.domain;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "player_mention")
public class PlayerMention {

	@PrimaryKey 
	private PlayerMentionPrimaryKey pk;
	
	private String position;

	public PlayerMention(PlayerMentionPrimaryKey pk, String position) {
		super();
		this.pk = pk;
		this.position = position;
	}

	public PlayerMention() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		PlayerMention other = (PlayerMention) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	public PlayerMentionPrimaryKey getPk() {
		return pk;
	}

	public void setPk(PlayerMentionPrimaryKey pk) {
		this.pk = pk;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
