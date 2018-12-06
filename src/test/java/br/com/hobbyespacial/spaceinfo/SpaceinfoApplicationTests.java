package br.com.hobbyespacial.spaceinfo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hobbyespacial.spaceinfo.response.PlanetaResponse;
import br.com.hobbyespacial.spaceinfo.services.PlanetaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpaceinfoApplicationTests {

	@Autowired
	private PlanetaService planetaService;

	@Test
	public void findByIdTest() {

		PlanetaResponse p = planetaService.findById(999999L);
		Assert.assertEquals("TESTE", p.getNome());
	}
}
