package org.rygn.nosqlbench.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.rygn.nosqlbench.redis.RedisConstants;

public class Tactic {

	private String label;
	
	private Integer nbGoalKeepers;
	
	private Integer nbDefenders;
	
	private Integer nbMidFields;
	
	private Integer nbForwards;

	public Map<String, String> toMap() {
		
		Map<String, String> result = new HashMap<>();
		
		result.put(RedisConstants.LABEL, this.label);
		
		result.put(RedisConstants.NB_GOAL_KEEPERS, this.nbGoalKeepers.toString());
		
		result.put(RedisConstants.NB_DEFENDERS, this.nbDefenders.toString());
		
		result.put(RedisConstants.NB_MIDFIELDS, this.nbMidFields.toString());
		
		result.put(RedisConstants.NB_FORWARDS, this.nbForwards.toString());
		
		return result;
	}
	
	public String getLabelAsKey() {
		
		return StringUtils.replace(this.label, RedisConstants.SPACE, RedisConstants.EMPTY);
	}
	
	public Tactic() {
		super();
	}

	public Tactic(String label, Integer nbGoalKeepers, Integer nbDefenders,
			Integer nbMidFields, Integer nbForwards) {
		super();
		this.label = label;
		this.nbGoalKeepers = nbGoalKeepers;
		this.nbDefenders = nbDefenders;
		this.nbMidFields = nbMidFields;
		this.nbForwards = nbForwards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result
				+ ((nbDefenders == null) ? 0 : nbDefenders.hashCode());
		result = prime * result
				+ ((nbForwards == null) ? 0 : nbForwards.hashCode());
		result = prime * result
				+ ((nbGoalKeepers == null) ? 0 : nbGoalKeepers.hashCode());
		result = prime * result
				+ ((nbMidFields == null) ? 0 : nbMidFields.hashCode());
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
		Tactic other = (Tactic) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (nbDefenders == null) {
			if (other.nbDefenders != null)
				return false;
		} else if (!nbDefenders.equals(other.nbDefenders))
			return false;
		if (nbForwards == null) {
			if (other.nbForwards != null)
				return false;
		} else if (!nbForwards.equals(other.nbForwards))
			return false;
		if (nbGoalKeepers == null) {
			if (other.nbGoalKeepers != null)
				return false;
		} else if (!nbGoalKeepers.equals(other.nbGoalKeepers))
			return false;
		if (nbMidFields == null) {
			if (other.nbMidFields != null)
				return false;
		} else if (!nbMidFields.equals(other.nbMidFields))
			return false;
		return true;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getNbGoalKeepers() {
		return nbGoalKeepers;
	}

	public void setNbGoalKeepers(Integer nbGoalKeepers) {
		this.nbGoalKeepers = nbGoalKeepers;
	}

	public Integer getNbDefenders() {
		return nbDefenders;
	}

	public void setNbDefenders(Integer nbDefenders) {
		this.nbDefenders = nbDefenders;
	}

	public Integer getNbMidFields() {
		return nbMidFields;
	}

	public void setNbMidFields(Integer nbMidFields) {
		this.nbMidFields = nbMidFields;
	}

	public Integer getNbForwards() {
		return nbForwards;
	}

	public void setNbForwards(Integer nbForwards) {
		this.nbForwards = nbForwards;
	}

	

	
	
	
}
