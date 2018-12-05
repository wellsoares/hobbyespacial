package br.com.hobbyespacial.spaceinfo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.hobbyespacial.response.PlanetaResponse;

public interface PlanetaService {

	public PlanetaResponse findById(Long id);
	
	public boolean salvar(PlanetaResponse planeta);
	
	public List<PlanetaResponse> listarTodos(Pageable page);
	
}
