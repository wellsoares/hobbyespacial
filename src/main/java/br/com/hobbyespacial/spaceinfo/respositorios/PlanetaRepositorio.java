package br.com.hobbyespacial.spaceinfo.respositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hobbyespacial.spaceinfo.entidades.Planeta;

@Repository
public interface PlanetaRepositorio extends CrudRepository<Planeta, Long> {

	
}
