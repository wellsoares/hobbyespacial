package br.com.hobbyespacial.spaceinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="br.com.hobbyespacial")
public class SpaceinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceinfoApplication.class, args);
	}
}
