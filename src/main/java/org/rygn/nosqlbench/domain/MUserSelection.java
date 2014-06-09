package org.rygn.nosqlbench.domain;

import java.util.HashSet;
import java.util.Set;

public class MUserSelection {

	private String id;

	private String email;
	
	private String formation;
	
	private Set<String> goalkeepers;
	
	private Set<String> defenders;
	
	private Set<String> midfields;
	
	private Set<String> forwards;

	public void addGoalKeeper(String name) {		
		this.goalkeepers.add(name);
	}

	public void addDefender(String name) {
		this.defenders.add(name);
	}

	public void addMidfield(String name) {
		this.midfields.add(name);
	}

	public void addForward(String name) {
		this.forwards.add(name);
	}
	
	public MUserSelection(String id, String email, String formation,
			Set<String> goalkeepers, Set<String> defenders,
			Set<String> midfields, Set<String> forwards) {
		super();
		this.id = id;
		this.email = email;
		this.formation = formation;
		this.goalkeepers = goalkeepers;
		this.defenders = defenders;
		this.midfields = midfields;
		this.forwards = forwards;
	}

	public MUserSelection() {
		super();
		
		this.goalkeepers = new HashSet<>();
		this.defenders = new HashSet<>();
		this.midfields = new HashSet<>();
		this.forwards = new HashSet<>();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((defenders == null) ? 0 : defenders.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((formation == null) ? 0 : formation.hashCode());
		result = prime * result
				+ ((forwards == null) ? 0 : forwards.hashCode());
		result = prime * result
				+ ((goalkeepers == null) ? 0 : goalkeepers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((midfields == null) ? 0 : midfields.hashCode());
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
		MUserSelection other = (MUserSelection) obj;
		if (defenders == null) {
			if (other.defenders != null)
				return false;
		} else if (!defenders.equals(other.defenders))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (forwards == null) {
			if (other.forwards != null)
				return false;
		} else if (!forwards.equals(other.forwards))
			return false;
		if (goalkeepers == null) {
			if (other.goalkeepers != null)
				return false;
		} else if (!goalkeepers.equals(other.goalkeepers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (midfields == null) {
			if (other.midfields != null)
				return false;
		} else if (!midfields.equals(other.midfields))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public Set<String> getGoalkeepers() {
		return goalkeepers;
	}

	public void setGoalkeepers(Set<String> goalkeepers) {
		this.goalkeepers = goalkeepers;
	}

	public Set<String> getDefenders() {
		return defenders;
	}

	public void setDefenders(Set<String> defenders) {
		this.defenders = defenders;
	}

	public Set<String> getMidfields() {
		return midfields;
	}

	public void setMidfields(Set<String> midfields) {
		this.midfields = midfields;
	}

	public Set<String> getForwards() {
		return forwards;
	}

	public void setForwards(Set<String> forwards) {
		this.forwards = forwards;
	}

	
	
	
}
