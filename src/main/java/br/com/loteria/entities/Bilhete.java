package br.com.loteria.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// imports omitidos.

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bilhete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroBilhete;
	private LocalDate dataCriacao;

	@ManyToOne
	@JsonIgnore
	private Usuario usuario;
	
	//Itens abaixo omitidos;

	public Bilhete() {
		this.numeroBilhete = gerarBilhete();
		this.dataCriacao = LocalDate.now();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroBilhete() {
		return numeroBilhete;
	}

	public void setNumeroBilhete(Integer numeroBilhete) {
		this.numeroBilhete = numeroBilhete;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bilhete other = (Bilhete) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	private Integer gerarBilhete() {
		Random numero = new Random();
		return numero.nextInt(10000 - 1);
	}

	@Override
	public String toString() {
		return "Bilhete [id=" + id + ", numeroBilhete=" + numeroBilhete + ", dataCriacao=" + dataCriacao + ", usuario="
				+ usuario + "]";
	}

}
