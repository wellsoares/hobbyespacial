package br.com.hobbyespacial.spaceinfo.services;

import br.com.hobbyespacial.response.PlanetaResponse;

public interface PlanetaService {

	public PlanetaResponse findById(Long id);
	
	public boolean salvar(PlanetaResponse planeta);
}
