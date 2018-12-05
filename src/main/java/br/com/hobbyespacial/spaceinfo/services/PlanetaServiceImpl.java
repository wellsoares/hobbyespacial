package br.com.hobbyespacial.spaceinfo.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hobbyespacial.response.PlanetaResponse;
import br.com.hobbyespacial.spaceinfo.entidades.Planeta;
import br.com.hobbyespacial.spaceinfo.respositorios.PlanetaRepositorio;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepositorio planetaRepositorio;

	@Override
	public PlanetaResponse findById(Long id) {
		PlanetaResponse planetaResponse = new PlanetaResponse();
		Planeta planeta = planetaRepositorio.findById(id).get();

		BeanUtils.copyProperties(planeta, planetaResponse);
		return planetaResponse;
	}

	@Override
	public boolean salvar(PlanetaResponse planetaResponse) {
		try {
			Planeta planeta = new Planeta();
			BeanUtils.copyProperties(planetaResponse, planeta);
			planetaRepositorio.save(planeta);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
