package br.com.hobbyespacial.spaceinfo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="LUA")
@SequenceGenerator(name = "PLANETA_SEQ", sequenceName = "PLANETA_SEQ") 
public class Lua implements Serializable{

	private static final long serialVersionUID = -5866138032428771608L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANETA_SEQ")
	private Long id;
	private String nome;
	private BigDecimal diametro;

}
