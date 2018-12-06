package br.com.hobbyespacial.spaceinfo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hobbyespacial.spaceinfo.entity.Planeta;
import br.com.hobbyespacial.spaceinfo.repository.PlanetaRepository;
import br.com.hobbyespacial.spaceinfo.response.PlanetaResponse;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepositorio;

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

	@Override
	public List<PlanetaResponse> listarTodos(Pageable page) {
		Page<Planeta> pagePlanetas = planetaRepositorio.findAll(page);
		List<Planeta> planetas = pagePlanetas.getContent();
		List<PlanetaResponse> planetasResponses = new ArrayList<>();
		
		planetas.forEach(p -> {
			PlanetaResponse pr = new PlanetaResponse();
			BeanUtils.copyProperties(p,pr);
			planetasResponses.add(pr);
		});
		
		return planetasResponses;
	}
}
