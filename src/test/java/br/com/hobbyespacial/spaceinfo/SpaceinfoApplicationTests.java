package br.com.hobbyespacial.spaceinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hobbyespacial.spaceinfo.services.PlanetaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceinfoApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger("JCG");

	@Autowired
	private PlanetaService planetaService;

	@Test
	public void contextLoads() {
		LOG.info("Current objects in DB: {}", planetaService.findById(1L).toString());
	}
}
