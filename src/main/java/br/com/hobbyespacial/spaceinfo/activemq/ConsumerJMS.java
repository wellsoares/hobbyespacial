package br.com.hobbyespacial.spaceinfo.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import br.com.hobbyespacial.spaceinfo.response.PlanetaResponse;
import br.com.hobbyespacial.spaceinfo.services.PlanetaService;

@Component
public class ConsumerJMS {

	@Autowired
	private PlanetaService planetaService;

	@JmsListener(destination = "planeta.fila", containerFactory = "myFactory")
	public void receiveMessage(PlanetaResponse planetaResponse) {
		planetaService.salvar(planetaResponse);
	}
}
