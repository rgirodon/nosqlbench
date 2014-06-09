package org.rygn.nosqlbench.mongodb;

import java.util.Collection;

import org.rygn.nosqlbench.domain.MUserSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDbDao {

	@Autowired
	@Qualifier("mongoTemplate")
	private MongoOperations mongoOperations;
	
	public void addUserSelection(MUserSelection userSelection) {
		
		this.mongoOperations.insert(userSelection);
	}
	
	public Collection<MUserSelection> retrieveAllUserSelections() {
		
		return this.mongoOperations.findAll(MUserSelection.class);
	}
	
	public MUserSelection retrieveUserSelectionForEmail(String email) {
		
		Query query = new Query(Criteria.where("email").is(email));
		
		return this.mongoOperations.findOne(query, MUserSelection.class);
	}

	public void deleteUserSelections() {
		
		this.mongoOperations.dropCollection(MUserSelection.class);
	}
}
