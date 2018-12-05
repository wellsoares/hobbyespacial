package br.com.hobbyespacial.spaceinfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobbyespacial.spaceinfo.entidades.Planeta;
import br.com.hobbyespacial.spaceinfo.respositorios.PlanetaRepositorio;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepositorio planetaRepositorio;

	@Override
	public Planeta findById(Long id) {
		return planetaRepositorio.findById(id).get();
	}

}
