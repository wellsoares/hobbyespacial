package br.com.hobbyespacial.recursos;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobbyespacial.response.PlanetaResponse;
import br.com.hobbyespacial.spaceinfo.entidades.Planeta;
import br.com.hobbyespacial.spaceinfo.services.PlanetaService;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@PostMapping(path = "/{id}")
	public ResponseEntity<PlanetaResponse> findById(@PathVariable(name = "id") Long id) {
		PlanetaResponse planeta = planetaService.findById(id);
		if (Objects.isNull(planeta)) {
			return new ResponseEntity<PlanetaResponse>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PlanetaResponse>(planeta, HttpStatus.OK);
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<PlanetaResponse> salvar(@RequestBody PlanetaResponse planetaResponse) {
		boolean status = planetaService.salvar(planetaResponse);
		if(status) {
			return new ResponseEntity<PlanetaResponse>(HttpStatus.OK);
		}
		return new ResponseEntity<PlanetaResponse>(HttpStatus.BAD_REQUEST);
	}
}
