package br.com.hobbyespacial.spaceinfo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.hobbyespacial.spaceinfo.entity.Planeta;

@Repository
public interface PlanetaRepository extends PagingAndSortingRepository<Planeta, Long> {

	
}
