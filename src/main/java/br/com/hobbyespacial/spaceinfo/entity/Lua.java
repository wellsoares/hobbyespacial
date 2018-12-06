package br.com.hobbyespacial.spaceinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LUA")
@SequenceGenerator(name = "LUA_SEQ", sequenceName = "LUA_SEQ") 
public class Lua implements Serializable{

	private static final long serialVersionUID = -5866138032428771608L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LUA_SEQ")
	private Long id;
	private String nome;
	private BigDecimal diametro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getDiametro() {
		return diametro;
	}
	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}
}
