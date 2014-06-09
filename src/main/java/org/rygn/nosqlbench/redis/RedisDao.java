package org.rygn.nosqlbench.redis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.rygn.nosqlbench.domain.Tactic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDao {

	@Autowired
	private StringRedisTemplate template;
	
	@Resource(name="stringRedisTemplate")
	private HashOperations<String, String, String> hashOps;
	
	public void addTactic(Tactic tactic) {
		
		hashOps.putAll(RedisConstants.TACTIC + RedisConstants.SEPARATOR + tactic.getLabelAsKey(), tactic.toMap());
	}
	
	public Collection<Tactic> retrieveTactics() {
		
		Collection<Tactic> result = new HashSet<>();
		
		Set<String> tacticKeys = this.hashOps.getOperations().keys(RedisConstants.TACTIC + RedisConstants.SEPARATOR + RedisConstants.STAR);
		
		for (String tacticKey : tacticKeys) {
			
			Tactic tactic = this.retrieveTactic(tacticKey);
			
			result.add(tactic);
		}
		
		return result;
	}
	
	private Tactic retrieveTactic(String tacticKey) {
		
		Map<String, String> tacticAsMap = this.hashOps.entries(tacticKey);
		
		Tactic tactic = new Tactic(tacticAsMap.get(RedisConstants.LABEL),
									Integer.parseInt(tacticAsMap.get(RedisConstants.NB_GOAL_KEEPERS)),
									Integer.parseInt(tacticAsMap.get(RedisConstants.NB_DEFENDERS)),
									Integer.parseInt(tacticAsMap.get(RedisConstants.NB_MIDFIELDS)),
									Integer.parseInt(tacticAsMap.get(RedisConstants.NB_FORWARDS)));
		
		return tactic;
	}

	public void deleteTactics() {
		
		Set<String> tacticKeys = this.hashOps.getOperations().keys(RedisConstants.TACTIC + RedisConstants.SEPARATOR + RedisConstants.STAR);
				
		this.hashOps.getOperations().delete(tacticKeys);
	}
}
