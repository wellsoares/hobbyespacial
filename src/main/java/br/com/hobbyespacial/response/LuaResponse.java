package br.com.hobbyespacial.response;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class LuaResponse implements Serializable {
	
	private static final long serialVersionUID = -5824331478370326551L;
	
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
