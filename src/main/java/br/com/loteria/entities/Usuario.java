package br.com.loteria.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "Email não é valido")
	@NotEmpty(message = "O campo email nao pode ser vazio")
	@NotNull(message = "O campo email não pode ser nulo")
	private String email;
	
	//@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Bilhete> bilhetes = new ArrayList<>();
	
	public Usuario() {
		
	}

	public Usuario(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Bilhete> getBilhetes() {
		return bilhetes;
	}

	public void setBilhetes(List<Bilhete> bilhetes) {
		this.bilhetes = bilhetes;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", bilhetes=" + bilhetes + "]";
	}
	
	
	

}
