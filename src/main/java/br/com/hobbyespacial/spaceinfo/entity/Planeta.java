package br.com.hobbyespacial.spaceinfo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLANETA")
@SequenceGenerator(name = "PLANETA_SEQ", sequenceName = "PLANETA_SEQ") 
public class Planeta implements Serializable {

	private static final long serialVersionUID = -1211583375062691226L;

	@Id()
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANETA_SEQ")
	private Long id;
	private String nome;
	private BigDecimal diametro;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_planeta")
	private List<Lua> luas = new ArrayList<>();

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

	public List<Lua> getLuas() {
		return luas;
	}

	public void setLuas(List<Lua> luas) {
		this.luas = luas;
	}
}
