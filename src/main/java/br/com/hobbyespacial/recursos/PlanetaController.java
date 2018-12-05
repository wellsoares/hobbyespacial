package br.com.hobbyespacial.spaceinfo;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobbyespacial.spaceinfo.entidades.Planeta;
import br.com.hobbyespacial.spaceinfo.services.PlanetaService;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@PostMapping(path = "/{id}")
	public ResponseEntity<Planeta> findById(@PathVariable(name = "id") Long id) {
		Planeta planeta = planetaService.findById(id);
		if (Objects.isNull(planeta)) {
			return new ResponseEntity<Planeta>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Planeta>(planeta, HttpStatus.OK);
	}

	@GetMapping(path = "/todos")
	public Planeta findById() {
		Planeta planeta = new Planeta();
		planeta.setId(10L);
		return planeta;
	}
}
