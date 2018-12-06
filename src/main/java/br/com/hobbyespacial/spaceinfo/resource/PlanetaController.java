package br.com.hobbyespacial.spaceinfo.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@ApiOperation(value = "Retorna planeta pelo ID", response = PlanetaResponse.class, notes = "Retorna o Planeta pelo ID especificado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um Planeta Response", response = PlanetaResponse.class),
			@ApiResponse(code = 500, message = "Caso ocorra erro retorna uma Exception", response = PlanetaResponse.class) })
	@PostMapping(path = "/{id}")
	public ResponseEntity<PlanetaResponse> findById(@PathVariable(name = "id") Long id) {
		PlanetaResponse planeta = planetaService.findById(id);
		if (Objects.isNull(planeta)) {
			return new ResponseEntity<PlanetaResponse>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PlanetaResponse>(planeta, HttpStatus.OK);
	}

	@ApiOperation(value = "Salva o novo planeta", response = PlanetaResponse.class, notes = "Recebe um novo planeta que é persistido através de uma fila")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna o Status OK caso sucesso", response = PlanetaResponse.class),
			@ApiResponse(code = 500, message = "Caso ocorra erro será retornado com Exception", response = PlanetaResponse.class) })
	@PostMapping("/salvar")
	public ResponseEntity<PlanetaResponse> salvar(@RequestBody PlanetaResponse planetaResponse) {
		try {
			jmsTemplate.convertAndSend("planeta.fila", planetaResponse);
			return new ResponseEntity<PlanetaResponse>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<PlanetaResponse>(planetaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Lista todos os planetas", response = PlanetaResponse.class, notes = "Lista os planetas de forma paginada")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna uma lista de PlanetaResponse", response = PlanetaResponse.class),
			@ApiResponse(code = 500, message = "Caso ocorra erro será retornado com Exception", response = PlanetaResponse.class) })
	@GetMapping("/listar")
	public ResponseEntity<List<PlanetaResponse>> listarTodos(@RequestParam("page") int pageIndex, 
																@RequestParam("size") int pageSize) {
		List<PlanetaResponse> planetas = new ArrayList<PlanetaResponse>();
		try {
			planetas = planetaService.listarTodos(PageRequest.of(pageIndex, pageSize));
			return new ResponseEntity<List<PlanetaResponse>>(planetas, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<PlanetaResponse>>(planetas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
