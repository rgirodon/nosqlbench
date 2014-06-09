package org.rygn.nosqlbench.redis;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rygn.nosqlbench.domain.Tactic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:redis-beans.xml"})
public class TestRedisDao {

	@Autowired
	private RedisDao redisDao;
	
	@Before
	public void cleanAll() {
		
		this.redisDao.deleteTactics();
	}
	
	@Test
	public void testAddTactic() {
		
		Tactic tactic = new Tactic("4-4-2", 1, 4, 4, 4);
		
		this.redisDao.addTactic(tactic);
		
		Collection<Tactic> tactics = this.redisDao.retrieveTactics();
		
		assertEquals(1, tactics.size());
	}

}
