package br.com.hobbyespacial.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PlanetaResponse implements Serializable{

	private static final long serialVersionUID = 6700690593891213642L;
	
	private Long id;
	private String nome;
	private BigDecimal diametro;
	private List<LuaResponse> luas;
	
	
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
	public List<LuaResponse> getLuas() {
		return luas;
	}
	public void setLuas(List<LuaResponse> luas) {
		this.luas = luas;
	}
}
