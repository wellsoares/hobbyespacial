package br.com.hobbyespacial.spaceinfo.resource;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hobbyespacial.spaceinfo.response.PlanetaResponse;
import br.com.hobbyespacial.spaceinfo.services.PlanetaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/planeta")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;

	@Autowired
	private JmsTemplate jmsTemplate;

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
		jmsTemplate.convertAndSend("planeta.fila", planetaResponse);
		return new ResponseEntity<PlanetaResponse>(HttpStatus.OK);
	}

	@ApiOperation(value = "Cadastrar uma nova pessoa", response = PlanetaResponse.class, notes = "Essa operação salva um novo registro com as informações de pessoa.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um ResponseModel com uma mensagem de sucesso", response = PlanetaResponse.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseModel com a Exception", response = PlanetaResponse.class) })
	@GetMapping("/listar")
	public ResponseEntity<List<PlanetaResponse>> listarTodos(Pageable pageable) {
		List<PlanetaResponse> planetas = planetaService.listarTodos(pageable);
		return new ResponseEntity<List<PlanetaResponse>>(planetas, HttpStatus.OK);
	}
}
